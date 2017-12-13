package com.nankai.kotlin.di

import com.nankai.kotlin.DataBean
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by vnapn on 12/13/2017.
 */
@Module
class TestModule{

    @Provides
    @Singleton
    fun provideDataBean(): DataBean = DataBean()
}