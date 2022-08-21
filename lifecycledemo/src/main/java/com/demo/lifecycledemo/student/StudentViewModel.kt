package com.demo.lifecycledemo.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private var studentLiveData = MutableLiveData<Student>()

    val _studentLiveData: LiveData<Student>
        get() = studentLiveData

    fun setStudentMessage(student: Student) {
        studentLiveData.value = student
    }

    fun getScore(id: Int): LiveData<Int> {
        return StudentRepository().getScore(id)
    }

    private var studentIdLiveData = MutableLiveData<Int>()

     var newScore: LiveData<Int> = Transformations.switchMap(studentIdLiveData) {
        StudentRepository().getScore(it)
    }

    fun setStudentId(id: Int) {
        studentIdLiveData.value = id
    }


}