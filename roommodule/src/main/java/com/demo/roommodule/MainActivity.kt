package com.demo.roommodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.roommodule.databinding.ActivityMainBinding
import com.demo.roommodule.room.Account
import com.demo.roommodule.room.AccountDataBase

class MainActivity : AppCompatActivity() {
    lateinit var mainLayout: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainLayout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainLayout.root)
        mainLayout.saveBt.setOnClickListener {
            val account = Account(loginName = getName(), loginPassword = getPassword())
            AccountDataBase.accountDb.accountDao.insertAccount(account)
        }
        mainLayout.searchBt.setOnClickListener {
            var accountList = AccountDataBase.accountDb.accountDao.loadAccountList()
            accountList.forEach {
                mainLayout.resultTv.append(
                    "accountId:${it.accountId},accountName:${it.loginName},accountPassword:${it.loginPassword}"
                )
            }
        }
    }

    private fun getPassword(): String {
        return mainLayout.accountPasswordTv.text.toString().trim()
    }

    private fun getName(): String {
        return mainLayout.accountNameTv.text.toString().trim()
    }
}