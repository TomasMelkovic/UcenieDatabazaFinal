package com.meloge.uceniedatabazafinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.meloge.uceniedatabazafinal.data.model.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("DELETE FROM transactions")
    suspend fun deleteAllTransactions()

}