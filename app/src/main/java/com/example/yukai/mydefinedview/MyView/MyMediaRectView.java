package com.example.yukai.mydefinedview.MyView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * Created by yukai on 2017/10/18.
 */

public class MyMediaRectView extends View{

    private final int MAX_RANDOM_NUMBER = 100;
    private final int rectCount = 30;
    private Paint mPaint;
    private Random mRandom;

    public MyMediaRectView(Context context){
        super(context);
        init();
    }

    public MyMediaRectView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    public MyMediaRectView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#00ff00"));
        mRandom = new Random();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("yk", "onMeasure");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("yk", "onDraw");
        float totalWidth = getMeasuredWidth();
        float totalHeight = getMeasuredHeight();

        float singleRectWidth = totalWidth / rectCount;
        for (int i = 0;i < rectCount;i++){
            float rate = getRandomRate();
            canvas.drawRect(i * singleRectWidth, totalHeight * rate, (i + 1) * singleRectWidth, totalHeight, mPaint);
        }
        postInvalidateDelayed(200);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e("yk", "onSizeChanged");
        float width = (float) (getMeasuredWidth() * 0.6 / rectCount);
        float height = getMeasuredHeight();
        mPaint.setShader(new LinearGradient(0, 0, width, height, Color.parseColor("#00ff00"), Color.parseColor("#0000ff"), Shader.TileMode.CLAMP));
    }

    private float getRandomRate(){
        if (mRandom == null){
            return 0f;
        }
        return mRandom.nextInt(MAX_RANDOM_NUMBER) * 1.0f / MAX_RANDOM_NUMBER;
    }
}
