package com.demo.lifecycledemo.databind

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class User1 : BaseObservable() {

    @get:Bindable
    var userName: String = ""
        set(value) {
            field = value
            //notifyPropertyChanged(BR.userName)
        }
    var userId: String = ""
        set(value) {
            field = value
//            notifyPropertyChanged(BR.userId)
        }
}
