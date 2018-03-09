package com.example.yukai.mydefinedview.ArtLearningNote.chapter13_1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/3/9.
 */

public class Chapter13_1_Activity extends Activity{

    private Button mThrowButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter13_1_activity_layout);
        mThrowButton = (Button) findViewById(R.id.throw_exception);
        mThrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new RuntimeException("my defined exception:: caught by crashHandler");
            }
        });
    }
}
