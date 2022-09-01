package com.demo.lifecycledemo.databind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.demo.lifecycledemo.databinding.ActivityViewBindBinding

class ViewBindActivity : AppCompatActivity() {
    lateinit var viewBindLayout: ActivityViewBindBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBindLayout = ActivityViewBindBinding.inflate(layoutInflater)
        setContentView(viewBindLayout.root)
        viewBindLayout.user = User1()

/*        viewBindLayout.confirmBt.setOnClickListener {
            viewBindLayout.user = getUser()
            *//*viewBindLayout.userIdTv.text = user.userId
            viewBindLayout.userNameTv.text = user.name*//*
        }*/
    }

    private fun getUser(): User {
        return User(getUserName(), getUserId(),
            "https://img1.baidu.com/it/u=4237248153,2960427068&fm=253&fmt=auto&app=120&f=PNG?w=803&h=500",
            1)
    }

    private fun getUserId(): String? {
        return viewBindLayout.userIdEt.text?.toString()
    }

    private fun getUserName(): String? {
        return viewBindLayout.userNameEt.text?.toString()
    }
}