package com.demo.hiltdemo

import android.app.Application
import android.util.Log
import com.demo.hiltdemo.hiltconfig.LiSi
import com.demo.hiltdemo.hiltconfig.User
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

private const val TAG = "MyApplication"

@HiltAndroidApp
class MyApplication : Application() {
    @Inject
    @LiSi
    lateinit var user: User
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: $user,${user.hashCode()}")
    }
}