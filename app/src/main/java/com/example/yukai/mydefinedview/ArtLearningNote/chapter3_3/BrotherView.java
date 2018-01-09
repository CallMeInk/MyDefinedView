package com.example.yukai.mydefinedview.ArtLearningNote.chapter3_3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

import com.example.yukai.mydefinedview.Utils.CommonUtils;

/**
 * Created by yukai on 2018/1/9.
 */

public class BrotherView extends ViewGroup{

    private int mTouchSlop;
    private Context mContext;
    private int rawX;
    private int x;
    private int mLastX;
    private Scroller mScroller;
    private int mLeftBoard;
    private int mRightBoard;

    public BrotherView(Context context){
        super(context);
        mContext = context;
        init();
    }

    public BrotherView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mContext = context;
        init();
    }

    public BrotherView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        mContext = context;
        init();
    }

    private void init(){
        mScroller = new Scroller(mContext);
        mTouchSlop = ViewConfiguration.get(mContext).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch(ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                rawX = (int)ev.getRawX();
                x = (int)ev.getX();
                mLastX = rawX;
                CommonUtils.log("onInterceptTouchEvent :: rawx :: " + rawX);
                CommonUtils.log("onInterceptTouchEvent :: x :: " + x);
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int)ev.getRawX();
                int delta = Math.abs(mLastX - moveX);
                mLastX = moveX;
                if (delta > mTouchSlop){
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                CommonUtils.log("ontouchEvent:: ACTION_DOWN");
                //break;
                return true;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int)event.getRawX();
                int scrolledX = mLastX - moveX;
                if (getScrollX() + scrolledX < mLeftBoard){
                    scrollTo(mLeftBoard, 0);
                    return true;
                }else if (getScrollX() + scrolledX + getWidth() > mRightBoard){
                    scrollTo(mRightBoard - getWidth(), 0);
                    return true;
                }
                scrollBy(scrolledX, 0);
                mLastX = moveX;
                break;
            case MotionEvent.ACTION_UP:
                int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();
                int deltaX = targetIndex * getWidth() - getScrollX();
                mScroller.startScroll(getScrollX(), 0, deltaX, 0);
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0;i < childCount;i++){
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (!changed){
            return;
        }
        int childCount = getChildCount();
        int left = 0;
        for (int i = 0;i < childCount;i++){
            View childView = getChildAt(i);
            childView.layout(left, 0, left + childView.getMeasuredWidth(), childView.getMeasuredHeight());
            left += childView.getMeasuredWidth();
        }
        if (childCount == 0){
            mLeftBoard = 0;
            mRightBoard = getWidth();
        }else{
            mLeftBoard = getChildAt(0).getLeft();
            mRightBoard = getChildAt(childCount - 1).getRight();
        }
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            CommonUtils.log("in computeScoll");
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}
