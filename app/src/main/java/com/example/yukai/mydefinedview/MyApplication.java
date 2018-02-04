package com.example.yukai.mydefinedview;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by yukai on 2018/2/4.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AppManager.getInstance().setContext(activity);
                //先有注册回调，再有具体Activity的oncreate生命周期
                Log.e("yk", "onActivityCreated: ");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                AppManager.getInstance().setContext(activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {
                AppManager.getInstance().setContext(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
