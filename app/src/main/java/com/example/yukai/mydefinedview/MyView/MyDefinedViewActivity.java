package com.example.yukai.mydefinedview.MyView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.yukai.mydefinedview.R;

public class MyDefinedViewActivity extends Activity {

    private MyTopBarView mMyTopBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_defined_view_activity_layout);
        mMyTopBarView = (MyTopBarView) findViewById(R.id.my_top_bar_view);
        mMyTopBarView.setMyTopBarClicklistener(new MyTopBarView.MyTopbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MyDefinedViewActivity.this, "left button clicked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MyDefinedViewActivity.this, "right button clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
