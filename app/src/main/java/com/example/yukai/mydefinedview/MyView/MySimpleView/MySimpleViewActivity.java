package com.example.yukai.mydefinedview.MyView.MySimpleView;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/1/6.
 */

public class MySimpleViewActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_view_activity_layout);
    }

}
