package com.example.yukai.mydefinedview.ArtLearningNote.chapter10_2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import android.util.Log;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/3/3.
 */

public class Chapter10_2 extends Activity{

    private ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter10_2_layout);
        mBooleanThreadLocal.set(true);
        Log.e("yk", "UIThread::" + mBooleanThreadLocal.get());

        new Thread("thread#1"){
            @Override
            public void run() {
                mBooleanThreadLocal.set(false);
                Log.e("yk", "Thread#1::" + mBooleanThreadLocal.get());
            }
        }.start();

        new Thread("thread#2"){
            @Override
            public void run() {
                Handler handler = new Handler();
                Log.e("yk", "Thread#2::" + mBooleanThreadLocal.get());
            }
        }.start();
    }
}
