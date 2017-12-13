package com.nankai.kotlin.di

import com.nankai.kotlin.Main2Activity
import com.nankai.kotlin.MainActivity
import com.nankai.kotlin.MainFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by vnapn on 12/13/2017.
 */
@Singleton
@Component(modules = arrayOf(TestModule::class))
interface TestComponent{
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(main2Activity: Main2Activity)
}