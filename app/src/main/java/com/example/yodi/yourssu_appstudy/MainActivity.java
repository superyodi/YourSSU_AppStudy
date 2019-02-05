package com.example.yodi.yourssu_appstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.Change_button);

        mRecyclerView = findViewById(R.id.Recycler_View);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<MyItem> MyItemArrayList = new ArrayList<>();
        MyItemArrayList.add(new MyItem(R.drawable.a, "라이언", "사자임"));
        MyItemArrayList.add(new MyItem(R.drawable.b, "무지", "토끼옷을 입은 단무지임"));
        MyItemArrayList.add(new MyItem(R.drawable.c, "어피치", "어! 복숭아임"));
        MyItemArrayList.add(new MyItem(R.drawable.d, "프로도", "개임"));
        MyItemArrayList.add(new MyItem(R.drawable.e, "네오", "고양이임"));
        MyItemArrayList.add(new MyItem(R.drawable.f, "튜브", "오리임"));
        MyItemArrayList.add(new MyItem(R.drawable.g, "제이지", "얜머임?"));
        MyItemArrayList.add(new MyItem(R.drawable.h, "콘", "악어임"));

        MyAdapter myAdapter = new MyAdapter(MyItemArrayList);

        mRecyclerView.setAdapter(myAdapter);

    }

    public void Onclick(View view) {
        Toast.makeText(this, "아무 일도 일어나지 않았다.", Toast.LENGTH_LONG).show();
    }
}