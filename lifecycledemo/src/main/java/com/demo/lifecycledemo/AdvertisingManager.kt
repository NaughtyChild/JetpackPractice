package com.demo.lifecycledemo

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.*

class AdvertisingManager(viewModel: AdvertisingViewModel) : LifecycleEventObserver {
    private val TAG = "AdvertisingManager"
    private var countDownTime: CountDownTimer? = object : CountDownTimer(viewModel.seconds,
        1000) {
        override fun onTick(millisUntilFinished: Long) {
            Log.d(TAG, "onTick: $millisUntilFinished")
            Log.d(TAG, "onTick: time left ${millisUntilFinished / 1000}")
            viewModel.setTimingResult(millisUntilFinished/1000)
        }

        override fun onFinish() {
            Log.d(TAG, "onFinish: ")
            viewModel.setTimingResult(0)
        }
    }

    private fun start() {
        Log.d(TAG, "start: ")
        countDownTime?.start()
    }

    private fun cancel() {
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
}