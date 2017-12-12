package com.example.administrator.kotlintest.api

import com.example.administrator.kotlintest.utils.HttpUtils

/**
 * Created by Administrator on 2017/12/8.
 */
class Api {

    val IMG_LIST = 1

    //    http://blog.csdn.net/jingtian678/article/details/69525277
    val url_img = "http://image.baidu.com/channel/listjson"

    companion object {
        val instance = Api()
    }

    fun getImgList(num: Int?) {
        val map = mapOf("showapi_appid" to "51737"
                , "tag2" to "全部"
                , "tag1" to "美女"
                , "ie" to "utf8"
                , "rn" to "20"
                , "pn" to num.toString()
        )
        HttpUtils.intence.requestDataByGet(IMG_LIST, url_img, map)
    }


}