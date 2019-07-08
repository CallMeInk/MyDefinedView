package com.example.yukai.mydefinedview.WorkTest.WorkUITest;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

public class WorkUITestActivity extends Activity implements View.OnClickListener{

    private ImageView mTabIv;
    private ImageView mBubbleIv;
    private Button mStartButton;
    private ValueAnimator mTabAnimator;
    private ValueAnimator mBubbleAnimator;
    private final float BUBBLE_WIDTH = DeviceUtils.getPixelFromDp(28);
    private final float BUBBLE_HEIGHT = DeviceUtils.getPixelFromDp(30);
    private View mScaleAnimationView;
    private ScaleAnimation mAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_ui_test_activity);
        mTabIv = (ImageView) findViewById(R.id.tab);
        mBubbleIv = (ImageView) findViewById(R.id.bubble);
        mTabIv.setVisibility(View.GONE);
        mBubbleIv.setVisibility(View.GONE);
        mStartButton = (Button) findViewById(R.id.start_button);
        mStartButton.setOnClickListener(this);
        mTabAnimator = ValueAnimator.ofFloat(0f, 1f);
        mTabAnimator.setDuration(1000);
        mTabAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mTabIv.setAlpha(value);
            }
        });
        mTabAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mBubbleIv.setVisibility(View.VISIBLE);
                mBubbleAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


        mBubbleAnimator = ValueAnimator.ofFloat(0f, 1f);
        mBubbleAnimator.setDuration(1000);
        mBubbleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mBubbleIv.setAlpha(value);
                float width = BUBBLE_WIDTH * value;
                float height = BUBBLE_HEIGHT * value;
                ViewGroup.LayoutParams layoutParams = mBubbleIv.getLayoutParams();
                layoutParams.width = (int) width;
                layoutParams.height = (int) height;
                mBubbleIv.setLayoutParams(layoutParams);
            }
        });

        mScaleAnimationView = findViewById(R.id.scale_animation_view);
        mAnimation = new ScaleAnimation(1, 2, 1, 2, DeviceUtils.getScreenWidth() / 2, 0);
        mAnimation.setDuration(1000);
    }

    @Override
    public void onClick(View v) {
        mTabIv.setVisibility(View.VISIBLE);
        mTabAnimator.start();
        mScaleAnimationView.startAnimation(mAnimation);
    }
}
