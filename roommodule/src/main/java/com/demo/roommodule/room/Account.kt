package com.demo.roommodule.room

import androidx.room.*
import com.demo.roommodule.MyApplication

@Entity
data class Account(
    @PrimaryKey(autoGenerate = true)
    var accountId: Int? = null,
    var loginName: String,
    var loginPassword: String
)

@Dao
interface AccountDao {

    @Insert
    fun insertAccount(account: Account)

    @Query("select * from Account")
    fun loadAccountList(): List<Account>

    @Query("select * from Account where loginName == :loginName ")
    fun findAccountByLoginAccount(loginName:String):List<Account>

}

@Database(entities = arrayOf(Account::class), version = 1)
abstract class AccountDataBase : RoomDatabase() {
    abstract val accountDao: AccountDao

    companion object {
        val accountDb: AccountDataBase by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Room.databaseBuilder(MyApplication.context, AccountDataBase::class.java, "account.db")
                .allowMainThreadQueries()
                .build()
        }
    }
}
