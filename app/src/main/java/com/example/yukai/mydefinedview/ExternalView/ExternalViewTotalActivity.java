package com.example.yukai.mydefinedview.ExternalView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.yukai.mydefinedview.ExternalView.BiliBiliDanmuView.BiliBiliDanmuViewActivity;
import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/2/27.
 */

public class ExternalViewTotalActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_view_total_activity_layout);
        findViewById(R.id.btn_bilibili).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_bilibili){
            Intent intent = new Intent(this, BiliBiliDanmuViewActivity.class);
            startActivity(intent);
        }
    }
}
