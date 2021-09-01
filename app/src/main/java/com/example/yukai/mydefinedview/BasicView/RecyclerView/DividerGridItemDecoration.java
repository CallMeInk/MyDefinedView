package com.example.yukai.mydefinedview.BasicView.RecyclerView;

/**
 * Created by yukai on 2018/2/1.
 */

import android.graphics.Rect;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.State;

import android.view.View;

/**
 *
 * @author zhy
 *
 */
public class DividerGridItemDecoration extends RecyclerView.ItemDecoration
{

    private int spanCount;
    private int spacing;

    public DividerGridItemDecoration() {
        this.spanCount = 4;
        this.spacing = 10;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column
        outRect.left = column == 1 ? 8 : 0;
        outRect.right = column == 3 ? 0 : spacing;
        outRect.top = 0;
        outRect.bottom = spacing;
        //Log.e("yk", "getItemOffsets: " + column);
    }
}
