package com.example.yukai.mydefinedview.BasicView.ActivityLifeCycleTest

import android.app.Activity
import android.os.Bundle
import android.util.Log

/**
 * Created by yukai on 2018/1/17.
 */
open class BaseActivity(activityLabel: String) : Activity(){

    private var activity: String = activityLabel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("yk", activity + "::onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("yk", activity + "::onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("yk", activity + "::onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("yk", activity + "::onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("yk", activity + "::onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("yk", activity + "::onDestroy")
    }

}