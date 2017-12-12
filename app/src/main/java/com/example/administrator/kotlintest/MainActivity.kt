package com.example.administrator.kotlintest

import android.content.Intent
import android.os.Bundle
import com.example.administrator.kotlintest.calculator.CalculatorActivity
import com.example.administrator.kotlintest.imgshow.ImageShowActivity
import org.jetbrains.anko.*

/**
 * Created by Administrator on 2017/12/8.
 */
class MainActivity : BaseActivity() {

    override fun setTitle(): String? {
        return "首页"
    }

    override fun draWUI() {
        verticalLayout {
            button("计算器") {
                onClick {
                    startActivity(Intent(this@MainActivity, CalculatorActivity::class.java))
                }
            }.lparams(matchParent, dip(44)) { margin = dip(15) }

            button("美图欣赏") {
                onClick {
                    startActivity(Intent(this@MainActivity, ImageShowActivity::class.java))
                }
            }.lparams(matchParent, dip(44)) { margin = dip(15) }
        }
    }

    override fun setListener() {}

}