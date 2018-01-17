package com.example.yukai.mydefinedview.ArtLearningNote.chapter5_1

import android.app.Activity
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.widget.RemoteViews
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/1/17.
 */
class Chapter5_1 : Activity(){

    private var contentView: RemoteViews? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chapter5_1_layout)
        val intent = Intent(this, NotificationActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        contentView = RemoteViews(packageName, R.layout.notification_layout)
        val builder = NotificationCompat.Builder(this)
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setContent(contentView)
                .setTicker("this is notification ticker text")
                .setWhen(System.currentTimeMillis())
        val notification = builder.build()
        manager.notify(0, notification)

    }

}