package com.meloge.uceniedatabazafinal.data.repository

import android.util.Log
import com.meloge.uceniedatabazafinal.data.dao.TransactionDao
import com.meloge.uceniedatabazafinal.data.model.Transaction
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao
) {
    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    suspend fun getAllTransactions() {
        val transactions = transactionDao.getAllTransactions()
        transactions.forEach {
            Log.d("TransactionRepository", "Transaction: $it")
        }
    }
}