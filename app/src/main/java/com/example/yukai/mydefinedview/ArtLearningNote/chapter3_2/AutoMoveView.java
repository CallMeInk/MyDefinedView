package com.example.yukai.mydefinedview.ArtLearningNote.chapter3_2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.yukai.mydefinedview.Utils.CommonUtils;

import java.util.jar.Attributes;

/**
 * Created by yukai on 2017/12/18.
 */

public class AutoMoveView extends TextView{

    private int mLastX = 0;
    private int mLastY = 0;
    private Scroller mScroller;
    private View mParentView;

    public AutoMoveView(Context context){
        super(context);
        init();
    }

    public AutoMoveView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    public AutoMoveView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init();
    }

    private void init(){
        mScroller = new Scroller(getContext());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        CommonUtils.log("x : " + x + "  y : " + y);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                mParentView.scrollBy(-deltaX, -deltaY);
                //mScroller.startScroll(mLastX, mLastY, deltaX, deltaY);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            default:
                    break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void setParentView(ViewGroup viewGroup){
        mParentView = viewGroup;
    }
}
