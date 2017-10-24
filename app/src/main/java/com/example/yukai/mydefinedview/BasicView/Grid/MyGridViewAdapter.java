package com.example.yukai.mydefinedview.BasicView.Grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;

/**
 * Created by yukai on 2017/10/24.
 */

public class MyGridViewAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<String> mDatas;
    private LayoutInflater mLayoutInflater;

    public MyGridViewAdapter(Context context, ArrayList<String> datas){
        mContext = context;
        mDatas = datas;
        if (mContext != null){
            mLayoutInflater = LayoutInflater.from(mContext);
        }
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null){
            view = mLayoutInflater.inflate(R.layout.grid_view_item_view, parent, false);
            TextView textView = (TextView) view.findViewById(R.id.grid_view_tv);
            textView.setText(mDatas.get(position));
        }else{
            view = convertView;
        }

        return view;
    }
}
