package com.meloge.uceniedatabazafinal.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meloge.uceniedatabazafinal.data.model.Transaction

@Composable
fun TransactionListScreen(
    transactions: List<Transaction>,
    onDeleteAllTransactions: () -> Unit,
    onNavigateToAddTransaction: () -> Unit,
    totalAmount: Double
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Total Amount: $totalAmount")
        Button(onClick = { onNavigateToAddTransaction() }) {
            Text(text = "Add Transaction")
        }
        Button(onClick = { onDeleteAllTransactions() }) {
            Text(text = "Delete All Transactions")
        }
        transactions.forEach { transaction ->
            TransactionItem(transaction = transaction)
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(text = "Amount: ${transaction.amount}")
        Text(text = "Description: ${transaction.description}")
        Text(text = "Date: ${transaction.date}")
    }
}