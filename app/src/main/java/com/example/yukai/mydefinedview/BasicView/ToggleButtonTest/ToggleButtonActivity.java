package com.example.yukai.mydefinedview.BasicView.ToggleButtonTest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

/**
 * Created by yukai on 2018/3/6.
 */

public class ToggleButtonActivity extends Activity{

    private Switch mSwitch;
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle_button_activity);
        mSwitch = (Switch) findViewById(R.id.switch_view_2);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("yk", "isChecked::" + isChecked);
                int resId = isChecked ? R.drawable.switch_bg_checked : R.drawable.switch_bg_unchecked;
                mFrameLayout.setBackgroundResource(resId);
                if (isChecked){
                    mFrameLayout.setPadding(DeviceUtils.getPixelFromDp(3), 0, 0, 0);
                }else{
                    mFrameLayout.setPadding(0, 0, DeviceUtils.getPixelFromDp(3), 0);

                }
            }
        });
        mFrameLayout = (FrameLayout) findViewById(R.id.switch_root);
    }
}
