package com.demo.lifecycledemo

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.*

class AdvertisingManager(millsSeconds: Long) : LifecycleEventObserver {
    private val TAG = "AdvertisingManager"
    var advertisingListener: AdvertisingListener? = null

    private var countDownTime: CountDownTimer? = object : CountDownTimer(millsSeconds, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            Log.d(TAG, "onTick: time left ${millisUntilFinished / 1000}")
            advertisingListener?.timing((millisUntilFinished / 1000).toInt())
        }

        override fun onFinish() {
            Log.d(TAG, "onFinish: ")
            advertisingListener?.interMainActivity()
        }
    }

    fun start() {
        Log.d(TAG, "start: ")
        countDownTime?.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cancel() {
        Log.d(TAG, "cancel: ")
        countDownTime?.cancel()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.d(TAG, "onStateChanged: $event ")
            }
            Lifecycle.Event.ON_START -> {
                Log.d(TAG, "onStateChanged:$event  ")
            }
            Lifecycle.Event.ON_RESUME -> {
                Log.d(TAG, "onStateChanged:$event  ")
                start()
            }
            Lifecycle.Event.ON_PAUSE -> {
                Log.d(TAG, "onStateChanged:$event  ")
            }
            Lifecycle.Event.ON_STOP -> {
                Log.d(TAG, "onStateChanged: $event")
            }
            Lifecycle.Event.ON_DESTROY -> {
                cancel()
                Log.d(TAG, "onStateChanged: ")
            }
            Lifecycle.Event.ON_ANY -> {
                Log.d(TAG, "onStateChanged: $event")
            }
        }
    }

    interface AdvertisingListener {
        fun timing(seconds: Int)
        fun interMainActivity()
    }
}