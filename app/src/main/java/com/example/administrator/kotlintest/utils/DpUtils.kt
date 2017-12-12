package com.example.administrator.kotlintest.utils

import android.content.Context

/**
 * Created by Administrator on 2017/12/12.
 */
object DpUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dipTopx(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun pxTodip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }
}