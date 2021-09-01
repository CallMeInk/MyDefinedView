package com.example.yukai.mydefinedview.BasicView.AnimTest;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
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
    private ListView mAnimationListView;
    private ObjectAnimator animator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_test_activity_layout);
        mAlphaBtn = (Button) findViewById(R.id.btn_alpha);
        mScaleBtn = (Button) findViewById(R.id.btn_scale);
        mRotateBtn = (Button) findViewById(R.id.btn_rotate);
        mTransBtn = (Button) findViewById(R.id.btn_trans);
        mTextView = (TextView) findViewById(R.id.anim_tv);
        mAnimationListView = (ListView) findViewById(R.id.animation_list_view);
        mAnimationListView.setAdapter(new AnimationAdapter());
        mAlphaBtn.setOnClickListener(this);
        mScaleBtn.setOnClickListener(this);
        mRotateBtn.setOnClickListener(this);
        mTransBtn.setOnClickListener(this);
        (findViewById(R.id.btn_pause)).setOnClickListener(this);
        (findViewById(R.id.btn_resume)).setOnClickListener(this);
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
            animator = ObjectAnimator.ofFloat(mTextView, "translationX", 0, -500);
            animator.setDuration(10000);
            animator.start();
            mTextView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.e("yk", "mtext getx::" + mTextView.getX());
                }
            },2000);
            mTextView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.e("yk", "mtext getx::" + mTextView.getX());
                }
            },3000);
            mTextView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.e("yk", "mtext getx::" + mTextView.getX());
                }
            },4000);
//            Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_test);
//            mTextView.startAnimation(animation);
        }else if (id == R.id.btn_pause){
            animator.pause();
        }else if (id == R.id.btn_resume){
            animator.resume();
        }
    }

    class AnimationAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(AnimTestActivity.this);
            ViewGroup.LayoutParams ll = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(ll);
            textView.setText(position + "");
            return textView;
        }
    }
}
