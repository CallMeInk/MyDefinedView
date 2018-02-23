package com.example.yukai.mydefinedview.BasicView.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.example.yukai.mydefinedview.R;

import java.util.ArrayList;

/**
 * Created by yukai on 2018/2/23.
 */

public class ViewPagerActivity extends Activity{

    private ViewPager mViewPager;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this);
        initData();
        adapter.setData(mData);
        mViewPager.setPageMargin(80);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageTransformer(false, new AlphaTransformer());
        mViewPager.setAdapter(adapter);
    }

    private void initData(){
        mData = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            mData.add(i + "");
        }
    }

}
