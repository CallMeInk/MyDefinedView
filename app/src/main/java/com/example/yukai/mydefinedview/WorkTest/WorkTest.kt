package com.example.yukai.mydefinedview.WorkTest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.yukai.mydefinedview.R
import com.example.yukai.mydefinedview.WorkTest.CircleImageViewTest.CircleImageViewActivity
import com.example.yukai.mydefinedview.WorkTest.CornerImageViewTest.CornerImageViewActivity
import com.example.yukai.mydefinedview.WorkTest.FullRoomUITest.FullRoomUITestActivity
import com.example.yukai.mydefinedview.WorkTest.ListViewAnim.ListViewAnimActivity
import com.example.yukai.mydefinedview.WorkTest.ListViewPopupWindowTest.ListViewPopupWindowTest
import com.example.yukai.mydefinedview.WorkTest.MedalTypeDemoTest.MedalTypeDemoActivity
import com.example.yukai.mydefinedview.WorkTest.SlideToShowRoomAnim.SlideToShowRoomAnimActivity
import com.example.yukai.mydefinedview.WorkTest.SmallBigAnim.SmallBigAnimActivity
import com.example.yukai.mydefinedview.WorkTest.TouchEventTest.TouchEventTestActivity
import com.example.yukai.mydefinedview.WorkTest.ViewFlipper.ViewFlipperActivity
import com.example.yukai.mydefinedview.WorkTest.VirtualLayoutTest.VirtualLayoutActivity
import com.example.yukai.mydefinedview.WorkTest.WannaGoViewTest.WannaGoViewTestActivity
import com.example.yukai.mydefinedview.WorkTest.WorkUITest.WorkUITestActivity

/**
 * Created by yukai on 2018/5/4.
 */
class WorkTest : Activity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_test_activity)
        findViewById(R.id.btn_work_ui_test).setOnClickListener(this)
        findViewById(R.id.btn_list_view_anim).setOnClickListener(this)
        findViewById(R.id.btn_small_big_pic_anim).setOnClickListener(this)
        findViewById(R.id.btn_virtual_layout).setOnClickListener(this)
        findViewById(R.id.btn_circle_image_test).setOnClickListener(this)
        findViewById(R.id.btn_room_anim).setOnClickListener(this)
        findViewById(R.id.btn_corner_image).setOnClickListener(this)
        findViewById(R.id.btn_view_flipper).setOnClickListener(this)
        findViewById(R.id.btn_touch_event_test).setOnClickListener(this)
        findViewById(R.id.btn_full_room_UI_test).setOnClickListener(this)
        findViewById(R.id.btn_wanna_go_test).setOnClickListener(this)
        findViewById(R.id.btn_list_view_popup_window).setOnClickListener(this)
        findViewById(R.id.btn_medal_type_test).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id
        if (id == R.id.btn_work_ui_test){
            val intent = Intent(this, WorkUITestActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_list_view_anim){
            val intent = Intent(this, ListViewAnimActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_small_big_pic_anim){
            val intent = Intent(this, SmallBigAnimActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_virtual_layout){
            val intent = Intent(this, VirtualLayoutActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_circle_image_test){
            val intent = Intent(this, CircleImageViewActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_room_anim){
            val intent = Intent(this, SlideToShowRoomAnimActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_corner_image){
            val intent = Intent(this, CornerImageViewActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_view_flipper){
            val intent = Intent(this, ViewFlipperActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_touch_event_test){
            val intent = Intent(this, TouchEventTestActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_full_room_UI_test){
            val intent = Intent(this, FullRoomUITestActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_wanna_go_test){
            val intent = Intent(this, WannaGoViewTestActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_list_view_popup_window){
            val intent = Intent(this, ListViewPopupWindowTest::class.java)
            startActivity(intent)
        }else if (id == R.id.btn_medal_type_test){
            val intent = Intent(this, MedalTypeDemoActivity::class.java)
            startActivity(intent)
        }
    }
}