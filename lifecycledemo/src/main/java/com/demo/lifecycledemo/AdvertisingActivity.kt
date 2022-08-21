package com.demo.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData

private const val TAG = "AdvertisingActivity"

class AdvertisingActivity : AppCompatActivity() {
    private var timeTv: TextView? = null
    private lateinit var advertisingViewModel: AdvertisingViewModel

    private lateinit var advertisingManager: AdvertisingManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertising)
        advertisingViewModel = ViewModelProvider(this).get(AdvertisingViewModel::class.java)
        advertisingManager = AdvertisingManager(advertisingViewModel)
        timeTv = findViewById(R.id.timeTv)
        timeTv?.setOnClickListener {
            Log.d(TAG, "click:${lifecycle.currentState} ")
            MainActivity.actionStart(this)
            finish()
        }
        lifecycle.addObserver(advertisingManager)
        Log.d(TAG, "onCreate: ${lifecycle.currentState}")

        advertisingViewModel._timingResult.observe(this, object : Observer<Long> {
            override fun onChanged(t: Long) {
                Log.d(TAG, "onChanged: $t")
                if (t == 0L) {
                    MainActivity.actionStart(this@AdvertisingActivity)
                    finish()
                } else {
                    timeTv?.text = "left ${t}  "
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ${lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ${lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ${lifecycle.currentState}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ${lifecycle.currentState}")
    }
}