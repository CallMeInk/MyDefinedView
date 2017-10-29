package com.example.yukai.mydefinedview.BasicView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yukai.mydefinedview.BasicView.AnimTest.AnimTestActivity;
import com.example.yukai.mydefinedview.BasicView.Grid.GridViewActivity;
import com.example.yukai.mydefinedview.BasicView.PopUpWindow.PopUpWindowActivity;
import com.example.yukai.mydefinedview.BasicView.RecyclerView.RecyclerViewActivity;
import com.example.yukai.mydefinedview.R;

public class BasicViewActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_view_layout);
        (findViewById(R.id.btn_recycler_view)).setOnClickListener(this);
        (findViewById(R.id.btn_grid_view)).setOnClickListener(this);
        (findViewById(R.id.btn_pop_up_window)).setOnClickListener(this);
        (findViewById(R.id.btn_anim_test)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_recycler_view){
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_grid_view){
            Intent intent = new Intent(this, GridViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_pop_up_window){
            Intent intent = new Intent(this, PopUpWindowActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_anim_test){
            Intent intent = new Intent(this, AnimTestActivity.class);
            startActivity(intent);
        }
    }
}
