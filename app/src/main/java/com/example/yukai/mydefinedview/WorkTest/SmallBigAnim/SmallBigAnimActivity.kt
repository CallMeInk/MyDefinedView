package com.example.yukai.mydefinedview.WorkTest.SmallBigAnim

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.yukai.mydefinedview.ArtLearningNote.chapter12_1.ImageLoader
import com.example.yukai.mydefinedview.R
import com.example.yukai.mydefinedview.picUrl

/**
 * Created by yukai on 2018/5/11.
 */
class SmallBigAnimActivity : Activity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.small_big_anim_activity_layout)
        val imageView = findViewById(R.id.image_view) as ImageView
        val button = findViewById(R.id.btn_start) as Button
        ImageLoader.build(this).bindBitmap(picUrl, imageView)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }
}