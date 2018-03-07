package com.example.yukai.mydefinedview.ArtLearningNote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.yukai.mydefinedview.ArtLearningNote.chapter10_2.Chapter10_2;
import com.example.yukai.mydefinedview.ArtLearningNote.chapter12_1.ImageLoaderTextActivity;
import com.example.yukai.mydefinedview.ArtLearningNote.chapter3_1.Chapter3_1;
import com.example.yukai.mydefinedview.ArtLearningNote.chapter3_2.Chapter3_2;
import com.example.yukai.mydefinedview.ArtLearningNote.chapter3_3.Chapter3_3;
import com.example.yukai.mydefinedview.ArtLearningNote.chapter3_4.Chapter3_4;
import com.example.yukai.mydefinedview.ArtLearningNote.chapter5_1.Chapter5_1;
import com.example.yukai.mydefinedview.ArtLearningNote.chapter6_1.Chapter6_1;
import com.example.yukai.mydefinedview.ArtLearningNote.chapter8_1.Chapter8_1;
import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2017/12/12.
 */

public class ArtTotal extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_view_knowledge);
        (findViewById(R.id.btn_3_1)).setOnClickListener(this);
        (findViewById(R.id.btn_3_2)).setOnClickListener(this);
        (findViewById(R.id.btn_3_3)).setOnClickListener(this);
        (findViewById(R.id.btn_3_4)).setOnClickListener(this);
        (findViewById(R.id.btn_5_1)).setOnClickListener(this);
        (findViewById(R.id.btn_6_1)).setOnClickListener(this);
        (findViewById(R.id.btn_8_1)).setOnClickListener(this);
        (findViewById(R.id.btn_10_2)).setOnClickListener(this);
        (findViewById(R.id.btn_12_1)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_3_1){
            Intent intent = new Intent(this, Chapter3_1.class);
            startActivity(intent);
        }else if (id == R.id.btn_3_2){
            Intent intent = new Intent(this, Chapter3_2.class);
            startActivity(intent);
        }else if (id == R.id.btn_3_3){
            Intent intent = new Intent(this, Chapter3_3.class);
            startActivity(intent);
        }else if (id == R.id.btn_3_4){
            Intent intent = new Intent(this, Chapter3_4.class);
            startActivity(intent);
        }else if (id == R.id.btn_5_1){
            Intent intent = new Intent(this, Chapter5_1.class);
            startActivity(intent);
        }else if (id == R.id.btn_6_1){
            Intent intent = new Intent(this, Chapter6_1.class);
            startActivity(intent);
        }else if (id == R.id.btn_8_1){
            Intent intent = new Intent(this, Chapter8_1.class);
            startActivity(intent);
        }else if (id == R.id.btn_10_2){
            Intent intent = new Intent(this, Chapter10_2.class);
            startActivity(intent);
        }else if (id == R.id.btn_12_1){
            Intent intent = new Intent(this, ImageLoaderTextActivity.class);
            startActivity(intent);
        }
    }
}
