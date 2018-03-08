package com.example.yukai.mydefinedview.ArtLearningNote.chapter12_1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by yukai on 2018/3/8.
 */

public class SquareImageView extends ImageView{

    public SquareImageView(Context context){
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public SquareImageView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
