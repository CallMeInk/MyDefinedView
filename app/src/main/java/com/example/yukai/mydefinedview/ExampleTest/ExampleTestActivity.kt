package com.example.yukai.mydefinedview.ExampleTest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.yukai.mydefinedview.ExampleTest.HandlerTest.HandlerTestActivity
import com.example.yukai.mydefinedview.ExampleTest.ServiceTest.ServiceTestActivity
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/5/17.
 */
class ExampleTestActivity : Activity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_test_activity)
        findViewById(R.id.handler_test_btn).setOnClickListener(this)
        findViewById(R.id.service_test_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id
        when(id){
            R.id.handler_test_btn -> {
                val intent = Intent(this, HandlerTestActivity::class.java)
                startActivity(intent)
            }
            R.id.service_test_btn -> {
                val intent = Intent(this, ServiceTestActivity::class.java)
                startActivity(intent)
            }
        }
    }

}