package com.demo.hiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.demo.hiltdemo.hiltconfig.User
import com.demo.hiltdemo.hiltconfig.ZhangSan
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    @ZhangSan
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: $user,${user.hashCode()}")
    }
}