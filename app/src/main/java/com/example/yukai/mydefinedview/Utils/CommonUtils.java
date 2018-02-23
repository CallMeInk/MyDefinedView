package com.example.yukai.mydefinedview.Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.yukai.mydefinedview.AppManager;

import java.util.List;

/**
 * Created by yukai on 2017/10/16.
 */

public class CommonUtils {

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static void showToast(String string){
        showToast(AppManager.getInstance().getContext(), string, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String string){
        showToast(context, string, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String string, int time){
        Toast.makeText(context, string, time).show();
    }

    public static void log(String message){
        Log.e("yk", message);
    }

    public static boolean isListEmpty(List<? extends Object> list){
        return list == null || list.isEmpty();
    }

}
