package com.demo.lifecycledemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class AdvertisingViewModel(application: Application) : AndroidViewModel(application) {

    var seconds = 5000L

    private var timingResult = MutableLiveData<Long>()
    val _timingResult: LiveData<Long>
        get() = Transformations.map(timingResult) {
            it
        }

    fun setTimingResult(time: Long) {
        timingResult.value = time
    }

}