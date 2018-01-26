package com.example.yukai.mydefinedview.Utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hitton1);
        //imageView.setImageBitmap(BitmapUtils.getRoundBitmap(bitmap));
        imageView.setImageBitmap(BitmapUtils.getRoundBitmap(BitmapUtils.cutBitMap(bitmap)));
    }
}
