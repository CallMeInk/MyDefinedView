package com.example.yukai.mydefinedview.BasicView.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2017/10/18.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView mTextView;

    public MyViewHolder(View view){
        super(view);
        mTextView = (TextView) view.findViewById(R.id.recycler_view_item_tv);
    }
}
