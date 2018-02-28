package com.example.yukai.mydefinedview.MyView.MyDanmuView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.yukai.mydefinedview.AppManager;
import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yukai on 2018/2/28.
 */

public class BarrageManager {

    private ArrayList<View> BarrageViewCache;

    public View generateViewByModel(BarrageDataModel model){
        View view = LayoutInflater.from(AppManager.getInstance().getContext()).inflate(R.layout.barrage_item_view, null, false);
        TextView textView = (TextView) view.findViewById(R.id.barrage_tv);
        textView.setTextSize(model.textSize);
        textView.setTextColor(model.testColor);
        textView.setText(model.text);
        return view;
    }

}
