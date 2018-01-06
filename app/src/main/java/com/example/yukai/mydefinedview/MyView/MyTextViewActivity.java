package com.example.yukai.mydefinedview.MyView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/1/5.
 */

public class MyTextViewActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_text_view_activity_layout);
    }
}
