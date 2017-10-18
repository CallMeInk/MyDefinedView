package com.example.yukai.mydefinedview.BasicView.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;

/**
 * Created by yukai on 2017/10/18.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private ArrayList<String> mDatas;
    private Context mContext;

    public MyRecyclerViewAdapter(ArrayList<String> datas, Context context){
        mDatas = datas;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mDatas.get(position));
    }
}
