package com.example.yukai.mydefinedview.WorkTest.ListViewAnim

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ListView
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/5/4.
 */
class ListViewAnimActivity : Activity(), View.OnClickListener{

    var mListView: ListView? = null
    var mAdapter: AnimListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_anim_activity)
        mAdapter = AnimListAdapter()
        mListView = findViewById(R.id.list_view) as ListView
        mListView?.adapter = mAdapter
        mListView?.overScrollMode = View.OVER_SCROLL_NEVER
        mListView?.setOnTouchListener { v, event -> true }
        val headerView1 = LayoutInflater.from(this).inflate(R.layout.header_view_1, mListView, false)
        val recyclerView = headerView1.findViewById(R.id.recycler_view) as RecyclerView
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = manager
        recyclerView.adapter = RecyclerViewAdapter()
        recyclerView.setOnTouchListener{ v, event -> true }
        val headerView2 = LayoutInflater.from(this).inflate(R.layout.city_guide_header_view, mListView, false)
        mListView?.addHeaderView(headerView1)
        mListView?.addHeaderView(headerView2)
        findViewById(R.id.button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        mListView?.visibility = View.INVISIBLE
        mListView?.clearAnimation()
        val animation = AnimationUtils.loadAnimation(this, R.anim.list_anim)
        val animationController = LayoutAnimationController(animation)
        animationController.order = LayoutAnimationController.ORDER_NORMAL
        animationController.delay = 0.3f
        mListView?.layoutAnimation = animationController
        mListView?.visibility = View.VISIBLE
    }

    private inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewHolder {
            val view = LayoutInflater.from(parent?.context).inflate(R.layout.anim_recycler_view_item, parent, false)
            return RecyclerViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerViewHolder?, position: Int) {
        }

        override fun getItemCount(): Int = 10
    }

    private inner class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

}