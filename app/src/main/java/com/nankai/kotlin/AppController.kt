package com.nankai.kotlin

import android.app.Application
import com.nankai.kotlin.di.DaggerTestComponent
import com.nankai.kotlin.di.TestComponent
import com.nankai.kotlin.di.TestModule

/**
 * Created by vnapn on 12/13/2017.
 */
class AppController : Application() {

    companion object {
        @JvmStatic lateinit var graph: TestComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerTestComponent.builder().testModule(TestModule()).build()
    }
}