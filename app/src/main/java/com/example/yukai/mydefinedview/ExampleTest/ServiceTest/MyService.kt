package com.example.yukai.mydefinedview.ExampleTest.ServiceTest

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/5/17.
 */
class MyService : Service(){

    val mBinder = DownloadBinder()

    override fun onBind(intent: Intent?): IBinder? {
        Log.e("yk", "onBind")
        return mBinder
    }

    override fun onCreate() {
        Log.e("yk", "onCreate")
        super.onCreate()
        val notificationIntent = Intent(this, ServiceTestActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val notificationBuilder = Notification.Builder(this)
        notificationBuilder.setSmallIcon(R.drawable.hilton)
                .setTicker("Notification come")
                .setWhen(System.currentTimeMillis())
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setContentIntent(pendingIntent)
        val notification = notificationBuilder.build()
        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("yk", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.e("yk", "onDestroy")
        super.onDestroy()
    }

    inner class DownloadBinder : Binder(){

        fun startDownload(){
            Log.e("yk", "startDownload")
        }

        fun getProgress(){
            Log.e("yk", "getProgress")
        }

    }

}