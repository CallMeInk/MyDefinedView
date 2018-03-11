package com.example.yukai.mydefinedview.BasicView.ProgressBar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/3/11.
 */

public class ProgressBarActivity extends Activity{

    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar_test_activity);
    }
}
