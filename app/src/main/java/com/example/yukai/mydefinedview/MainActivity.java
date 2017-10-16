package com.example.yukai.mydefinedview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.yukai.mydefinedview.MyView.MyTopBarView;

public class MainActivity extends AppCompatActivity {

    private MyTopBarView mMyTopBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyTopBarView = (MyTopBarView) findViewById(R.id.my_top_bar_view);
        mMyTopBarView.setMyTopBarClicklistener(new MyTopBarView.MyTopbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "left button clicked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "right button clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
