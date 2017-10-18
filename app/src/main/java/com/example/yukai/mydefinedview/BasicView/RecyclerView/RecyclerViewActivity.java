package com.example.yukai.mydefinedview.BasicView.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;

/**
 * Created by yukai on 2017/10/18.
 */

public class RecyclerViewActivity extends Activity{

    private ArrayList<String> mDatas;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_test_layout);
        initDatas();
        mAdapter = new MyRecyclerViewAdapter(mDatas, this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initDatas(){
        mDatas = new ArrayList<String>();
        for(char i = 'a';i < 'z';i++){
            mDatas.add(i + "");
        }
    }
}
