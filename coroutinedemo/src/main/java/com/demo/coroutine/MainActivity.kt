package com.demo.coroutine

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            loadData().collect() {
                Log.d(TAG, "onCreate: flow $it")
            }
        }
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_foreground)
    }

    private fun test1() {
        var job = GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "onCreate:test1 ${Thread.currentThread().name}")
        }
    }

    fun test2() {
        val job = Job()
        CoroutineScope(job).launch {
        }
    }

    private fun loadData() = flow {
        Log.d(TAG, "loadData: inter loadData method,run in ${Thread.currentThread().name}")
        for (i in 1..20) {
            delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.Main)
        .filter {
            Log.d(TAG, "loadData:filter in ${Thread.currentThread().name} ")
            it % 2 == 0
        }.flowOn(Dispatchers.Default)
        .map {
            Log.d(TAG, "loadData:map in ${Thread.currentThread().name} ")
            it * 10
        }.flowOn(Dispatchers.IO)
}