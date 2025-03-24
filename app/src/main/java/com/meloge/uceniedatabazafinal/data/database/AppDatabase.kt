package com.meloge.uceniedatabazafinal.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meloge.uceniedatabazafinal.data.dao.TransactionDao
import com.meloge.uceniedatabazafinal.data.model.Transaction

@Database(entities = [Transaction::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}