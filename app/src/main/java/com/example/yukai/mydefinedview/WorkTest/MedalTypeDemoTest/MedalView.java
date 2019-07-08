package com.example.yukai.mydefinedview.WorkTest.MedalTypeDemoTest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

public class MedalView extends FrameLayout {

    private TextView textView;

    public MedalView(Context context){
        super(context);
        init(context);
    }

    public MedalView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init(context);
    }

    public MedalView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.medal_view_layout, this, true);
        textView = (TextView) findViewById(R.id.medal_view_text);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("yk", "screenWidth::" + DeviceUtils.getScreenWidth());
        Log.e("yk", "textView::" + textView.getMeasuredWidth());

    }

    public void setText(CharSequence text){
        textView.setText(text);
    }
}
