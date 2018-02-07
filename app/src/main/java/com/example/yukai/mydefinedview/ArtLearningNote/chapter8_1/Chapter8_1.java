package com.example.yukai.mydefinedview.ArtLearningNote.chapter8_1;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/2/7.
 */

public class Chapter8_1 extends Activity implements View.OnClickListener{

    private Button mFloatingButton;
    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;
    private Button mAddBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter8_1_layout);
        mAddBtn = (Button) findViewById(R.id.add_btn);
        mAddBtn.setOnClickListener(this);
    }

    private void showButton(){
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mFloatingButton = new Button(this);
        mFloatingButton.setText("floating button");
        mLayoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                1,
                0,
                PixelFormat.TRANSPARENT);
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        mLayoutParams.x = 100;
        mLayoutParams.y = 300;
        mWindowManager.addView(mFloatingButton, mLayoutParams);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.add_btn){
            showButton();
        }
    }
}
