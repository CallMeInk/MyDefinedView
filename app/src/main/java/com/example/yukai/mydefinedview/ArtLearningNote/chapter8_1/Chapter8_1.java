package com.example.yukai.mydefinedview.ArtLearningNote.chapter8_1;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/2/7.
 */

public class Chapter8_1 extends Activity implements View.OnClickListener{

    private TextView mFloatingButton;
    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;
    private Button mAddBtn;
    private Button mRemoceBtn;
    private boolean hasWindow = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter8_1_layout);
        mAddBtn = (Button) findViewById(R.id.add_btn);
        mAddBtn.setOnClickListener(this);
        mRemoceBtn = (Button) findViewById(R.id.remove_btn);
        mRemoceBtn.setOnClickListener(this);
    }

    private void showButton(){
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mFloatingButton = new TextView(this);
        mFloatingButton.setText("floating button");
        mFloatingButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        Log.e("yk", "action down");
                        return false;
                    case MotionEvent.ACTION_MOVE:
                        Log.e("yk", "action move");
                        int x = (int)event.getRawX();
                        int y = (int)event.getRawY();
                        mLayoutParams.x = x;
                        mLayoutParams.y = y;
                        mWindowManager.updateViewLayout(mFloatingButton, mLayoutParams);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        mLayoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0,
                0,
                PixelFormat.TRANSPARENT);
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        mLayoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        mLayoutParams.x = 100;
        mLayoutParams.y = 300;
        mWindowManager.addView(mFloatingButton, mLayoutParams);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.add_btn && !hasWindow){
            showButton();
            hasWindow = true;
        }else if (id == R.id.remove_btn && hasWindow){
            mWindowManager.removeView(mFloatingButton);
            hasWindow = false;
        }
    }
}
