package com.demo.lifecycledemo.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StudentRepository {
    fun getScore(id: Int): LiveData<Int> {
        val studentMutableLiveData = MutableLiveData<Int>()
        if (id == 1) {
            studentMutableLiveData.value = 90
        } else {
            studentMutableLiveData.value = 60
        }
        return studentMutableLiveData
    }
}