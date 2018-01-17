package com.example.yukai.mydefinedview.BasicView.ActivityLifeCycleTest

import android.os.Bundle
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/1/17.
 */
class Activity_B(activityLabel: String = "activity_B") : BaseActivity(activityLabel){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_layout)
    }
}