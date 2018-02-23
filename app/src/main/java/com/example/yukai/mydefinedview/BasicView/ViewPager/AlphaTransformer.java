package com.example.yukai.mydefinedview.BasicView.ViewPager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by yukai on 2018/2/23.
 */

public class AlphaTransformer implements ViewPager.PageTransformer{

    private float MIN_ALPHA = 0.5f;
    private float MIN_SCALE = 0.7f;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1){
            page.setAlpha(MIN_ALPHA);
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }else if (position <= 1){
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float scale = 1 - 0.3f * Math.abs(position);
            page.setScaleX(scale);
            page.setScaleY(scale);
            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        }
    }
}
