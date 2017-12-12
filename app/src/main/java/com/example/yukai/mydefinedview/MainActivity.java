package com.example.yukai.mydefinedview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yukai.mydefinedview.ArtLearningNote.ArtTotal;
import com.example.yukai.mydefinedview.BasicView.BasicViewActivity;
import com.example.yukai.mydefinedview.MyView.MyDefinedViewActivity;

public class MainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);
        (findViewById(R.id.btn_my_defined_view)).setOnClickListener(this);
        (findViewById(R.id.btn_basic_view)).setOnClickListener(this);
        (findViewById(R.id.btn_art_learning)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_my_defined_view){
            Intent intent = new Intent(this, MyDefinedViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_basic_view){
            Intent intent = new Intent(this, BasicViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_art_learning){
            Intent intent = new Intent(this, ArtTotal.class);
            startActivity(intent);
        }
    }
}
