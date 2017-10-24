package com.example.yukai.mydefinedview.BasicView.Grid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;

/**
 * Created by yukai on 2017/10/24.
 */

public class GridViewActivity extends Activity{

    private GridView mGridView;
    private ArrayList<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_activity);
        mGridView = (GridView) findViewById(R.id.grid_view);
        MyGridViewAdapter adapter = new MyGridViewAdapter(this, mDatas);
        initDatas();
        mGridView.setAdapter(adapter);
    }

    private void initDatas(){
        int n = 80;
        for (int i = 0; i < n; i++){
            mDatas.add(i + "");
        }
    }
}
