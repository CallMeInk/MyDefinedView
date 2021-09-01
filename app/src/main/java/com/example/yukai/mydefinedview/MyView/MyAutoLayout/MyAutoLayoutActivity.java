package com.example.yukai.mydefinedview.MyView.MyAutoLayout;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/1/8.
 */

public class MyAutoLayoutActivity extends Activity{

    private MyAutoLayout mMyAutoLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_auto_layout_activity_layout);
        mMyAutoLayout = (MyAutoLayout) findViewById(R.id.my_auto_layout);
        mMyAutoLayout.setMaxLines(2);
        mockData();
    }

    private void mockData(){
        int N = 10;
        mMyAutoLayout.removeAllViews();
        for (int i = 0;i < N;i++){
            View view = LayoutInflater.from(this).inflate(R.layout.recycler_view_item, mMyAutoLayout, false);
            TextView textView = (TextView) view.findViewById(R.id.recycler_view_item_iv);
            textView.setText("asdfadsfasdfasdfasdfafa" + "::::" + i);
            mMyAutoLayout.addView(view);
        }
    }

}
