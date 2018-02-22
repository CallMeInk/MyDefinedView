package com.example.yukai.mydefinedview.MyView.MyDanmuView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yukai.mydefinedview.Utils.DeviceUtils;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by yukai on 2018/2/22.
 */

public class MyDanmuView extends RelativeLayout{

    private final static int DEFAULT_ROW_NUMBER = 6;
    private int mScreenWidth;
    private Context mContext;
    private int mRowNum;
    private Random mRandom;
    private HashMap<String, View> mHashMap;

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
        mRowNum = DEFAULT_ROW_NUMBER;
        mHashMap = new HashMap<>();
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
            RelativeLayout.LayoutParams lp = (LayoutParams) view.getLayoutParams();
            view.layout(mScreenWidth, lp.topMargin, mScreenWidth + view.getMeasuredWidth(), lp.topMargin + view.getMeasuredHeight());
        }
    }

    public void addItemView(String text){
        createDanmuItemView(text);
    }

    private void createDanmuItemView(String text){
        if (mContext == null){
            return;
        }
        final TextView textView = new TextView(mContext);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTextSize(15);
        textView.setText(text);
        int measureWidth  = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int measureHeight = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        textView.measure(measureWidth, measureHeight);
        int width = textView.getMeasuredWidth();
        int height = textView.getMeasuredHeight();
        int row = getRandomNumber();
        while (!isRowLegal(row, textView)){
            row = getRandomNumber();
        }
        RelativeLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = row * (height + DeviceUtils.getPixelFromDp(10));
        textView.setLayoutParams(layoutParams);
        textView.setPadding(DeviceUtils.getPixelFromDp(15), DeviceUtils.getPixelFromDp(2), DeviceUtils.getPixelFromDp(15), DeviceUtils.getPixelFromDp(2));
        addView(textView);
        ViewPropertyAnimator animator = textView.animate().translationXBy(-(mScreenWidth + width + 100));
        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                MyDanmuView.this.removeView(textView);
            }
        });
        animator.start();
    }

    private Random getRandomInstance(){
        if (mRandom == null){
            mRandom = new Random();
        }
        return mRandom;
    }

    private int getRandomNumber(){
        return getRandomInstance().nextInt(100) % mRowNum;
    }

    private boolean isRowLegal(int row, View view){
        if (mHashMap == null){
            return false;
        }
        if (row < 0 && row >= mRowNum){
            return false;
        }
        String index = String.valueOf(row);
        View formerView = mHashMap.get(index);
        if (formerView != null){
            if (formerView.getX() + formerView.getMeasuredWidth() < mScreenWidth){
                mHashMap.remove(index);
                mHashMap.put(index, view);
                return true;
            }else{
                return false;
            }
        }else{
            mHashMap.put(index, view);
            return true;
        }
    }

}
