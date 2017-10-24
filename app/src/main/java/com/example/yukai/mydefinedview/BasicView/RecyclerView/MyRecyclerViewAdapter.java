package com.example.yukai.mydefinedview.BasicView.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.CommonUtils;

import java.util.ArrayList;

/**
 * Created by yukai on 2017/10/18.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private ArrayList<String> mDatas;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mTextView.setText(mDatas.get(position));
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(holder.mItemView, position);
                }
            }
        });
        holder.mItemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onItemLongClick(holder.mItemView, position);
                }
                return false;
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
}
