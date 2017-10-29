package com.example.yukai.mydefinedview.BasicView.PopUpWindow;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2017/10/27.
 */

public class PopUpWindowActivity extends Activity{

    private Button mButton;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_up_window_activity_layout);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow == null || !mPopupWindow.isShowing()){
                    showPopupWindow();
                }
            }
        });
    }

    private void showPopupWindow(){
        View contentView = getLayoutInflater().inflate(R.layout.popup_window_layout, null, false);

        mPopupWindow = new PopupWindow(this);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setContentView(contentView);
        mPopupWindow.setAnimationStyle(R.style.contextMenuAnim);

        Button button = (Button) contentView.findViewById(R.id.pop_up_window_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow != null){
                    mPopupWindow.dismiss();
                }
            }
        });

        View rootView = getLayoutInflater().inflate(R.layout.pop_up_window_activity_layout, null);

        mPopupWindow.setFocusable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }
}
