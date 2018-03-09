package com.example.yukai.mydefinedview;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import com.example.yukai.mydefinedview.ArtLearningNote.ArtTotal;
import com.example.yukai.mydefinedview.BasicView.BasicViewActivity;
import com.example.yukai.mydefinedview.ExternalView.ExternalViewTotalActivity;
import com.example.yukai.mydefinedview.MyView.MyDefinedViewActivity;
import com.example.yukai.mydefinedview.Utils.BitMapDisplayActivity;
import com.example.yukai.mydefinedview.Utils.CommonUtils;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

public class MainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);
        (findViewById(R.id.btn_my_defined_view)).setOnClickListener(this);
        (findViewById(R.id.btn_basic_view)).setOnClickListener(this);
        (findViewById(R.id.btn_art_learning)).setOnClickListener(this);
        (findViewById(R.id.btn_bitmap_cut)).setOnClickListener(this);
        (findViewById(R.id.btn_external_view_test)).setOnClickListener(this);
        getUserPermission();
        LogInfos();
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


//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//            Log.e("yk", "ACCESS_COARSE_LOCATION right denied");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
//        }
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//            Log.e("yk", "ACCESS_FINE_LOCATION right denied");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);
//        }
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
//            Log.e("yk", "INTERNET right denied");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 3);
//        }
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED){
//            Log.e("yk", "ACCESS_NETWORK_STATE right denied");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, 4);
//        }
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED){
//            Log.e("yk", "ACCESS_WIFI_STATE right denied");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_WIFI_STATE}, 5);
//        }
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
//            Log.e("yk", "WRITE_EXTERNAL_STORAGE right denied");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
//        }else{
//            Log.e("yk", "WRITE_EXTERNAL_STORAGE right permitted");
//        }

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED){
//            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + MainActivity.this.getPackageName()));
//            startActivity(intent);
//        }

    }

    private void LogInfos(){
        CommonUtils.log("Runtime.getRuntime().maxMemory():: " + Runtime.getRuntime().maxMemory());
        CommonUtils.log("Runtime.getRuntime().maxMemory():: " + Runtime.getRuntime().maxMemory() / 1024);
        CommonUtils.log("Runtime.getRuntime().maxMemory():: " + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        CommonUtils.log("internet permision::" + (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED));
    }
}
