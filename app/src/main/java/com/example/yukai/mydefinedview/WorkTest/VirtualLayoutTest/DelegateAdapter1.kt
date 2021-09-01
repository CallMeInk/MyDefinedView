package com.example.yukai.mydefinedview.WorkTest.VirtualLayoutTest

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/5/28.
 */
class DelegateAdapter1 : DelegateAdapter.Adapter<DelegateAdapter1.InnerViewHolder>(){

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        holder.textView?.text = position.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        return InnerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.v_layout_item_view, parent, false))
    }

    override fun onCreateLayoutHelper(): LayoutHelper {
//        val layoutHelper = LinearLayoutHelper()
        val layoutHelper = GridLayoutHelper(3, 20)
        return layoutHelper
    }

    override fun getItemCount(): Int {
        return 30
    }

    inner class InnerViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        var textView: TextView? = null

        init {
            textView = view.findViewById(R.id.v_item_tv) as TextView?
        }
    }
}