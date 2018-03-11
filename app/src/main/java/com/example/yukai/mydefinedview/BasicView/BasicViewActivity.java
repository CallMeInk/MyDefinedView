package com.example.yukai.mydefinedview.BasicView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.yukai.mydefinedview.BasicView.ActivityLifeCycleTest.Activity_A;
import com.example.yukai.mydefinedview.BasicView.AnimTest.AnimTestActivity;
import com.example.yukai.mydefinedview.BasicView.Grid.GridViewActivity;
import com.example.yukai.mydefinedview.BasicView.PopUpWindow.PopUpWindowActivity;
import com.example.yukai.mydefinedview.BasicView.ProgressBar.ProgressBarActivity;
import com.example.yukai.mydefinedview.BasicView.RatingBar.RatingBarActivity;
import com.example.yukai.mydefinedview.BasicView.RecyclerView.RecyclerViewActivity;
import com.example.yukai.mydefinedview.BasicView.TextViewTest.TextViewActivity;
import com.example.yukai.mydefinedview.BasicView.ToggleButtonTest.ToggleButtonActivity;
import com.example.yukai.mydefinedview.BasicView.ViewGroupMeasureTest.ViewGroupMeasureTestActivity;
import com.example.yukai.mydefinedview.BasicView.ViewPager.ViewPagerActivity;
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
        (findViewById(R.id.btn_rating_bar_test)).setOnClickListener(this);
        (findViewById(R.id.btn_activity_life_cycle_test)).setOnClickListener(this);
        (findViewById(R.id.btn_view_pager_test)).setOnClickListener(this);
        (findViewById(R.id.btn_view_group_measure_test)).setOnClickListener(this);
        findViewById(R.id.btn_toggle_test).setOnClickListener(this);
        findViewById(R.id.btn_text_view_test).setOnClickListener(this);
        findViewById(R.id.btn_progress_bar_test).setOnClickListener(this);
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
        }else if (id == R.id.btn_rating_bar_test){
            Intent intent = new Intent(this, RatingBarActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_activity_life_cycle_test){
            Intent intent = new Intent(this, Activity_A.class);
            startActivity(intent);
        }else if (id == R.id.btn_view_pager_test){
            Intent intent = new Intent(this, ViewPagerActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_view_group_measure_test){
            Intent intent = new Intent(this, ViewGroupMeasureTestActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_toggle_test){
            Intent intent = new Intent(this, ToggleButtonActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_text_view_test){
            Intent intent = new Intent(this, TextViewActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_progress_bar_test){
            Intent intent = new Intent(this, ProgressBarActivity.class);
            startActivity(intent);
        }
    }
}
