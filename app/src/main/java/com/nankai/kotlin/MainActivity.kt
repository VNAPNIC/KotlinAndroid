package com.nankai.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName

    var list = ArrayList<String>()

    @Inject
    lateinit var dataBean:DataBean

    var dataNew:DataBean = DataBean()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppController.graph.inject(this)

        setContentView(R.layout.activity_main)

        list = arrayListOf("1","2","3","4","2")
        list.forEach { s: String -> Log.e(TAG,"forEach: "+s) }
        list.map { s: String ->  Log.e(TAG,"map: "+s)}
        list.filter { s: String -> s == "3" }
        val a = Object1("nam","Huong")
        a.getObject2()

        dataNew.address ="1"

        dataBean.address = "Huong ngu"

        dataBean = dataNew

        var transaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container,MainFragment().newInstance())
        transaction.commit()

        btnChangeText.setOnClickListener { if (this@MainActivity.textView.text == "1")changeText("2") else changeText("1")}
        btnNewActivity.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity,Main2Activity::class.java)
            startActivity(intent)
        })
    }


    override fun onStart() {
        super.onStart()

        Log.e(TAG,"TestModule Main: " + dataBean.address)
    }


    private fun  changeText(value: String?){
        this@MainActivity.textView.text = value
    }

    class Object1(value: String?, private var value2: String?): Object2(value){
        override fun getObject2() {
            super.getObject2()
            Log.e("Object1","value2: "+value2)
        }
    }

    open class Object2(private var value4: String?){

        open fun getObject2(){
            Log.e("getObject2","value4: "+value4)
        }
    }
}
