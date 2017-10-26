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


    //看了下guolin的博客，发现Listview、GridView也好，在getView中的convertview，
    //是从recycleBin（滑出Listview、Gridview的view会被add进recyclerBin）中拿的view
    //convertView可能会与每个item拥有一样的view类型，也就是不需要再inflate一遍
    //但是这个itemView中的数据需要重新刷新
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder;
        if (convertView == null){
            view = mLayoutInflater.inflate(R.layout.grid_view_item_view, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mTextView.setText(mDatas.get(position));
        return view;
    }

    private class ViewHolder{

        TextView mTextView;

        ViewHolder(View view){
            mTextView = (TextView) view.findViewById(R.id.grid_view_tv);
        }
    }
}
