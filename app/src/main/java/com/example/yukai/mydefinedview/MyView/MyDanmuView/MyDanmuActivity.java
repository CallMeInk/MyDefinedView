package com.example.yukai.mydefinedview.MyView.MyDanmuView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by yukai on 2018/2/22.
 */

public class MyDanmuActivity extends Activity{

    private MyDanmuView mMyDanmuView;
    private EditText mEditText;
    private Button mButton;
    private ArrayList<BarrageDataModel> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_danmu_view_activity_layout);
        initData();
        mMyDanmuView = (MyDanmuView) findViewById(R.id.my_danmu_view);
        mMyDanmuView.setData(mData);
        mEditText = (EditText) findViewById(R.id.edit_view);
        mButton = (Button) findViewById(R.id.send_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMyDanmuView == null || mEditText == null){
                    return;
                }
                //mMyDanmuView.addItemView(mEditText.getText().toString(), MyDanmuView.INPUT_TYPE.TYPE_USER);
            }
        });

        findViewById(R.id.pause_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMyDanmuView == null){
                    return;
                }
                mMyDanmuView.pause();
            }
        });

        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMyDanmuView == null){
                    return;
                }
                mMyDanmuView.start();
            }
        });

        findViewById(R.id.hide_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMyDanmuView == null){
                    return;
                }
                mMyDanmuView.hide();
            }
        });

        findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMyDanmuView == null){
                    return;
                }
                mMyDanmuView.show();
            }
        });
    }

    private void initData(){
        if (mData == null){
            mData = new ArrayList<BarrageDataModel>();
        }
        mData.clear();
        for (int i = 0; i < 1000; i++){
            BarrageDataModel model = new BarrageDataModel();
            if (i % 5 == 0){
                model.text = "akjsdhfajshfajksdfhhfadfhaldf";
            }else{
                model.text = "this is " + i + "th danmu";
            }
            mData.add(model);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMyDanmuView != null){
            mMyDanmuView.onDestroy();
        }
    }
}
