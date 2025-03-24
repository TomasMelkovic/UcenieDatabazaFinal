package com.meloge.uceniedatabazafinal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "amount")
    val amount: Double,
    @ColumnInfo(name = "description")
    val description: String
)