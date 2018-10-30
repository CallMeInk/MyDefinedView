package com.example.yukai.mydefinedview.WorkTest.WannaGoViewTest;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

public class WannaGoViewTestActivity extends Activity{

    private View wannaGoRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wanna_go_test_activity_layout);
        wannaGoRoot = findViewById(R.id.wanna_go_root);
        ShadowDrawable.setShadowDrawable(wannaGoRoot,
                Color.parseColor("#ffffffff"),
                DeviceUtils.getPixelFromDp(4),
                Color.parseColor("#4c333333"),
                DeviceUtils.getPixelFromDp(4), 0, 3);

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{Color.parseColor("#ff4289ff"), Color.parseColor("#ff36b3ff")});
        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable.setCornerRadii(new float[]{0, 0, DeviceUtils.getPixelFromDp(2), DeviceUtils.getPixelFromDp(2), DeviceUtils.getPixelFromDp(12), DeviceUtils.getPixelFromDp(12), 0, 0});
        findViewById(R.id.desc).setBackground(gradientDrawable);
    }
}
