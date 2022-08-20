package com.demo.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.liveData

private const val TAG = "AdvertisingActivity"
class AdvertisingActivity : AppCompatActivity() {
    private var timeTv: TextView? = null
    private val advertisingListener: AdvertisingManager.AdvertisingListener by lazy {
        object : AdvertisingManager.AdvertisingListener {
            override fun timing(seconds: Int) {
                timeTv?.text = " left $seconds "
            }

            override fun interMainActivity() {
                MainActivity.actionStart(this@AdvertisingActivity)
                finish()
            }
        }
    }
    private val advertisingManager: AdvertisingManager = AdvertisingManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertising)
        timeTv = findViewById(R.id.timeTv)
        advertisingManager.advertisingListener = advertisingListener
        timeTv?.setOnClickListener {
            Log.d(TAG, "click:${lifecycle.currentState} ")
            MainActivity.actionStart(this)
            finish()
        }
        lifecycle.addObserver(advertisingManager)
        Log.d(TAG, "onCreate: ${lifecycle.currentState}")
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