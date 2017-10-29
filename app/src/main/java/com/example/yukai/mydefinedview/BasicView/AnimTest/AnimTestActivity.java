package com.example.yukai.mydefinedview.BasicView.AnimTest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2017/10/29.
 */

public class AnimTestActivity extends Activity implements View.OnClickListener{

    private Button mAlphaBtn;
    private Button mScaleBtn;
    private Button mRotateBtn;
    private Button mTransBtn;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_test_activity_layout);
        mAlphaBtn = (Button) findViewById(R.id.btn_alpha);
        mScaleBtn = (Button) findViewById(R.id.btn_scale);
        mRotateBtn = (Button) findViewById(R.id.btn_rotate);
        mTransBtn = (Button) findViewById(R.id.btn_trans);
        mTextView = (TextView) findViewById(R.id.anim_tv);
        mAlphaBtn.setOnClickListener(this);
        mScaleBtn.setOnClickListener(this);
        mRotateBtn.setOnClickListener(this);
        mTransBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_alpha){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_test);
            mTextView.startAnimation(animation);
        }else if (id == R.id.btn_scale){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale_test);
            animation.setFillEnabled(true);
            //fillafter fillbefore 只有在java里写有用 xml里没用
            animation.setFillAfter(true);
            animation.setFillBefore(false);
            mTextView.startAnimation(animation);
        }else if (id == R.id.btn_rotate){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_test);
            animation.setFillEnabled(true);
            animation.setFillAfter(true);
            animation.setFillBefore(false);
            mTextView.startAnimation(animation);
        }else if (id == R.id.btn_trans){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_test);
            mTextView.startAnimation(animation);
        }
    }
}
