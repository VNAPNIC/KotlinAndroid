package com.nankai.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName

    var list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Hello world")
        btnChangeText.setOnClickListener { v -> if (this@MainActivity.textView.text.equals("1"))changeText("2") else changeText("1")}

        list = arrayListOf("1","2","3","4","2")
        list.forEach { s: String -> Log.e(TAG,"forEach: "+s) }
        list.map { s: String ->  Log.e(TAG,"map: "+s)}
        list.filter { s: String -> s.equals("3") }

        val a = Object1("nam","Huong")
        a.getObject2()
    }

    fun  changeText(value: String?): Unit{
        this@MainActivity.textView.text = value
    }

    class Object1(value: String?,var value2: String?): Object2(value){
        override fun getObject2() {
            super.getObject2()
            Log.e("Object1","value2: "+value2)
        }
    }

    open class Object2( var value4: String?){

        open fun getObject2(): Unit{
            Log.e("getObject2","value4: "+value4)
        }
    }
}
