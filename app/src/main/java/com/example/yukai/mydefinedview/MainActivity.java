package com.example.yukai.mydefinedview;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import com.example.splitmodule.Utils.Utils;
import com.example.yukai.mydefinedview.ArtLearningNote.ArtTotal;
import com.example.yukai.mydefinedview.BasicView.BasicViewActivity;
import com.example.yukai.mydefinedview.ExampleTest.ExampleTestActivity;
import com.example.yukai.mydefinedview.ExternalView.ExternalViewTotalActivity;
import com.example.yukai.mydefinedview.MyView.MyDefinedViewActivity;
import com.example.yukai.mydefinedview.Utils.BitMapDisplayActivity;
import com.example.yukai.mydefinedview.Utils.CommonUtils;
import com.example.yukai.mydefinedview.WorkTest.WorkTest;
import com.example.yukai.mydefinedview.review.IntentService.ReviewSimpleActivity;
import com.example.yukai.mydefinedview.review.ReviewActivity;
import com.example.yukai.mydefinedview.rxjava.RxjavaActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Object waitTest = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);
        (findViewById(R.id.btn_my_defined_view)).setOnClickListener(this);
        (findViewById(R.id.btn_basic_view)).setOnClickListener(this);
        (findViewById(R.id.btn_art_learning)).setOnClickListener(this);
        (findViewById(R.id.btn_bitmap_cut)).setOnClickListener(this);
        (findViewById(R.id.btn_external_view_test)).setOnClickListener(this);
        findViewById(R.id.btn_list_view_anim_test).setOnClickListener(this);
        findViewById(R.id.btn_example_test).setOnClickListener(this);
        findViewById(R.id.btn_review).setOnClickListener(this);
        findViewById(R.id.btn_rxjava).setOnClickListener(this);
        getUserPermission();
        LogInfos();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("yk", "notifyAll");
////                synchronized (waitTest){
//                    waitTest.notifyAll();
////                }
//                Log.e("yk", "after notifyAll");
//            }
//        }).start();

//        findViewById(R.id.btn_rxjava).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("yk", "notifyAll");
////                synchronized (waitTest){
//                waitTest.notifyAll();
////                }
//                Log.e("yk", "after notifyAll");
//            }
//        }, 2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Log.e("yk", "before wait");
                    synchronized (waitTest){
                        Log.e("yk", "in synchronized wait");
                        waitTest.wait(10000);
                    }
                    Log.e("yk", "wait end");
                }catch (Exception e){
                    Log.e("yk", "Exception");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Log.e("yk", "before wait");
                    synchronized (waitTest){
                        Log.e("yk", "in synchronized wait");
                        waitTest.wait(10000);
                    }
                    Log.e("yk", "wait end");
                }catch (Exception e){
                    Log.e("yk", "Exception");
                }
            }
        }).start();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_my_defined_view){
            Intent intent = new Intent(this, MyDefinedViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_basic_view){
            Intent intent = new Intent(this, BasicViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_art_learning){
            Intent intent = new Intent(this, ArtTotal.class);
            startActivity(intent);
        }else if (id == R.id.btn_bitmap_cut){
            Intent intent = new Intent(this, BitMapDisplayActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_external_view_test){
            Intent intent = new Intent(this, ExternalViewTotalActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_list_view_anim_test){
            Intent intent = new Intent(this, WorkTest.class);
            startActivity(intent);
        }else if (id == R.id.btn_example_test){
            Intent intent = new Intent(this, ExampleTestActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_review){
            Intent intent = new Intent(this, ReviewActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_rxjava){
            Intent intent = new Intent(this, RxjavaActivity.class);
            startActivity(intent);
        }
    }

    private void getUserPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);
    }

    private void LogInfos(){
        CommonUtils.log("Runtime.getRuntime().maxMemory():: " + Runtime.getRuntime().maxMemory());
        CommonUtils.log("Runtime.getRuntime().maxMemory():: " + Runtime.getRuntime().maxMemory() / 1024);
        CommonUtils.log("Runtime.getRuntime().maxMemory():: " + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        CommonUtils.log("internet permision::" + (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED));
        Utils.Companion.logUtil();
    }
}
