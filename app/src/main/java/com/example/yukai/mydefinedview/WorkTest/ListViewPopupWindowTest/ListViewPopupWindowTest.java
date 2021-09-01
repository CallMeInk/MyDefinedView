package com.example.yukai.mydefinedview.WorkTest.ListViewPopupWindowTest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.DeviceUtils;

public class ListViewPopupWindowTest extends Activity implements View.OnClickListener{

    private ListView mListView;
    private Button mAddBtn;
    private boolean mNeedPop = false;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_popupwindow_layout);
        mAddBtn = (Button) findViewById(R.id.add_btn);
        mAddBtn.setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(myAdapter = new MyAdapter(this));
    }

    @Override
    public void onClick(View v) {
        mNeedPop = true;
        myAdapter.notifyDataSetChanged();
        //add popupwindow
    }

    private class MyAdapter extends BaseAdapter{

        private Context mContext;

        MyAdapter(Context context){
            mContext = context;
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.listview_popupwindow_item_layout, parent, false);
            TextView textView = (TextView) itemView.findViewById(R.id.item_tv);
            if (position == 15 && mNeedPop){
                PopupWindow popupWindow = new PopupWindow(new TextView(mContext), DeviceUtils.getPixelFromDp(40), DeviceUtils.getPixelFromDp(40), false);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff0000")));
                popupWindow.setTouchable(false);
                popupWindow.setOutsideTouchable(false);
                popupWindow.showAsDropDown(textView, DeviceUtils.getPixelFromDp(10), DeviceUtils.getPixelFromDp(10));
            }
            return itemView;
        }
    }
}
