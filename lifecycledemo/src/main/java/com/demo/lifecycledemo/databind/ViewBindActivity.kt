package com.demo.lifecycledemo.databind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.demo.lifecycledemo.databinding.ActivityViewBindBinding

class ViewBindActivity : AppCompatActivity() {
    lateinit var viewBindLayout: ActivityViewBindBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view: View
        viewBindLayout = ActivityViewBindBinding.inflate(layoutInflater)
        setContentView(viewBindLayout.root)
        viewBindLayout.clickHandler = ClickHandler()
/*        viewBindLayout.confirmBt.setOnClickListener {
            viewBindLayout.user = getUser()
            *//*viewBindLayout.userIdTv.text = user.userId
            viewBindLayout.userNameTv.text = user.name*//*
        }*/
    }

    private fun getUser(): User {
        return User(getUserName(), getUserId())
    }

    private fun getUserId(): String? {
        return viewBindLayout.userIdEt.text?.toString()
    }

    private fun getUserName(): String? {
        return viewBindLayout.userNameEt.text?.toString()
    }

    inner class ClickHandler {
        fun click(view:View) {
            viewBindLayout.user = getUser()
        }
    }
}