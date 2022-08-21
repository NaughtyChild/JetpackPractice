package com.demo.lifecycledemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class AdvertisingViewModel(application: Application) : AndroidViewModel(application) {
    var seconds = 5000L

}