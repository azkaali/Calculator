package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View)
    {
        if(isNewOp)
        {
            showNum.setText("")
        }
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=showNum.text.toString()
        when(buSelect.id){
            bu0.id->{
                buClickValue+="0"
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+="2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+="4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+="6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+="8"
            }
            bu9.id->{
                buClickValue+="9"
            }

            buDecimal.id->{
                buClickValue+="."
            }
            buPlusMinus.id->{
                buClickValue+="-"+buClickValue
            }
        }
        showNum.setText(buClickValue)
    }
    var op ="*"
    var oldNum=""
    val newNum=""
    var isNewOp=true
    fun buOpEvent(view: View)
    {
        val buSelect= view as Button
        var buClickValue:String=showNum.text.toString()
        when(buSelect.id) {
            buMultiply.id -> {
                op = "*"
            }
            buPlus.id -> {
                op = "+"
            }
            buMinus.id -> {
                op = "-"
            }
            buDiv.id -> {
                op = "/"
            }
        }
        oldNum=showNum.text.toString()
        isNewOp=true
    }

    fun buEqualsEvent(view: View)
    {
        val newNum=showNum.text.toString()
        var finalNum:Double?=null
        when(op)
        {
            "*"->{
                finalNum=oldNum.toDouble()*newNum.toDouble()
            }
            "+"->{
                finalNum=oldNum.toDouble()+newNum.toDouble()
            }
            "-"->{
                finalNum=oldNum.toDouble()-newNum.toDouble()
            }
            "/"->{
                finalNum=oldNum.toDouble()/newNum.toDouble()
            }

        }
        showNum.setText(finalNum.toString())
        isNewOp=true
    }
    fun clean(view: View)
    {
        showNum.setText("0")
        isNewOp=true

    }
    fun percent(view: View)
    {
        val number:Double=showNum.text.toString().toDouble()/100

        showNum.setText(number.toString())
        isNewOp=true

    }
}