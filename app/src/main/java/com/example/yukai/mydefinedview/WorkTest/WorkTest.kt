package com.example.yukai.mydefinedview.WorkTest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.yukai.mydefinedview.R
import com.example.yukai.mydefinedview.WorkTest.ListViewAnim.ListViewAnimActivity

/**
 * Created by yukai on 2018/5/4.
 */
class WorkTest : Activity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_test_activity)
        findViewById(R.id.btn_list_view_anim).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id
        if (id == R.id.btn_list_view_anim){
            val intent = Intent(this, ListViewAnimActivity::class.java)
            startActivity(intent)
        }
    }
}