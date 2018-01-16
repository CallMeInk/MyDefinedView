package com.example.yukai.mydefinedview.BasicView.RatingBar

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import com.example.yukai.mydefinedview.R

/**
 * Created by yukai on 2018/1/16.
 */
class RatingBarActivity : Activity(){

    private var mRatingBar: RatingBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ratingbar_activity_layout)
        mRatingBar = findViewById(R.id.rating_bar) as RatingBar
        mRatingBar?.setOnRatingBarChangeListener{ ratingBar, rating, fromUser ->
            Log.e("yk", "on ratingbar changed::")
            Log.e("yk", "rating is ::" + rating)
            Log.e("yk", "star is ::" + ratingBar.numStars)
        }
    }

}