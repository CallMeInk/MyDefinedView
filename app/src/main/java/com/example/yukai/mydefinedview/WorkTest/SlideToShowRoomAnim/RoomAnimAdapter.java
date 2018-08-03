package com.example.yukai.mydefinedview.WorkTest.SlideToShowRoomAnim;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;

/**
 * Created by yukai on 2018/8/1.
 */

public class RoomAnimAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final static int ITEM_TYPE_ONE = 0;
    private final static int ITEM_TYPE_TWO = 1;
    private Context mContext;
    private LayoutInflater mInflater;

    public RoomAnimAdapter(Context context){
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_ONE){
            return new ViewHolder1(mInflater.inflate(R.layout.room_anim_item_type_1, parent, false));
        }else {
            return new ViewHolder2(mInflater.inflate(R.layout.room_anim_item_type_2, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         //do nothing
    }

    @Override
    public int getItemCount() {
        return 10000;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_TYPE_ONE : ITEM_TYPE_TWO;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;

        public ViewHolder1(View view){
            super(view);
            text = (TextView) view.findViewById(R.id.text);
            image = (ImageView) view.findViewById(R.id.image);
        }

    }

    public class ViewHolder2 extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;

        public ViewHolder2(View view){
            super(view);
            text = (TextView) view.findViewById(R.id.text);
            image = (ImageView) view.findViewById(R.id.image);
        }

    }

}
