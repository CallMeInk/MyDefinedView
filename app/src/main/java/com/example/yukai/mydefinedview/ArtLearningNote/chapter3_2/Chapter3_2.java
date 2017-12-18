package com.example.yukai.mydefinedview.ArtLearningNote.chapter3_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_2_layout);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        mTextView = (AutoMoveView) findViewById(R.id.tv);
        mTextView.setParentView(mRelativeLayout);
//        mButton = (Button) findViewById(R.id.btn1);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mRelativeLayout.scrollTo(-60, -100);
//            }
//        });
    }
}
