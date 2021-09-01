package com.example.yukai.mydefinedview.ExampleTest.HandlerTest

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.yukai.mydefinedview.Utils.ThreadPool

/**
 * Created by yukai on 2018/5/17.
 */

/**
 * 结论：UI线程只有一个，会等到message1的sleep结束后，才会handle Message2的消息
 */
class HandlerTestActivity : Activity(){

    private val handler: MyHandler = MyHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ThreadPool.getInstance().execute(Runnable {
            Log.e("yk", "in thread 1")
            handler.sendEmptyMessage(1)
        })
        ThreadPool.getInstance().execute(Runnable {
            Log.e("yk", "in thread 2")
            Thread.sleep(2000)
            handler.sendEmptyMessage(2)
        })
    }

    private inner class MyHandler: Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what){
                1 -> {
                    Log.e("yk", "handle message 1")
                    Thread.sleep(5000)
                }
                2 -> Log.e("yk", "handle message 2")
            }
        }
    }

}