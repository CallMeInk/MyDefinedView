package com.example.yukai.mydefinedview.MyView.MySwitchView;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/3/6.
 */

public class SwitchTestActivity extends Activity{

    private KySwitch mKySwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_switch_activity_layout);
    }
}
