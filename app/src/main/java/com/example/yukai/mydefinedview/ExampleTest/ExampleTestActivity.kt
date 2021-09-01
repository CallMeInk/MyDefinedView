package com.example.yukai.mydefinedview.ExampleTest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.yukai.mydefinedview.ExampleTest.AsyncTaskTest.AsyncTaskTestActivity
import com.example.yukai.mydefinedview.ExampleTest.HandlerTest.HandlerTestActivity
import com.example.yukai.mydefinedview.ExampleTest.HttpTest.HttpTestActivity
import com.example.yukai.mydefinedview.ExampleTest.ServiceTest.ServiceTestActivity
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/5/17.
 */
class ExampleTestActivity : Activity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_test_activity)
        findViewById<Button>(R.id.handler_test_btn).setOnClickListener(this)
        findViewById<Button>(R.id.service_test_btn).setOnClickListener(this)
        findViewById<Button>(R.id.http_test_btn).setOnClickListener(this)
        findViewById<Button>(R.id.asynctask_test_btn).setOnClickListener(this)
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
            R.id.http_test_btn -> {
                val intent = Intent(this, HttpTestActivity::class.java)
                startActivity(intent)
            }
            R.id.asynctask_test_btn -> {
                val intent = Intent(this, AsyncTaskTestActivity::class.java)
                startActivity(intent)
            }
        }
    }

}