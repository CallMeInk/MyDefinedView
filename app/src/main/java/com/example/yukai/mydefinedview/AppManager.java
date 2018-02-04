package com.example.yukai.mydefinedview;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by yukai on 2018/2/4.
 */

public class AppManager {

    private static AppManager sInstance = null;
    private WeakReference<Activity> sCurrentActivityWeakRef;

    private AppManager(){

    }

    public static AppManager getInstance(){
        if (sInstance == null){
            sInstance = new AppManager();
        }
        return sInstance;
    }

    public void setContext(Activity context){
        sCurrentActivityWeakRef = new WeakReference<Activity>(context);
    }

    public Activity getContext(){
        Activity activity = null;
        if (sCurrentActivityWeakRef != null){
            activity = sCurrentActivityWeakRef.get();
        }
        return activity;
    }

}
