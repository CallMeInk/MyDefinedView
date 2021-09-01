package com.example.yukai.mydefinedview.BasicView.RecyclerView;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;

/**
 * Created by yukai on 2017/10/18.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private ArrayList<String> mDatas;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private final static int image_width = (1080 - 3 * 12) / 4;
    private android.os.Handler mHandler = new android.os.Handler();

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
        holder.mImageView.setImageResource(R.drawable.hilton);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) holder.mImageView.getLayoutParams();
//        layoutParams.width = image_width;
//        layoutParams.height = image_width;
        layoutParams.width = (1080 ) / 4;
        layoutParams.height = (1080 ) / 4;
        layoutParams.leftMargin = getpaddingLeft(position);
        layoutParams.rightMargin = getpaddingRight(position);
        //holder.mImageView.setPadding(getpaddingLeft(position), 0, getpaddingRight(position), 0);
        holder.mImageView.setLayoutParams(layoutParams);
        if (position >= 0 && position <= 3){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.e("yk", "rootView width::" + holder.mRootView.getWidth() + "   position :: " + position);
                }
            }, 2000);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private int getpaddingLeft(int position){
        position = position % 4;
        return (image_width + 12) * position - 1080 / 4 * position;
    }

    private int getpaddingRight(int position){
        position = position % 4;
        return 1080 / 4 * (position + 1) - position * 12 - (position + 1) * image_width;
    }

}
