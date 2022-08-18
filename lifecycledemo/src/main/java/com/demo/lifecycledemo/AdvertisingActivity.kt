package com.demo.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AdvertisingActivity : AppCompatActivity() {
    private var timeTv: TextView? = null
    private val advertisingListener: AdvertisingManager.AdvertisingListener by lazy {
        object : AdvertisingManager.AdvertisingListener {
            override fun timing(seconds: Int) {
                timeTv?.text = " left $seconds "
            }

            override fun interMainActivity() {
                MainActivity.actionStart(this@AdvertisingActivity)
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
            MainActivity.actionStart(this)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        advertisingManager.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        advertisingManager.cancel()
    }
}