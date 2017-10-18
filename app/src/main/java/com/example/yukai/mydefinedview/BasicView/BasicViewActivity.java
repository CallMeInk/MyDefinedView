package com.example.yukai.mydefinedview.BasicView;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yukai.mydefinedview.BasicView.RecyclerView.RecyclerViewActivity;
import com.example.yukai.mydefinedview.R;

public class BasicViewActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_view_layout);
        ((Button)findViewById(R.id.btn_recycler_view)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_recycler_view){
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        }
    }
}