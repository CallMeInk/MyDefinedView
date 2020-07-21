package com.example.yukai.mydefinedview.review.IntentService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.yukai.mydefinedview.R;

public class ReviewSimpleActivity extends Activity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_simple_activity_layout);
        findViewById(R.id.review_simple_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewSimpleActivity.this, ReviewSimpleActivityB.class);
                startActivity(intent);
            }
        });

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("yk", "do sth");
            }
        }, 100_0000);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("yk", "ReviewSimpleActivity::onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("yk", "ReviewSimpleActivity::onRestoreInstanceState");
    }
}
