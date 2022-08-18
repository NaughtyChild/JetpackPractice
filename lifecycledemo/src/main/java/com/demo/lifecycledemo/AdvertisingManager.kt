package com.demo.lifecycledemo

import android.os.CountDownTimer
import android.util.Log

class AdvertisingManager {
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

    fun start() {
        Log.d(TAG, "start: ")
        countDownTime?.start()
    }

    fun cancel() {
        Log.d(TAG, "cancel: ")
        countDownTime?.cancel()
    }
    interface AdvertisingListener {
        fun timing(seconds:Int)
        fun interMainActivity()
    }
}