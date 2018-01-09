package com.example.yukai.mydefinedview.MyView.MyTopBarView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/1/6.
 */

public class MyTopBarViewActivity extends Activity{

    private MyTopBarView mMyTopBarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_top_bar_view_activity);
        mMyTopBarView = (MyTopBarView) findViewById(R.id.my_top_bar_view);
        mMyTopBarView.setMyTopBarClicklistener(new MyTopBarView.MyTopbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MyTopBarViewActivity.this, "left button clicked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MyTopBarViewActivity.this, "right button clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

}
