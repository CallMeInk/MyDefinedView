package com.example.yukai.mydefinedview.WorkTest.TouchEventTest;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.yukai.mydefinedview.R;

public class TouchEventTestActivity extends Activity{

    private MyTouchEventViewPager mViewPagerOne;
    private ViewPager mViewPagerTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_event_test_activity_layout);
        mViewPagerOne = (MyTouchEventViewPager) findViewById(R.id.pager_one);
        mViewPagerTwo = (ViewPager) findViewById(R.id.pager_two);
        mViewPagerOne.setNeedHandleTouchEventView(mViewPagerTwo);
        mViewPagerOne.setAdapter(new MyPagerAdapter(this));
        mViewPagerTwo.setAdapter(new MyPagerAdapter(this));
    }
}
