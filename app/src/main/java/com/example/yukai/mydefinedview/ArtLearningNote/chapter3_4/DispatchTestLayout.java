package com.example.yukai.mydefinedview.ArtLearningNote.chapter3_4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by yukai on 2018/1/3.
 */

public class DispatchTestLayout extends LinearLayout{

    public DispatchTestLayout(Context context) {
        super(context);
    }

    public DispatchTestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
