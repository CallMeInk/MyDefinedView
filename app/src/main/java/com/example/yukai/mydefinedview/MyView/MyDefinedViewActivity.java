package com.example.yukai.mydefinedview.MyView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yukai.mydefinedview.MyView.MyAutoLayout.MyAutoLayoutActivity;
import com.example.yukai.mydefinedview.MyView.MyCircleRatingView.MyCircleRatingViewActivity;
import com.example.yukai.mydefinedview.MyView.MyMediaRectView.MyMediaRectViewActivity;
import com.example.yukai.mydefinedview.MyView.MySimpleView.MySimpleViewActivity;
import com.example.yukai.mydefinedview.MyView.MyTextView.MyTextViewActivity;
import com.example.yukai.mydefinedview.MyView.MyTopBarView.MyTopBarViewActivity;
import com.example.yukai.mydefinedview.R;

public class MyDefinedViewActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_defined_view_activity_layout);

        (findViewById(R.id.my_text_view_btn)).setOnClickListener(this);
        (findViewById(R.id.my_top_bar_view_btn)).setOnClickListener(this);
        (findViewById(R.id.my_circle_rating_view_btn)).setOnClickListener(this);
        (findViewById(R.id.my_media_rect_view_btn)).setOnClickListener(this);
        (findViewById(R.id.my_simple_view_btn)).setOnClickListener(this);
        (findViewById(R.id.my_auto_layout)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.my_text_view_btn){
            Intent intent = new Intent(MyDefinedViewActivity.this, MyTextViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.my_top_bar_view_btn){
            Intent intent = new Intent(MyDefinedViewActivity.this, MyTopBarViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.my_circle_rating_view_btn){
            Intent intent = new Intent(MyDefinedViewActivity.this, MyCircleRatingViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.my_media_rect_view_btn){
            Intent intent = new Intent(MyDefinedViewActivity.this, MyMediaRectViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.my_simple_view_btn){
            Intent intent = new Intent(MyDefinedViewActivity.this, MySimpleViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.my_auto_layout){
            Intent intent = new Intent(MyDefinedViewActivity.this, MyAutoLayoutActivity.class);
            startActivity(intent);
        }
    }
}
