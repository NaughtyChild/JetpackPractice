package com.demo.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test1()
    }

    private fun test1() {
        var job = GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "onCreate:test1 ${Thread.currentThread().name}")
        }
    }
    fun test2() {
        val job=Job()
        CoroutineScope(job).launch {

        }

    }
}