package com.example.yukai.mydefinedview.WorkTest.TouchEventTest;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyTouchEventViewPager extends ViewPager{

    private View mNeedHandleTouchEventView;

    public MyTouchEventViewPager(Context context){
        super(context);
    }

    public MyTouchEventViewPager(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mNeedHandleTouchEventView != null){
            mNeedHandleTouchEventView.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setNeedHandleTouchEventView(View view){
        mNeedHandleTouchEventView = view;
    }

}
