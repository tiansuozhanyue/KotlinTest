package com.example.administrator.kotlintest.calculator

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import com.example.administrator.kotlintest.BaseActivity
import com.example.administrator.kotlintest.R
import org.jetbrains.anko.*
import android.widget.BaseAdapter
import com.example.administrator.kotlintest.utils.DpUtils
import java.math.BigDecimal


class CalculatorActivity : BaseActivity() {

    var items = listOf<String>("C", "+/-", "<", " + ", "7", "8", "9", " - ", "4", "5", "6", " * ", "1", "2", "3", " / ", "0", ".", "_", "=")
    var gridView: GridView? = null
    var text: TextView? = null
    var buffer = StringBuffer()
    var isResult = true

    override fun setTitle(): String? {
        return "计算器"
    }

    override fun draWUI() {
        relativeLayout {

            background

            text = textView("0") {
                backgroundResource = R.drawable.text_edit_shape
                padding = dip(15)
                textSize = 20f
                textColor = ContextCompat.getColor(context, R.color.app_text_color_3)
                gravity = Gravity.RIGHT + Gravity.BOTTOM
            }.lparams(matchParent, dip(70)) { margin = dip(15) }

            gridView = gridView {
                numColumns = 4
            }.lparams(matchParent, wrapContent) { alignParentBottom() }

            gridView?.adapter = Adapter(context, items)

        }

    }

    override fun setListener() {
        gridView?.setOnItemClickListener { adapterView, view, i, l ->
            when (items[i]) {

                "C" -> buffer.replace(0, buffer.length, "0")

                "<" -> if (!buffer.toString().isNullOrEmpty())
                    if (buffer.endsWith(" "))
                        buffer.delete(buffer.length - 3, buffer.length)
                    else
                        buffer.delete(buffer.length - 1, buffer.length)

                in "0123456789" -> if (isResult || buffer.toString() == "0") buffer.replace(0, buffer.length, items[i]) else buffer.append(items[i])

                in " + - * / " -> if (!buffer.toString().isNullOrEmpty()
                        && !buffer.toString().contains(" + ")
                        && !buffer.toString().contains(" - ")
                        && !buffer.toString().contains(" * ")
                        && !buffer.toString().contains(" / ")) buffer.append(items[i])

                "+/-" -> if (buffer.startsWith("")) {
                } else {
                }

                "." -> buffer.append(if (buffer.get(buffer.length - 1) in "0123456789") "." else "0.")

                "=" -> {
                    val info = buffer.toString()
                    when {
                        info?.contains(" + ") -> buffer.replace(0, info.length, add(info))
                        info?.contains(" - ") -> buffer.replace(0, info.length, sub(info))
                        info?.contains(" * ") -> buffer.replace(0, info.length, mul(info))
                        info?.contains(" / ") -> buffer.replace(0, info.length, div(info))
                    }
                    isResult = true
                    text?.text = buffer.toString()
                    return@setOnItemClickListener
                }
            }
            isResult = false
            if (buffer.toString().isNullOrEmpty())
                buffer.append("0")
            text?.text = buffer.toString()
        }
    }

    private fun add(info: String): String {
        val list = info.split(" + ")
        return BigDecimal(list[0]).add(BigDecimal(list[1])).toString()
    }

    private fun sub(info: String): String {
        val list = info.split(" - ")
        return BigDecimal(list[0]).subtract(BigDecimal(list[1])).toString()
    }

    private fun mul(info: String): String {
        val list = info.split(" * ")
        return BigDecimal(list[0]).multiply(BigDecimal(list[1])).toString()
    }

    private fun div(info: String): String {
        val list = info.split(" / ")
        try {
            return BigDecimal(list[0]).divide(BigDecimal(list[1])).toString()
        } catch (e: Exception) {
            return BigDecimal(list[0]).divide(BigDecimal(list[1]), 10, BigDecimal.ROUND_HALF_UP).toString()
        }

    }

    class Adapter(private val context: Context, private val datas: List<String>) : BaseAdapter() {
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var textView = TextView(context)
            textView.width = matchParent
            textView.gravity = Gravity.CENTER
            textView.height = DpUtils.dipTopx(context, 50f)
            when (datas[p0]) {

                "+/-" -> {
                    textView?.text = datas[p0]
                    textView?.textSize = 20f
                    textView?.textColor = ContextCompat.getColor(context, R.color.app_text_color_3)
                    textView.background = ContextCompat.getDrawable(context, R.drawable.text_item_shape_white)
                }
                in " /  *  +  - =" -> {
                    textView?.text = datas[p0]
                    textView?.textSize = 20f
                    textView?.textColor = ContextCompat.getColor(context, R.color.white)
                    textView.background = ContextCompat.getDrawable(context, R.drawable.text_item_shape_orange)
                }

                "." -> {
                    textView?.text = datas[p0]
                    textView?.textSize = 22f
                    textView?.textColor = ContextCompat.getColor(context, R.color.app_text_color_3)
                    textView.background = ContextCompat.getDrawable(context, R.drawable.text_item_shape_white)
                }

                else -> {
                    textView?.text = datas[p0]
                    textView?.textSize = 16f
                    textView?.textColor = ContextCompat.getColor(context, R.color.app_text_color_3)
                    textView.background = ContextCompat.getDrawable(context, R.drawable.text_item_shape_white)
                }
            }

            return textView
        }

        override fun getItem(p0: Int): Any {
            return datas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return datas.size
        }
    }

}

