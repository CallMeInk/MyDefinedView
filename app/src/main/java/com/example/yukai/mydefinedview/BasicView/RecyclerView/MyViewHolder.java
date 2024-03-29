package com.example.yukai.mydefinedview.BasicView.RecyclerView;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2017/10/18.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView mTextView;
    public View mItemView;
    public ImageView mImageView;
    public RelativeLayout mRootView;

    public MyViewHolder(View view){
        super(view);
        mItemView = view;
        mTextView = (TextView) view.findViewById(R.id.recycler_view_item_tv);
        mImageView = (ImageView) view.findViewById(R.id.recycler_view_item_iv);
        mRootView = (RelativeLayout) view.findViewById(R.id.root_view);
    }
}
