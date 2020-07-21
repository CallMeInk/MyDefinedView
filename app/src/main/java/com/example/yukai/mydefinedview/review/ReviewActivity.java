package com.example.yukai.mydefinedview.review;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.review.IntentService.ReviewSimpleActivity;
import com.example.yukai.mydefinedview.review.MVVM.MvvmActivity;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        findViewById(R.id.btn_intent_service).setOnClickListener(this);
        findViewById(R.id.btn_mvvm).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch (id){
            case R.id.btn_intent_service:
                intent = new Intent(ReviewActivity.this, ReviewSimpleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_mvvm:
                intent = new Intent(ReviewActivity.this, MvvmActivity.class);
                startActivity(intent);
                break;
        }
    }
}
