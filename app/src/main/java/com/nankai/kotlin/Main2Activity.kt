package com.nankai.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import javax.inject.Inject

/**
 * Created by vnapn on 12/13/2017.
 */
class Main2Activity : AppCompatActivity() {

    @Inject
    lateinit var dataBean: DataBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppController.graph.inject(this)
        setContentView(R.layout.activity_main_2)

        Log.e("Main2Activity","TestModule Main2: " + dataBean.address)

        dataBean.address = "nam ne"
    }
}