package com.meloge.uceniedatabazafinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.meloge.uceniedatabazafinal.data.model.Transaction

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions")
    suspend fun getAllTransactions(): List<Transaction>
}