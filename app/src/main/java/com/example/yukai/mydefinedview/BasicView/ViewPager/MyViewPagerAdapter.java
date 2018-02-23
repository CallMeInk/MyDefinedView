package com.example.yukai.mydefinedview.BasicView.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;

/**
 * Created by yukai on 2018/2/23.
 */

public class MyViewPagerAdapter extends PagerAdapter{

    private ArrayList<String> mData = new ArrayList<>();
    private Context mContext;

    public MyViewPagerAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.e("yk", position + "");
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_pager_item_layout, null);
        view.setBackgroundColor(getColor(position));
        TextView textView = (TextView) view.findViewById(R.id.view_pager_tv);
        textView.setText(String.format("This is %dth page", position));
        container.addView(view);
        return view;
    }

    public void setData(ArrayList<String> data) {
        mData = data;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    private int getColor(int position){
        position = position % 3;
        String color = "#ff0000";
        if (position == 0){
            color = "#ff0000";
        }else if (position == 1){
            color = "#00ff00";
        }else{
            color = "#0000ff";
        }
        return Color.parseColor(color);
    }

}
