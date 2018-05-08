package com.example.yukai.mydefinedview.WorkTest.ListViewAnim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/5/4.
 */
class AnimListAdapter : BaseAdapter(){

    var itemCount: Int = 10

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return LayoutInflater.from(parent?.context).inflate(R.layout.anim_list_view_item, parent, false)
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int = itemCount


}