package com.example.yukai.mydefinedview.Utils;

import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import com.example.yukai.mydefinedview.AppManager;

/**
 * Created by yukai on 2018/2/4.
 */

public class DeviceUtils {

    public static int getPixelFromDp(float dp){

        return (int)(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp,
                AppManager.getInstance().getContext().getResources().getDisplayMetrics()) + 0.5);
    }

    public static int getScreenWidth(){
        WindowManager manager = AppManager.getInstance().getContext().getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

}
