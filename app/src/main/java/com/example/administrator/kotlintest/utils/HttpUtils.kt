package com.example.administrator.kotlintest.utils

import com.example.administrator.kotlintest.bean.EventBean
import okhttp3.OkHttpClient
import okhttp3.Request
import org.greenrobot.eventbus.EventBus

/**
 * Created by Administrator on 2017/12/8.
 */
class HttpUtils private constructor() {

    companion object {
        val intence = HttpUtils()
    }

    fun requestDataByGet(code: Int?, url: String?, map: Map<String, String>) {

        var urlRequest: String
        if (map?.size > 0) {
            var info = StringBuffer()
            for ((k, v) in map) {
                info.append("&$k=$v")
            }
            urlRequest = url + "?" + info.substring(1, info?.length)
        } else {
            urlRequest = url!!
        }

        Thread(Runnable {
            val client = OkHttpClient()
            val request = Request.Builder().url(urlRequest).build()
            val response = client?.newCall(request)?.execute()
            EventBus.getDefault().post(EventBean(code!!, response?.body()?.string()!!))
        }).start()
    }

}