package com.example.yukai.mydefinedview.BasicView.FragmentAndActivityTest

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by yukai on 2018/4/2.
 */
open class BaseFragment : Fragment(){

    open fun getLogName() = "BaseFragment"

    override fun onAttach(context: Context) {
        Log.e("yk", "${getLogName()}::onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("yk", "${getLogName()}::onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("yk", "${getLogName()}::onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.e("yk", "${getLogName()}::onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.e("yk", "${getLogName()}::onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e("yk", "${getLogName()}::onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("yk", "${getLogName()}::onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("yk", "${getLogName()}::onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.e("yk", "${getLogName()}::onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e("yk", "${getLogName()}::onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.e("yk", "${getLogName()}::onDetach")
        super.onDetach()
    }

}