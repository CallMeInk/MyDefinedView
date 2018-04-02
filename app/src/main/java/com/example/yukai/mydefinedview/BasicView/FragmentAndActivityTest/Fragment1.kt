package com.example.yukai.mydefinedview.BasicView.FragmentAndActivityTest

import android.app.FragmentManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/4/2.
 */
class Fragment1 : BaseFragment(){

    var name:String = ""

    override fun getLogName(): String {
        return "Fragment1"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment1_layout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view?.findViewById(R.id.fragment_text) as? TextView
        textView?.text = "this is fragment1"
        textView?.setOnClickListener({view ->
            activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.container, Fragment2.newInstance(), "fragment2")
                    .addToBackStack("f2")
                    .commitAllowingStateLoss()
        })
    }

    companion object{
        fun newInstance(name: String): Fragment1{
            val fragment = Fragment1()
            return fragment
        }
    }


}