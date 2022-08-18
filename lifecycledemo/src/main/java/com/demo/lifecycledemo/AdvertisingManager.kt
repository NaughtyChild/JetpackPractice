package com.demo.lifecycledemo

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class AdvertisingManager : LifecycleObserver {
    private val TAG = "AdvertisingManager"
    var advertisingListener: AdvertisingListener? = null

    private var countDownTime: CountDownTimer? = object : CountDownTimer(5000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            Log.d(TAG, "onTick: time left ${millisUntilFinished / 1000}")
            advertisingListener?.timing((millisUntilFinished / 1000).toInt())
        }

        override fun onFinish() {
            Log.d(TAG, "onFinish: ")
            advertisingListener?.interMainActivity()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun start() {
        Log.d(TAG, "start: ")
        countDownTime?.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cancel() {
        Log.d(TAG, "cancel: ")
        countDownTime?.cancel()
    }

    interface AdvertisingListener {
        fun timing(seconds: Int)
        fun interMainActivity()
    }
}