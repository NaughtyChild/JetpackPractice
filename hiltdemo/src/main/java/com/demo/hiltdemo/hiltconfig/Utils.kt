package com.demo.hiltdemo.hiltconfig

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class Utils {

    @Provides
    @Singleton
    @ZhangSan
    fun getUser(): User {
        return User("张三", 22)
    }

    @Provides
    @Singleton
    @LiSi
    fun getUser1(): User {
        return User("李四", 25)
    }
}

data class User @Inject constructor(val name: String, val age: Int)

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ZhangSan


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LiSi