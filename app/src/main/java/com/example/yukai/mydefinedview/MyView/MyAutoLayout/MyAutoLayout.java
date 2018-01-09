package com.example.yukai.mydefinedview.MyView.MyAutoLayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;

/**
 * Created by yukai on 2018/1/8.
 */

public class MyAutoLayout extends ViewGroup{

    private final int DEFAULT_MAX_LINES = 2;
    private int mMaxLines = DEFAULT_MAX_LINES;
    private ArrayList<EachLine> mLines = new ArrayList<EachLine>();

    public MyAutoLayout(Context context){
        super(context);
    }

    public MyAutoLayout(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MyAutoLayout(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet){
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyAutoLayout);
        mMaxLines = typedArray.getInt(R.styleable.MyAutoLayout_maxLines, DEFAULT_MAX_LINES);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("yk", "onMeasure:: getMeasuredWidth:: " + getMeasuredWidth());
        int width = MeasureSpec.getSize(widthMeasureSpec);

        int horizontalPadding = getPaddingLeft() + getPaddingRight();
        int verticalPadding = getPaddingTop() + getPaddingBottom();
        int eachLineWidth = width - horizontalPadding;

        initLines();
        EachLine currentLine = new EachLine();
        int currentLineCount = 1;
        int currentWidth = 0;
        int childCount = getChildCount();
        for (int i = 0;i < childCount;i++){
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            int childHeight = childView.getMeasuredHeight();
            int childWidth = childView.getMeasuredWidth();

            if (childWidth + currentWidth <= eachLineWidth){
                currentWidth += childWidth;
                currentLine.eachLineViews.add(childView);
                currentLine.height = Math.max(currentLine.height, childHeight);
                if (i == childCount - 1){
                    mLines.add(currentLine);
                }
            }else if (currentLineCount < mMaxLines){
                if (childWidth > eachLineWidth){
                    continue;
                }
                currentLineCount++;
                currentLine.height = Math.max(currentLine.height, childHeight);
                mLines.add(currentLine);
                currentLine = new EachLine();
                currentLine.eachLineViews.add(childView);
                currentWidth = childWidth;
            }else{
                mLines.add(currentLine);
                break;
            }
        }
        int height = 0;
        for(EachLine eachLine : mLines){
            height += eachLine.height;
        }
        height += getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(width, height);
    }

    private void initLines(){
        if (mLines == null){
            mLines = new ArrayList<EachLine>();
        }else{
            mLines.clear();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mLines == null){
            return;
        }
        int top = 0;
        for (EachLine eachLine : mLines){
            if (eachLine == null || eachLine.eachLineViews == null){
                continue;
            }
            int left = 0;
            for (View view : eachLine.eachLineViews){
                if (view == null){
                    continue;
                }
                view.layout(left, top, left + view.getMeasuredWidth(), top + view.getMeasuredHeight());
                left += view.getMeasuredWidth();
            }
            top += eachLine.height;
        }
    }

    public void setMaxLines(int maxLines){
        this.mMaxLines = maxLines;
        requestLayout();
        invalidate();
    }

    private class EachLine{
        ArrayList<View> eachLineViews = new ArrayList<>();
        int height = 0;
    }
}
