package com.meloge.uceniedatabazafinal.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meloge.uceniedatabazafinal.data.model.Transaction
import com.meloge.uceniedatabazafinal.data.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {
    fun insertTransaction(transaction: Transaction) {
        viewModelScope.launch {
            transactionRepository.insertTransaction(transaction)
        }
    }
    fun getAllTransactions() {
        viewModelScope.launch {
            transactionRepository.getAllTransactions()
        }
    }
}