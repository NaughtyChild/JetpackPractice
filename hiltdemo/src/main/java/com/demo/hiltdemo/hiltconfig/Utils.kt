package com.demo.hiltdemo.hiltconfig

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject


@Module
@InstallIn(ActivityComponent::class)
class Utils {

    @Provides
    fun getUser():User {
        return User("张三", 22)
    }
}

data class User @Inject constructor(val name: String, val age: Int)