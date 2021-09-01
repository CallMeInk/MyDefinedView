package com.example.yukai.mydefinedview.ArtLearningNote.chapter3_1;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2017/12/12.
 */

public class Chapter3_1 extends Activity implements View.OnTouchListener{

    private TextView mTouchSlopTextView;
    private TextView mSpeedInfoTv;
    private TextView mGestureDetect;
    private VelocityTracker mVelocityTracker;
    private int mMaxVelocity;
    private int mPointerId;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3_1_layout);
        mTouchSlopTextView = (TextView) findViewById(R.id.touch_slop);
        mGestureDetect = (TextView) findViewById(R.id.gesture_detect);
        mSpeedInfoTv = (TextView) findViewById(R.id.speed_info_tv);
        int touchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        mTouchSlopTextView.setText(String.format("touchSlop :: %d",touchSlop));
        mMaxVelocity = ViewConfiguration.get(this).getScaledMaximumFlingVelocity();
        mGestureDetector = new GestureDetector(this, new GestureListener());
        mGestureDetect.setFocusable(true);
        mGestureDetect.setClickable(true);
        mGestureDetect.setLongClickable(true);
        mGestureDetect.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        acquireVelocityTracker(event);
        final VelocityTracker verTracker = mVelocityTracker;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //求第一个触点的id， 此时可能有多个触点，但至少一个
                mPointerId = event.getPointerId(0);
                break;

            case MotionEvent.ACTION_MOVE:
                //求伪瞬时速度
                verTracker.computeCurrentVelocity(1000, mMaxVelocity);
                final float velocityX = verTracker.getXVelocity(mPointerId);
                final float velocityY = verTracker.getYVelocity(mPointerId);
                recodeInfo(velocityX, velocityY);
                break;

            case MotionEvent.ACTION_UP:
                releaseVelocityTracker();
                break;

            case MotionEvent.ACTION_CANCEL:
                releaseVelocityTracker();
                break;

            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     *
     * @param event 向VelocityTracker添加MotionEvent
     *
     * @see android.view.VelocityTracker#obtain()
     * @see android.view.VelocityTracker#addMovement(MotionEvent)
     */
    private void acquireVelocityTracker(final MotionEvent event) {
        if(mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);
    }

    /**
     * 释放VelocityTracker
     *
     * @see android.view.VelocityTracker#clear()
     * @see android.view.VelocityTracker#recycle()
     */
    private void releaseVelocityTracker() {
        if(mVelocityTracker != null) {
            mVelocityTracker.clear();
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private static final String sFormatStr = "velocityX=%f\nvelocityY=%f";

    /**
     * 记录当前速度
     *
     * @param velocityX x轴速度
     * @param velocityY y轴速度
     */
    private void recodeInfo(final float velocityX, final float velocityY) {
        final String info = String.format(sFormatStr, velocityX, velocityY);
        mSpeedInfoTv.setText(info);
    }

    private class GestureListener implements GestureDetector.OnGestureListener{

        public boolean onDown(MotionEvent e) {
            Log.e("yk", "onDown");
            return false;
        }

        public void onShowPress(MotionEvent e) {
            Log.e("yk", "onShowPress");
        }

        public boolean onSingleTapUp(MotionEvent e) {
            Log.e("yk", "onSingleTapUp");
            return false;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.e("yk", "onScroll");
            return false;
        }

        public void onLongPress(MotionEvent e) {
            Log.e("yk", "onLongPress");
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.e("yk", "onFling");
            return false;
        }

    }
}
