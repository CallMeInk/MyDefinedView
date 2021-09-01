package com.example.yukai.mydefinedview.ExampleTest.ServiceTest

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/5/17.
 */
class ServiceTestActivity : Activity(), View.OnClickListener{

    var downloadBinder: MyService.DownloadBinder? = null
    val connection: ServiceConnection = object : ServiceConnection{

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.e("yk", "onServiceDisconnected")
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder = service as MyService.DownloadBinder?
            downloadBinder?.startDownload()
            downloadBinder?.getProgress()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.service_test_actvity)
        findViewById<Button>(R.id.start_service).setOnClickListener(this)
        findViewById<Button>(R.id.stop_service).setOnClickListener(this)
        findViewById<Button>(R.id.bind_service).setOnClickListener(this)
        findViewById<Button>(R.id.unbind_service).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id
        when(id){
            R.id.start_service -> {
                val startIntent = Intent(this, MyService::class.java)
                startService(startIntent)
            }
            R.id.stop_service -> {
                val startIntent = Intent(this, MyService::class.java)
                stopService(startIntent)
            }
            R.id.bind_service -> {
                val bindIntent = Intent(this, MyService::class.java)
                bindService(bindIntent, connection, Context.BIND_AUTO_CREATE)
            }
            R.id.unbind_service -> {
                unbindService(connection)
            }
        }
    }
}