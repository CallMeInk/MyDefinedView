package com.example.yukai.mydefinedview.BasicView.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.yukai.mydefinedview.R;
import com.example.yukai.mydefinedview.Utils.CommonUtils;

import java.util.ArrayList;

/**
 * Created by yukai on 2017/10/18.
 */

public class RecyclerViewActivity extends Activity implements View.OnClickListener{

    private ArrayList<String> mDatas;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private Button mAddBtn;
    private Button mDeleteBtn;
    private RecyclerView mRecyclerViewTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_test_layout);
        initDatas();
        mAdapter = new MyRecyclerViewAdapter(mDatas, this);
        mAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                CommonUtils.showToast(RecyclerViewActivity.this, "position : " + position + "  item click");
            }

            @Override
            public void onItemLongClick(View view, int position) {
                CommonUtils.showToast(RecyclerViewActivity.this, "position : " + position + "  item long click");
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerViewTest = (RecyclerView) findViewById(R.id.recycler_view_test);
        mAddBtn = (Button) findViewById(R.id.add_one);
        mAddBtn.setOnClickListener(this);
        mDeleteBtn = (Button) findViewById(R.id.delete_one);
        mDeleteBtn.setOnClickListener(this);
        //竖直排列LinearLayout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //4列 GridLayoutManager
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        //水平 StaggredGridLayoutManager
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        //mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new MyDividerItemDecoration(this, MyDividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = event.getAction();
//                return false;
//            }
//        });
        //scrolltoposition只会滑到对应index的item可见，并不能保证该item在可见的第一个位置。如果该item已经处于可见位置，则不会滑动
        //mRecyclerView.scrollToPosition(5);


        mRecyclerViewTest.setLayoutManager(new GridLayoutManager(this, 4));
        //mRecyclerViewTest.addItemDecoration(new DividerGridItemDecoration());
        mRecyclerViewTest.setAdapter(mAdapter);



    }

    private void initDatas(){
        mDatas = new ArrayList<String>();
        for(char i = 'a';i < 'z';i++){
            mDatas.add(i + "");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.add_one){
            mDatas.add(5, "insert one");
            mAdapter.notifyItemInserted(5);
        }else{
            mDatas.remove(5);
            mAdapter.notifyItemRemoved(5);
        }
    }
}
