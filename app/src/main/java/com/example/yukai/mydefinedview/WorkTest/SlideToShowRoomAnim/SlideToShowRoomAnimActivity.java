package com.example.yukai.mydefinedview.WorkTest.SlideToShowRoomAnim;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

/**
 * Created by yukai on 2018/8/1.
 */

public class SlideToShowRoomAnimActivity extends Activity{

    private RecyclerView mRecyclerView;
    private RoomAnimAdapter mAdapter;
    private ValueAnimator animator;
    private TextView mFakeText;
    private ImageView mFakeImage;
    private Button mButton;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_to_show_room_anim_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.show_room_anim_recycler_view);
        mFakeText = (TextView) findViewById(R.id.fake_text);
        mFakeImage = (ImageView) findViewById(R.id.image);
        mButton = (Button) findViewById(R.id.btn_start);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAdapter = new RoomAnimAdapter(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
    }

    private void startAnimation(){
        animator = new ValueAnimator();
        animator.setTarget(mFakeText);
        //animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int alphaInt = (Integer) animation.getAnimatedValue();
                Log.e("yk", "alphaInt::" + alphaInt);
                if (alphaInt > 200){
                    setVisibility(false);
                    return;
                }
                if (alphaInt <= 1){
                    setVisibility(false);
                    doScroll();
                    return;
                }
                setVisibility(true);
                float alpha;
                if (alphaInt > 100){
                    alpha = (alphaInt - 100) * 1.0f / 200 + 0.5f;
                }else{
                    alpha = (100 - alphaInt) * 1.0f / 200 + 0.5f;
                }
                mFakeText.setAlpha(alpha);
                mFakeImage.setAlpha(alpha);
            }
        });
        animator.setIntValues(300, 0);
        animator.start();
    }

    private void setVisibility(boolean state){
        mRecyclerView.setVisibility(state ? View.GONE : View.VISIBLE);
        mFakeText.setVisibility(state ? View.VISIBLE : View.GONE);
        mFakeImage.setVisibility(state ? View.VISIBLE : View.GONE);
        setText();
    }

    private void doScroll(){
        mRecyclerView.smoothScrollBy(0, DeviceUtils.getPixelFromDp(20));
        animator.cancel();
        //animator.setIntValues(300, 0);
        if (this.isFinishing()){
            return;
        }
        animator.start();
        count++;
    }

    private void setText(){
        mFakeText.setText(count % 2 == 0 ? "上滑查看房型" : "$12345");
    }

}
