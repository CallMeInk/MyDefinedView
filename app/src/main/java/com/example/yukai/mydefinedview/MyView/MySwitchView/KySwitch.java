package com.example.yukai.mydefinedview.MyView.MySwitchView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;

import com.example.yukai.mydefinedview.Utils.DeviceUtils;

public class KySwitch extends View implements OnGestureListener{
    public static int OFF = 0;
    public static int ON = 1;
    private static int ONE_DP = DeviceUtils.getPixelFromDp(1);
    private GestureDetector mGestureDetector;
    private OnSwitchChangedListener onSwitchChangedListener;
    private Paint paint = new Paint();


    private int onBgColor = 0xFF4289FF;
    private int offBgColor = 0xFF000000;
    private int thumbColor = 0xFFFFFFFF;
    private int onTextColor = 0xFF4289FF;
    private int offTextColor = 0xFF999999;
    private int textSize = DeviceUtils.getPixelFromDp(18);

    private int thumbMarginLeft;
    private int thumbMarginTop;
    private int thumbMarginRight;
    private int thumbMarginBottom;

    private int paddingLeft;
    private int paddingTop;
    private int paddingRight;
    private int paddingBottom;
    //运行时状态
    private int thumbLeft;//滑块的位置
    private int thumbDownLeft ;//down事件发生时，滑块的位置
    private int value = OFF;//当前状态，开或关
    private boolean scrolling = false;//是否正在拖动s
    private boolean isSingleClick = false;

    public KySwitch(Context context) {
        super(context);
        mGestureDetector = new GestureDetector(this);
        thumbMarginLeft = dip2px(this.getContext(), 2);
        thumbMarginTop = dip2px(this.getContext(), 1);
        thumbMarginRight = dip2px(this.getContext(), 2);
        thumbMarginBottom = dip2px(this.getContext(), 1);
    }

    public KySwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = dip2px(this.getContext(), 120);
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = dip2px(this.getContext(), 50);
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        drawThumb(canvas);
    }

    private void drawBackground(Canvas canvas){
        int backgroundColor = (value == ON) ? onBgColor : offBgColor;
        RectF rectF = new RectF();
        rectF.left = paddingLeft;
        rectF.top = paddingTop;
        rectF.right = getWidth() - paddingRight;
        rectF.bottom = getHeight() - paddingBottom;
        paint.setAntiAlias(true);
        paint.setColor(backgroundColor);
        int radius = (getHeight() - paddingTop - paddingBottom) / 2;
        canvas.drawRoundRect(rectF, radius, radius, paint);
    }

    private void drawThumb(Canvas canvas){
        paint.setColor(thumbColor);
        RectF rectF = new RectF();
        if (scrolling){
            rectF.left = thumbLeft;
        }
        else{
            rectF.left = getMinThumbLeft();
            if (value == ON){
                rectF.left = getMaxThumbLeft();
            }
        }
        rectF.top = paddingTop + thumbMarginTop;
        rectF.right = rectF.left + getThumbRadius() * 2;
        rectF.bottom = getHeight() - paddingBottom - thumbMarginBottom;

        rectF.left += ONE_DP;
        rectF.right -= ONE_DP;
        rectF.top += ONE_DP;
        rectF.bottom -= ONE_DP;

        paint.setAntiAlias(true);
        canvas.drawArc(rectF, 0, 360, false, paint);
        int textColor = value == ON ? onTextColor : offTextColor;
        paint.setColor(textColor);
        paint.setTextSize(DeviceUtils.getPixelFromDp(18));
        canvas.drawText("弹", getThumbRadius() * 0.4f + rectF.left, getThumbRadius() * 1.4f, paint);
    }

    private int getMinThumbLeft(){
        return paddingLeft + thumbMarginLeft;
    }

    private int getMaxThumbLeft(){
        return getWidth() - paddingRight - thumbMarginRight - getThumbRadius() * 2;
    }

    private int getThumbRadius(){
        return (getHeight() - paddingTop - paddingBottom - thumbMarginTop - thumbMarginBottom) / 2;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            mGestureDetector.onTouchEvent(event);
            if(event.getAction() == MotionEvent.ACTION_UP){
                upEventHandler();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.e("yk", "onDown");
        downEventHandler();
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float arg2, float arg3) {
        Log.e("yk", "onFling");
        flingEventHandler((int)event1.getX(), (int)event2.getX());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.e("yk", "onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float arg2, float arg3) {
        Log.e("yk", "onScroll");
        scrollEventHandler((int)event1.getX(), (int)event2.getX());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.e("yk", "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        clickEventHandler((int)event.getX(), (int)event.getY());
        return true;
    }

    private void downEventHandler(){
        thumbLeft = getMinThumbLeft();
        isSingleClick = false;
        if(value == ON){
            thumbLeft = getMaxThumbLeft();
        }
        thumbDownLeft = thumbLeft;
        scrolling = true;
    }

    private void scrollEventHandler(int x1, int x2){
        thumbLeft = thumbDownLeft + (x2 - x1);
        int minThumbLeft = getMinThumbLeft();
        int maxThumbLeft = getMaxThumbLeft();
        if(thumbLeft < minThumbLeft){
            thumbLeft = minThumbLeft;
        }
        if(thumbLeft > maxThumbLeft){
            thumbLeft = maxThumbLeft;
        }
        invalidate();
    }

    private void clickEventHandler(int x, int y){
        isSingleClick = true;
        thumbLeft = getMaxThumbLeft();
        int minThumbLeft = getMinThumbLeft();
        int thumbContaierWidth = getWidth() - paddingLeft - paddingRight - thumbMarginLeft - thumbMarginRight;
        if(x <= (minThumbLeft + thumbContaierWidth / 2)){
            thumbLeft = getMinThumbLeft();
        }
    }

    private void flingEventHandler(int x1, int x2){
        if (x1 == x2){
            return ;
        }
        thumbLeft = getMaxThumbLeft();
        //向左滑动
        if (x2 < x1){
            thumbLeft = getMinThumbLeft();
        }
    }

    private void upEventHandler(){
        scrolling = false;
        int minThumbLeft = getMinThumbLeft();
        int thumbContaierWidth = getWidth() - paddingLeft - paddingRight - thumbMarginLeft - thumbMarginRight;
        int value = thumbLeft > (minThumbLeft + thumbContaierWidth / 2 - getThumbRadius()) ? ON : OFF;
        if (isSingleClick){
            value = this.value == ON ? OFF : ON;
        }
        int oldValue = this.value;
        setValue(value);
        if(onSwitchChangedListener != null && oldValue != value)
            onSwitchChangedListener.onSwitchChanged(this, value);
    }

    public void setValue(int value){
        if(value != OFF && value != ON){
            return;
        }
        this.value = value;
        invalidate();
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public interface OnSwitchChangedListener {
        public void onSwitchChanged(View view, int value);
    }

    public void setOnSwitchChangedListener(OnSwitchChangedListener onSwitchChangedListener) {
        this.onSwitchChangedListener = onSwitchChangedListener;
    }

}
