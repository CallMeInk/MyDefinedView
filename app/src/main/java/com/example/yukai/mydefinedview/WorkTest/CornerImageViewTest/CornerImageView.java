package com.example.yukai.mydefinedview.WorkTest.CornerImageViewTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by yukai on 2018/8/3.
 */

public class CornerImageView extends ImageView{

    private int mLeftTopCorner = 0;
    private int mRightTopCorner = 0;
    private int mLeftBottomCorner = 0;
    private int mRightBottomCorner = 0;

    public CornerImageView(Context context){
        this(context, null);
    }

    public CornerImageView(Context context, AttributeSet attributeSet){
        this(context, attributeSet, 0);
    }

    public CornerImageView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        if (attributeSet != null){
            //
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        clipCanvas(canvas);
        super.onDraw(canvas);
    }

    private void clipCanvas(Canvas canvas){
        if (!checkCornerParamIsValid()){
            return;
        }
        float width = getWidth();
        float height = getHeight();
        Path path = new Path();
        path.moveTo(mLeftTopCorner, 0);
        path.lineTo(width - mRightTopCorner, 0);
        path.quadTo(width, 0 , width, mRightTopCorner);
        path.lineTo(width, height - mRightBottomCorner);
        path.quadTo(width, height, width - mRightBottomCorner, height);
        path.lineTo(mLeftBottomCorner, height);
        path.quadTo(0, height, 0, height - mLeftBottomCorner);
        path.lineTo(0, mLeftTopCorner);
        path.quadTo(0, 0, mLeftTopCorner, 0);
        canvas.clipPath(path);
    }

    private boolean checkCornerParamIsValid(){
        float width = getWidth();
        float height = getHeight();
        if (mLeftTopCorner < 0 || mRightTopCorner < 0 || mLeftBottomCorner < 0 || mRightBottomCorner < 0){
            return false;
        }
        if (mLeftTopCorner + mRightTopCorner > width ||
                mLeftBottomCorner + mRightBottomCorner > width ||
                mLeftTopCorner + mLeftBottomCorner > height ||
                mRightTopCorner + mRightBottomCorner > height){
            return false;
        }
        return true;
    }

    public void setCorners(int leftTopCorner, int rightTopCorner, int leftBottomCorner, int rightBottomCorner){
        mLeftTopCorner = leftTopCorner;
        mRightTopCorner = rightTopCorner;
        mLeftBottomCorner = leftBottomCorner;
        mRightBottomCorner = rightBottomCorner;
        invalidate();
    }

}
