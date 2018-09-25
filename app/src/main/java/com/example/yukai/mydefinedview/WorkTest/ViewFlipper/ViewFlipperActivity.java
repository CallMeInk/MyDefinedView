package com.example.yukai.mydefinedview.WorkTest.ViewFlipper;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.yukai.mydefinedview.R;

public class ViewFlipperActivity extends Activity{

    private ViewFlipper mViewFlipper;
    private View view1;
    private View view2;
    private Button btn;
    private TextView mFlipperOneText;
    private ValueAnimator animator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_flipper_activity_layout);
        mViewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        btn = (Button) findViewById(R.id.view_flipper_start_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewFlipper.startFlipping();
            }
        });
        findViewById(R.id.change_text_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFlipperOneText.setText("changed");
            }
        });
        view1 = LayoutInflater.from(this).inflate(R.layout.view_flipper_layout_one, mViewFlipper, false);
        mFlipperOneText = (TextView) view1.findViewById(R.id.flipper_one_text);
        view2 = LayoutInflater.from(this).inflate(R.layout.view_flipper_layout_two, mViewFlipper, false);
        mViewFlipper.addView(view1);
        mViewFlipper.addView(view2);

        mViewFlipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("yk", "in onAnimationStart");
                animator.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e("yk", "in onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("yk", "in onAnimationRepeat");
            }
        });

        mViewFlipper.getOutAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                Log.e("yk", "out onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                Log.e("yk", "out onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
//                Log.e("yk", "out onAnimationRepeat");
            }
        });

        animator = new ValueAnimator();
        animator.setDuration(1500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int alphaInt = (Integer) animation.getAnimatedValue();
                if (alphaInt > 100){
                    return;
                }
                if (alphaInt > 50){
                    view1.setAlpha((alphaInt * 1.0f - 50) / 100 + 0.5f);
                }else{
                    view1.setAlpha((50 - alphaInt * 1.0f) / 100 + 0.5f);
                }

            }
        });
        animator.setIntValues(300, 0);

    }
}
