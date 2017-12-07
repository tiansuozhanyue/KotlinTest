package com.example.administrator.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "kotlin测试"
        deawUI()
    }

    fun deawUI() {
        verticalLayout {

            val edit00 = editText {
                hint = "输入第一个数字"
                inputType = InputType.TYPE_CLASS_NUMBER
            }.lparams(matchParent, dip(40)) { topMargin = dip(10) }

            val edit01 = editText {
                hint = "输入第二个数字"
                inputType = InputType.TYPE_CLASS_NUMBER
            }.lparams(matchParent, dip(40)) { topMargin = dip(10) }

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                val btn = button("乘").lparams(wrapContent, matchParent)

                val tet = textView { gravity = Gravity.CENTER_VERTICAL }.lparams(matchParent, matchParent) { leftMargin = dip(10) }

                btn.onClick {
                    if (edit00.text.isNullOrEmpty())
                        toast("请输入第一个数字")
                    else if (edit01.text.isNullOrEmpty())
                        toast("请输入第二个数字")
                    else
                        tet.text = BigDecimal(edit00.text.toString()).multiply(BigDecimal(edit01.text.toString())).toString()
                }

            }.lparams(matchParent, dip(40)) { topMargin = dip(10) }

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                val btn = button("除").lparams(wrapContent, matchParent)

                val tet = textView { gravity = Gravity.CENTER_VERTICAL }.lparams(matchParent, matchParent) { leftMargin = dip(10) }

                btn.onClick {
                    if (edit00.text.isNullOrEmpty())
                        toast("请输入第一个数字")
                    else if (edit01.text.isNullOrEmpty())
                        toast("请输入第二个数字")
                    else
                        tet.text = BigDecimal(edit00.text.toString()).divide(BigDecimal(edit01.text.toString())).setScale(4, BigDecimal.ROUND_HALF_DOWN).toString()
                }

            }.lparams(matchParent, dip(40)) { topMargin = dip(10) }

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                val btn = button("加").lparams(wrapContent, matchParent)

                val tet = textView { gravity = Gravity.CENTER_VERTICAL }.lparams(matchParent, matchParent) { leftMargin = dip(10) }

                btn.onClick {
                    if (edit00.text.isNullOrEmpty())
                        toast("请输入第一个数字")
                    else if (edit01.text.isNullOrEmpty())
                        toast("请输入第二个数字")
                    else
                        tet.text = BigDecimal(edit00.text.toString()).add(BigDecimal(edit01.text.toString())).toString()
                }

            }.lparams(matchParent, dip(40)) { topMargin = dip(10) }

            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                val btn = button("减").lparams(wrapContent, matchParent)

                val tet = textView { gravity = Gravity.CENTER_VERTICAL }.lparams(matchParent, matchParent) { leftMargin = dip(10) }

                btn.onClick {
                    if (edit00.text.isNullOrEmpty())
                        toast("请输入第一个数字")
                    else if (edit01.text.isNullOrEmpty())
                        toast("请输入第二个数字")
                    else
                        tet.text = BigDecimal(edit00.text.toString()).subtract(BigDecimal(edit01.text.toString())).toString()
                }

            }.lparams(matchParent, dip(40)) { topMargin = dip(10) }

        }
    }

}
