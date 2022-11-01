package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var result: TextView
    private lateinit var text2: TextView
    private var num1 = 0.0
    private var operand = " "


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.textView)
        text2 = findViewById(R.id.textView2)

    }

    @SuppressLint("SetTextI18n")
    fun onclick(clickedView: View) {

        if (clickedView is TextView) {

            var text = result.text.toString()
            val number = clickedView.text.toString()
            if (text == "0") {
                text = ""
            }
            result.text = text + number

        }

    }

    @SuppressLint("SetTextI18n")
    fun operation(clickedView: View) {


        if (clickedView is TextView) {
            operand = clickedView.text.toString()
            if (result.text != "0") {
                num1 = result.text.toString().toDouble()
            }


            val ma = result.text.toString()
            val na = text2.text.toString()
            if ((na[na.length - 1] == '/' || na[na.length - 1] == '*' || na[na.length - 1] == '+' || na[na.length - 1] == '-') && result.text == "0") {
                text2.text = na.substring(0, na.length - 1) + operand

            } else {
                text2.text = result.text.toString() + operand
            }


            result.text = "0"

        }
    }

    fun clear(view: View) {

        result.text = "0"
        text2.text = "0"
        num1 = 0.0

    }

    fun back(view: View) {

        var text3 = num1.toString().substring(0, num1.toString().length - 2)
        var text1 = result.text.toString()
        if (text1.length == 1 && num1 == 0.0) {
            result.text = "0"
        } else if (text1.length == 1) {
            result.text = text3
            text2.text = "0"
            num1 = 0.0


        } else {
            result.text = text1.substring(0, text1.length - 1)
        }

    }

    @SuppressLint("SetTextI18n")
    fun equals(clickedView: View) {
        if (clickedView is TextView) {

            val txt = text2.text.toString()
            val num2 = result.text.toString()

            println(num2)
            println(txt.length)
            if (operand == " ") {
                result.text = result.text.toString()
            } else {

                when (operand) {
                    "+" -> result.text = (num1 + num2.toDouble()).toString()
                    "-" -> result.text = (num1 - num2.toDouble()).toString()
                    "*" -> result.text = (num1 * num2.toDouble()).toString()
                    "/" -> result.text = (num1 / num2.toDouble()).toString()


                }
                operand = " "

                val newnum = result.text.toString()

                if (newnum.substring(newnum.length - 2, newnum.length) == ".0") {
                    result.text = newnum.substring(0, newnum.length - 2)
                }
            }
            text2.text = "0"
            num1 = 0.0


        }
    }


    fun dotClick(clickedView: View) {
        if (clickedView is TextView) {
            var sum = 0
            val txt = result.text.toString()



            for (i in txt.indices) if (txt[i] == '.') {
                sum += 1

            }
            if (sum == 0) {
                result.text = "$txt."
            }


        }

    }


}