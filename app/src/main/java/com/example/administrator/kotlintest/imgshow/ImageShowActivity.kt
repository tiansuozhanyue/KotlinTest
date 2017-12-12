package com.example.administrator.kotlintest.imgshow

import android.widget.TextView
import com.example.administrator.kotlintest.BaseActivity
import com.example.administrator.kotlintest.api.Api
import com.example.administrator.kotlintest.bean.EventBean
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created by Administrator on 2017/12/8.
 */
class ImageShowActivity : BaseActivity() {
    var txt: TextView? = null

    override fun setTitle(): String? {
        return "图片欣赏"
    }

    override fun draWUI() {
        verticalLayout {
            txt = textView()
        }
        Api.instance.getImgList(1)
    }

    override fun setListener() {
        supportActionBar?.customView?.setOnClickListener({
            finish()
        })
    }

    override fun receiveEventInUI(ecent: EventBean?) {
        when (ecent?.code) {
            Api.instance.IMG_LIST -> txt?.text = ecent.info
        }
    }

    fun updataUI(){

    }

}