package com.demo.roommodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.demo.roommodule.databinding.ActivityMainBinding
import com.demo.roommodule.room.Account
import com.demo.roommodule.room.AccountDao
import com.demo.roommodule.room.AccountDataBase

class MainActivity : AppCompatActivity() {
    lateinit var mainLayout: ActivityMainBinding
    private val accountDao: AccountDao by lazy {
        AccountDataBase.accountDb.accountDao
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainLayout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainLayout.root)
        mainLayout.saveBt.setOnClickListener {
            val account = Account(loginName = getName(), loginPassword = getPassword())
            var list = accountDao.findAccountByLoginAccount(account.loginName)
            if (list.isEmpty()) {
                accountDao.insertAccount(account)
            } else {
                Toast.makeText(this@MainActivity,"用户信息已经存在",Toast.LENGTH_SHORT).show()
            }
        }
        mainLayout.searchBt.setOnClickListener {
            var accountList = accountDao.loadAccountList()
            accountList.forEach {
                mainLayout.resultTv.append(
                    "accountId:${it.accountId},accountName:${it.loginName}," +
                            "accountPassword:${it.loginPassword} \n"
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