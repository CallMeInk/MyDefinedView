package com.example.yukai.mydefinedview.ArtLearningNote.chapter3_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2017/12/18.
 */

public class Chapter3_2 extends Activity{

    private AutoMoveView mTextView;
    private RelativeLayout mRelativeLayout;
    private Button mButton;
    private TextView mTestView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_2_layout);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        mTextView = (AutoMoveView) findViewById(R.id.tv);
        mTextView.setParentView(mRelativeLayout);
        mTestView = (TextView) findViewById(R.id.test_view);
        mTestView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.e("yk", "down");
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        Log.e("yk", "move");
                        return false;
                    default:
                        break;
                }
                return false;
            }
        });
//        mButton = (Button) findViewById(R.id.btn1);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mRelativeLayout.scrollTo(-60, -100);
//            }
//        });
    }
}
