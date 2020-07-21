package com.example.yukai.mydefinedview.BasicView.ActivityLifeCycleTest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/1/17.
 */
class Activity_A(activityLabel: String = "activity_A") : BaseActivity(activityLabel){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a_layout)
        findViewById(R.id.btn).setOnClickListener { v ->
            val intent: Intent = Intent(this, Activity_B::class.java)
            startActivity(intent)
        }
    }
}