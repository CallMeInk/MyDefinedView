package com.example.yukai.mydefinedview.BasicView.FragmentAndActivityTest

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created by yukai on 2018/4/2.
 */
open class BaseActivity : FragmentActivity(){

    open fun getLogActivityName() = "BaseActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("yk", "${getLogActivityName()}::onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.e("yk", "${getLogActivityName()}::onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e("yk", "${getLogActivityName()}::onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("yk", "${getLogActivityName()}::onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("yk", "${getLogActivityName()}::onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("yk", "${getLogActivityName()}::onDestroy")
        super.onDestroy()
    }

}
