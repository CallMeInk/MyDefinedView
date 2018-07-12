package com.example.yukai.mydefinedview.Utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/1/25.
 */

public class BitMapDisplayActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_display_activity);
        ImageView imageView = (ImageView) findViewById(R.id.bitmap_display_im);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hilton);
        //imageView.setImageBitmap(BitmapUtils.getRoundBitmap(bitmap));
        imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        imageView.setImageBitmap(BitmapUtils.addBitmapShadow(BitmapUtils.getRoundBitmap(BitmapUtils.cutBitMap(bitmap))));

        ImageView imageView1 = (ImageView) findViewById(R.id.bitmap_cut_test_im);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.hilton);
        Bitmap bitmap2 = BitmapUtils.getCenterCropBitmap(bitmap1, DeviceUtils.getPixelFromDp(100), DeviceUtils.getPixelFromDp(50));
        Bitmap bitmap3 = BitmapUtils.getCornerBitmap(bitmap2, DeviceUtils.getPixelFromDp(100), DeviceUtils.getPixelFromDp(50), DeviceUtils.getPixelFromDp(4), true);
        imageView1.setImageBitmap(bitmap3);
    }
}
