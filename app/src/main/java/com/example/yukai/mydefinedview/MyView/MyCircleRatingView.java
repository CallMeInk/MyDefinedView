package com.example.yukai.mydefinedview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yukai on 2017/10/17.
 */

public class MyCircleRatingView extends TextView{

    private float mRadius1;
    private float mRadius2;
    private float mRadius3;

    private Paint mPaint1;
    private Paint mPaint2;
    private Paint mPaint3;

    public MyCircleRatingView(Context context){
        super(context);
        init();
    }

    public MyCircleRatingView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    public MyCircleRatingView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init();
    }

    private void init(){
        mPaint1 = new Paint();
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint1.setColor(Color.parseColor("#ff0000"));
        mPaint2 = new Paint();
        mPaint2.setStyle(Paint.Style.FILL);
        mPaint2.setColor(Color.parseColor("#ffffff"));
        mPaint3 = new Paint();
        mPaint3.setStyle(Paint.Style.FILL);
        mPaint3.setColor(Color.parseColor("#00ff00"));

        mRadius1 = 200f;
        mRadius2 = 150f;
        mRadius3 = 100f;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawArc(new RectF(0, 0, mRadius1 * 2, mRadius1 * 2), 0, 270, true, mPaint1);
        canvas.translate(mRadius1 - mRadius2, mRadius1 - mRadius2);
        canvas.drawCircle(mRadius2, mRadius2, mRadius2, mPaint2);
        canvas.translate(mRadius2 - mRadius3, mRadius2 - mRadius3);
        canvas.drawCircle(mRadius3, mRadius3, mRadius3, mPaint3);
        canvas.translate(0, mRadius3);
        super.onDraw(canvas);
        canvas.restore();
    }


}
