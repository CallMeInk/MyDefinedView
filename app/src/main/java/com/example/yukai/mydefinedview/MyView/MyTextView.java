package com.example.yukai.mydefinedview.MyView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yukai on 2017/10/11.
 */

public class MyTextView extends TextView{

    public MyTextView(Context context){
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 200;
            //AT_MOST -> wrap_content
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int heightMeasureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
