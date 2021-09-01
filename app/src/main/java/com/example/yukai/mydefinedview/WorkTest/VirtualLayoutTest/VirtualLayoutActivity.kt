package com.example.yukai.mydefinedview.WorkTest.VirtualLayoutTest

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.example.yukai.mydefinedview.R
import java.util.*

/**
 * Created by yukai on 2018/5/28.
 */
class VirtualLayoutActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.virtual_layout_activity_layout)
        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView?
        val layoutManager = VirtualLayoutManager(this)
        recyclerView?.layoutManager = layoutManager

        val layoutHelpers = LinkedList<LayoutHelper>()
        val gridLayoutHelper = GridLayoutHelper(4, 25)
        val linearLayoutHelper = LinearLayoutHelper(0, 10)
        layoutHelpers.add(gridLayoutHelper)
        layoutHelpers.add(linearLayoutHelper)
        layoutManager.setLayoutHelpers(layoutHelpers)

//        val viewPool = RecyclerView.RecycledViewPool()
//        viewPool.setMaxRecycledViews(0, 10)
//        recyclerView?.recycledViewPool = viewPool
        val adapter = object : VirtualLayoutAdapter<MainViewHolder>(layoutManager){
            override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
                val layoutParams = VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300)
                holder.itemView.layoutParams = layoutParams
                (holder.itemView as TextView?)?.text = position.toString()
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder{
                return MainViewHolder(TextView(this@VirtualLayoutActivity))
            }

            override fun getItemCount(): Int {
                val helpers = getLayoutHelpers() ?: return 0
                var count = 0
                for (helper in helpers){
                    count += helper.itemCount
                }
                return count
            }
        }
        recyclerView?.adapter = adapter
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}