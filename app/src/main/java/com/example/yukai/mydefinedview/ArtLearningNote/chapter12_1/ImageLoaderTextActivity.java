package com.example.yukai.mydefinedview.ArtLearningNote.chapter12_1;

import android.app.Activity;
import android.graphics.BitmapShader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.BitmapUtils;

/**
 * Created by yukai on 2018/3/7.
 */

public class ImageLoaderTextActivity extends Activity{

    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_loader_test_activity_layout);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mImageView.setImageBitmap(BitmapUtils.decodeSampleBitmapFromResource(getResources(), R.drawable.hilton, 150, 150));
    }
}
