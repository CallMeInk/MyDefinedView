package com.example.yukai.mydefinedview.MyView.MyDanmuView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.ThreadPool;

import java.util.concurrent.Executors;

/**
 * Created by yukai on 2018/2/22.
 */

public class MyDanmuActivity extends Activity{

    private MyDanmuView mMyDanmuView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_danmu_view_activity_layout);
        mMyDanmuView = (MyDanmuView) findViewById(R.id.my_danmu_view);
        ThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){
                    final int finalI = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mMyDanmuView != null){
                                mMyDanmuView.addItemView("this is " + finalI + "th barrage");
                            }
                            Log.e("yk", "danmu " + finalI);
                        }
                    });
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
