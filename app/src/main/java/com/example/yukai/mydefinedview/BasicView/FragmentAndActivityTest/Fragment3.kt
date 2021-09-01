package com.example.yukai.mydefinedview.BasicView.FragmentAndActivityTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/4/2.
 */
class Fragment3 : BaseFragment(){

    var name:String = ""

    override fun getLogName(): String {
        return "Fragment3"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment1_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view?.findViewById(R.id.fragment_text) as? TextView
        textView?.text = "this is fragment3"
        textView?.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack(
                "f2",
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }

    companion object{
        fun newInstance(name: String): Fragment1 {
            return Fragment1()
        }
    }


}