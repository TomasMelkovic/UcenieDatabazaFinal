package com.meloge.uceniedatabazafinal.data.repository

import com.meloge.uceniedatabazafinal.data.dao.TransactionDao
import com.meloge.uceniedatabazafinal.data.model.Transaction
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao
) {
    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }
    suspend fun deleteAllTransactions() {
        transactionDao.deleteAllTransactions()
    }

    fun getAllTransactions(): Flow<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }
}