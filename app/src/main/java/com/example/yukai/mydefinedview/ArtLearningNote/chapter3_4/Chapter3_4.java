package com.example.yukai.mydefinedview.ArtLearningNote.chapter3_4;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/1/2.
 */

public class Chapter3_4 extends Activity implements View.OnClickListener{

    private DispatchTestLayout mDispatchTestLayout;
    private Button mButton;
    private Button mButton1;
    private Button mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_4_layout);
        mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(this);
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("yk", "onTouch execute:: event::" + event.getAction());
                return true;
            }
        });
        mDispatchTestLayout = (DispatchTestLayout) findViewById(R.id.dispatch_test_layout);
        mButton1 = (Button) findViewById(R.id.btn1);
        mButton2 = (Button) findViewById(R.id.btn2);
        mDispatchTestLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("yk", "dispatchLayout ontouch");
                return false;
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("yk", "mButton1 onClick");
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("yk", "mButton2 onClick");
            }
        });
    }

    @Override
    public void onClick(View v) {
        Log.e("yk", "onclick execute");
    }
}
