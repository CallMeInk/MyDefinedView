package com.example.yukai.mydefinedview.ExampleTest.HttpTest

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.yukai.mydefinedview.R
import com.example.yukai.mydefinedview.Utils.ThreadPool
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


/**
 * Created by yukai on 2018/5/21.
 */
class HttpTestActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.http_test_activity_layout)
        findViewById(R.id.start_http_request).setOnClickListener { _ ->
            ThreadPool.getInstance().execute(object : Runnable{
                override fun run() {
                    val result = executeHttpGet()
                    Log.e("yk", result)
                }
            })
        }
        findViewById(R.id.start_okhttp_request).setOnClickListener { _ ->
            ThreadPool.getInstance().execute(object : Runnable{
                override fun run() {
                    val result = startOkhttpGet()
                    Log.e("yk", result)
                }
            })
        }
    }

    //brother dong force me to do this !!!
    //I give him a face
    fun executeHttpGet(): String? {
        var result: String? = null
        var url: URL? = null
        var connection: HttpURLConnection? = null
        var inputStreamReader: InputStreamReader? = null
        try {
            url = URL("https://www.baidu.com")
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000
            inputStreamReader = InputStreamReader(connection.inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val strBuffer = StringBuffer()
            var line: String? = null
            do {
                line = bufferedReader.readLine()
                strBuffer.append(line)
            } while (line != null)
            result = strBuffer.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()
            try {
                inputStreamReader?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun startOkhttpGet(): String?{
        var result: String? = null
        val okHttpClient = OkHttpClient()
        val request = Request.Builder().get().url("https://www.baidu.com").build()
        val response = okHttpClient.newCall(request).execute()
        result = if (response.isSuccessful) response.body().toString() else null
        return result
    }

}