package com.example.yukai.mydefinedview.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yukai on 2017/10/16.
 */

public class CommonUtils {

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static void showToast(Context context, String string){
        showToast(context, string, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String string, int time){
        Toast.makeText(context, string, time).show();
    }


}
