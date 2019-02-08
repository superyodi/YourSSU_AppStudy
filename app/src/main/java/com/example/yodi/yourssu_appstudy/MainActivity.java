package com.example.yodi.yourssu_appstudy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private static String TAG = "RecyclerView_Fruit";

    private ArrayList<Fruit> mFruitList;
    private Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManger;
    private int count = 0;
    private String engFruit;
    private String korFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mLinearLayoutManger = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManger);

        mFruitList = new ArrayList<>();

        mAdapter = new Adapter(mFruitList);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration((mRecyclerView.getContext()), mLinearLayoutManger.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Fruit fruit;
                switch(count)
                {
                    case 0:
                        engFruit = "Apple";
                        korFruit = "사과";
                        fruit = new Fruit(count+"",engFruit, korFruit);
                        mFruitList.add(fruit);
                        count++;
                        break;
                    case 1:
                        engFruit = "Orange";
                        korFruit = "오렌지";
                        fruit = new Fruit(count+"",engFruit, korFruit);
                        mFruitList.add(fruit);
                        count++;
                        break;
                    case 2:
                        engFruit = "Grape";
                        korFruit = "포도";
                        fruit = new Fruit(count+"",engFruit, korFruit);
                        mFruitList.add(fruit);
                        count++;
                        break;
                    case 3:
                        engFruit = "tangerine";
                        korFruit = "귤";
                        fruit = new Fruit(count+"",engFruit, korFruit);
                        mFruitList.add(fruit);
                        count++;
                        break;
                    case 4:
                        engFruit = "Strawberry";
                        korFruit = "딸기";
                        fruit = new Fruit(count+"",engFruit, korFruit);
                        mFruitList.add(fruit);
                        count++;
                        break;
                    case 5:
                        engFruit = "Watermelon";
                        korFruit = "수박";
                        fruit = new Fruit(count+"",engFruit, korFruit);
                        mFruitList.add(fruit);
                        count++;
                        break;
                    case 6:
                        engFruit = "Banana";
                        korFruit = "바나나";
                        fruit = new Fruit(count+"",engFruit, korFruit);
                        mFruitList.add(fruit);
                        count = 0;
                        break;

                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
