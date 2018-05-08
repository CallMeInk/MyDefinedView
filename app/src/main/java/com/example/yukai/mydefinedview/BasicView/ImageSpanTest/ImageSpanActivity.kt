package com.example.yukai.mydefinedview.BasicView.ImageSpanTest

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.widget.TextView
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/4/23.
 */
class ImageSpanActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_span_activity_layout)
        val text = findViewById(R.id.image_span_text) as TextView
        val spannable = SpannableString("Foo    imageplace Bar!")
        val stringUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524485403237&di=ae15b3b9f8373a2a744a5cf25a9f8eb8&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180411%2F65300f263c7b42b3b58e7838b573b698.jpeg"
        val imageSpan = ImageSpan(this, Uri.parse(stringUrl))
        spannable.setSpan(imageSpan, 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setText(spannable)
    }

}