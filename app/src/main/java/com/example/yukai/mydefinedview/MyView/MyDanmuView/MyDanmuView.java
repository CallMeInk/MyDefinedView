package com.example.yukai.mydefinedview.MyView.MyDanmuView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yukai.mydefinedview.AppManager;
import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.CommonUtils;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;
import com.example.yukai.mydefinedview.Utils.ThreadPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by yukai on 2018/2/22.
 */

public class MyDanmuView extends FrameLayout{

    private final int ADD_BARRAGE = 1;
    private int mScreenWidth;
    private Context mContext;
    private int mRowNum;
    private HashMap<String, View> mEachLineEndView;
    private ArrayList<BarrageDataModel> mData;
    private int mCurrentDisplayIndex;
    private int mAnimationDuration;
    private volatile int mBarrageState;
    private boolean hasStartThread;
    private ArrayList<View> mBarrageViewCache;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg == null){
                return;
            }
            int flag = msg.what;
            switch (flag){
                case ADD_BARRAGE:
                    if (checkBarrageCanSend(mCurrentDisplayIndex) && mBarrageState == BarrageConstant.BARRAGE_STATE_START){
                        addBarrage();
                    }
                    this.sendMessageDelayed(Message.obtain(mHandler, ADD_BARRAGE), 500);
                    break;
                default:
                    break;
            }
        }
    };

    public MyDanmuView(Context context){
        super(context);
        init(context);
    }

    public MyDanmuView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init(context);
    }

    public MyDanmuView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init(context);
    }

    private void init(Context context){
        mScreenWidth = DeviceUtils.getScreenWidth();
        mContext = context;
        mRowNum = BarrageConstant.DEFAULT_ROW_NUMBER;
        mAnimationDuration = BarrageConstant.DDFAULT_ANIMATION_DURATION;
        mCurrentDisplayIndex = 0;
        mEachLineEndView = new HashMap<>();
        setBackgroundColor(Color.TRANSPARENT);
        mBarrageState = BarrageConstant.BARRAGE_STATE_INIT;
        hasStartThread = false;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++){
            final View view = getChildAt(i);
            if (view == null){
                continue;
            }
            FrameLayout.LayoutParams lp = (LayoutParams) view.getLayoutParams();
            view.layout(mScreenWidth,
                    lp.topMargin,
                    mScreenWidth + view.getMeasuredWidth(),
                    lp.topMargin + view.getMeasuredHeight());
        }
    }

    private boolean checkBarrageCanSend(int index){
        if (mEachLineEndView == null){
            return false;
        }
        int row = index % mRowNum;
        String rowKey = String.valueOf(row);
        if (!mEachLineEndView.containsKey(rowKey)){
            return true;
        }
        View formerView = mEachLineEndView.get(rowKey);
        return formerView == null ||
                formerView.getX() + formerView.getMeasuredWidth() < mScreenWidth;
    }

    private void addBarrage(){
        if (mData == null || mCurrentDisplayIndex >= mData.size()){
            return;
        }
        int row = mCurrentDisplayIndex % mRowNum;
        String rowKey = String.valueOf(row);
        BarrageDataModel model = mData.get(mCurrentDisplayIndex);
        final View view = generateViewByModel(model);
        mEachLineEndView.put(rowKey, view);
        mCurrentDisplayIndex++;
        int measureWidth  = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int measureHeight = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        view.measure(measureWidth, measureHeight);
        int width = view.getMeasuredWidth();
        int height = view.getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = row * (height + DeviceUtils.getPixelFromDp(10));
        view.setLayoutParams(layoutParams);
        addView(view);

        final ViewPropertyAnimator animator = view.animate().translationXBy(-(mScreenWidth + width + 100));
        animator.setDuration(mAnimationDuration);
        animator.setInterpolator(new LinearInterpolator());
        animator.setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                MyDanmuView.this.removeView(view);
                view.clearAnimation();
                view.layout(mScreenWidth, 0, mScreenWidth + view.getMeasuredWidth(), view.getMeasuredHeight());
                mBarrageViewCache.add(view);
            }
        });
        animator.start();
    }

    public void setData(ArrayList<BarrageDataModel> data){
        if (data == null ||
                mBarrageState == BarrageConstant.BARRAGE_STATE_PAUSE ||
                mBarrageState == BarrageConstant.BARRAGE_STATE_START){
            return;
        }
        if (mData == null){
            mData = new ArrayList<BarrageDataModel>();
        }
        mData.clear();
        mData.addAll(data);
    }

    public void start(){
        if (mBarrageState == BarrageConstant.BARRAGE_STATE_INIT){
            start(0);
        }else if (mBarrageState == BarrageConstant.BARRAGE_STATE_PAUSE){
            start(mCurrentDisplayIndex + 1);
        }
    }

    private void start(int startIndex){
        mCurrentDisplayIndex = startIndex;
        mBarrageState = BarrageConstant.BARRAGE_STATE_START;
        if (mHandler != null){
            mHandler.removeMessages(ADD_BARRAGE);
            mHandler.sendEmptyMessage(ADD_BARRAGE);
        }
    }

    private synchronized View generateViewByModel(BarrageDataModel model){
        if (mBarrageViewCache == null){
            mBarrageViewCache = new ArrayList<View>();
        }
        View view = LayoutInflater.from(AppManager.getInstance().getContext()).inflate(R.layout.barrage_item_view, null, false);
        TextView textView = (TextView) view.findViewById(R.id.barrage_tv);
        textView.setTextSize(model.textSize);
        textView.setTextColor(model.testColor);
        textView.setText(model.text);
        return view;
    }

    public void pause(){
        if (mBarrageState == BarrageConstant.BARRAGE_STATE_START){
            mBarrageState = BarrageConstant.BARRAGE_STATE_PAUSE;
            if (mHandler != null){
                mHandler.removeMessages(ADD_BARRAGE);
            }
        }
    }

    public void onDestroy(){
        if (mHandler != null){
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void setRowNumber(int rowNumber){
        if (mBarrageState == BarrageConstant.BARRAGE_STATE_START){
            return;
        }
        mRowNum = rowNumber;
    }

    public void setAnimationDuration(int duration){
        if (mBarrageState == BarrageConstant.BARRAGE_STATE_START){
            return;
        }
        mAnimationDuration = duration;
    }

    public void hide(){
        setVisibility(View.INVISIBLE);
    }

    public void show(){
        setVisibility(View.VISIBLE);
    }

    public void reset(){
        if (mData != null){
            mData.clear();
        }
        if (mHandler != null){
            mHandler.removeMessages(ADD_BARRAGE);
        }
        mBarrageState = BarrageConstant.BARRAGE_STATE_INIT;
    }

    public int getCurrentDisplayIndex(){
        return mCurrentDisplayIndex;
    }

    public int getBarrageState(){
        return mBarrageState;
    }

}
