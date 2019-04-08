package com.example.yodi.yourssu_appstudy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    Document doc = null;

    private MyAdapter myAdapter;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutMavager;
    Button button;
    Button button2;
    TextView textView;
    int search;
    String discription = "";
    ArrayList<MyItem> myData;
    String arr[] = {"2370012300", "2370012400", "2370013901", "2370014001", "2370014002", "2370015300", "2370015400",
            "2370016500", "2370016600", "2510025900", "2510026000", "2510030501", "2510030502", "2510030601", "2510048700"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutMavager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutMavager);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myData = new ArrayList<>();
                for(search=0;search<8;search++) {
                    GetXMLTask xmlTask = new GetXMLTask();
                    xmlTask.execute("http://bd.kma.go.kr/openAPI/roadweather/getStdNodeLinkInfo?"
                            + "serviceKey=fw%2ByV2n1IyQL4UwVfrHZJTAwSUvUWW6xSBqxasK6VsqeyEYnCiWxcHiGhon7N8sbHIVoYfCQzsLdxr4ui%2Bp9ow%3D%3D&"
                            + "stdLinkId=" + arr[search] + "&hhCode=00&type=xml");
                }

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter = new MyAdapter(myData);
                mRecyclerView.setAdapter(myAdapter);

            }
        });

        //custom view를 이용하여 프로젝트 만들기
    }

    private class GetXMLTask extends AsyncTask<String, Void, Document> {

        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

            protected void onPostExecute (Document doc){
                super.onPostExecute(doc);
                discription = "";
                NodeList nodeList = doc.getElementsByTagName("items");

                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    Element fstElmnt = (Element) node;

                    NodeList Date = fstElmnt.getElementsByTagName("baseDate");
                    discription = discription + "날짜 " + Date.item(0).getChildNodes().item(0).getNodeValue() + " ";

                    NodeList Time = fstElmnt.getElementsByTagName("baseTime");
                    discription = discription + "시간 " + Time.item(0).getChildNodes().item(0).getNodeValue() + "\n";

                    NodeList Name = fstElmnt.getElementsByTagName("cctvNm");
                    discription = discription + "장소 " + Name.item(0).getChildNodes().item(0).getNodeValue() + " ";

                    NodeList weather = fstElmnt.getElementsByTagName("weatherNm");
                    discription = discription + "날씨 " + weather.item(0).getChildNodes().item(0).getNodeValue();

                }
                textView.setText("불러오기 성공");
                myData.add(new MyItem(R.drawable.ic_launcher_background, discription));
            }
        }
    }

