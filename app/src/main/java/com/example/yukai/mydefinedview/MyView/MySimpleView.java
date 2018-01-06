package com.example.yukai.mydefinedview.MyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yukai on 2018/1/6.
 */

public class MySimpleView extends ViewGroup{

    public MySimpleView(Context context){
        super(context);
    }

    public MySimpleView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public MySimpleView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 0){
            View view = getChildAt(0);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0){
            View view = getChildAt(0);
            view.layout(100, 100, view.getMeasuredWidth() + 100, view.getMeasuredHeight() + 100);
        }
    }
}
