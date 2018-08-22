package com.example.yukai.mydefinedview.WorkTest.CornerImageViewTest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

/**
 * Created by yukai on 2018/8/3.
 */

public class CornerImageViewActivity extends Activity{

    private CornerImageView mCornerImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corner_image_view_activity_layout);
        mCornerImageView = (CornerImageView) findViewById(R.id.corner_image_view);
        int fourDP = DeviceUtils.getPixelFromDp(4);
        mCornerImageView.setCorners(fourDP, fourDP, fourDP, fourDP);
    }
}
