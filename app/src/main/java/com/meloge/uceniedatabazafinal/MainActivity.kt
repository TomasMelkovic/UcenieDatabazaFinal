package com.meloge.uceniedatabazafinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.meloge.uceniedatabazafinal.data.model.Transaction
import com.meloge.uceniedatabazafinal.ui.screen.AddTransactionScreen
import com.meloge.uceniedatabazafinal.ui.screen.TransactionListScreen
import com.meloge.uceniedatabazafinal.ui.theme.UcenieDatabazaFinalTheme
import com.meloge.uceniedatabazafinal.ui.viewmodel.TransactionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val transactionViewModel: TransactionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            //transactionViewModel.deleteAllTransactions()
            //transactionViewModel.insertTransaction(Transaction(amount = 10.0, description = "Test"))
        }

        setContent {
            UcenieDatabazaFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    var showAddTransactionScreen by remember { mutableStateOf(false) }
                    val transactions by transactionViewModel.transactions.collectAsState()

                    if (showAddTransactionScreen) {
                        AddTransactionScreen(onAddTransaction = { amount, description ->
                            lifecycleScope.launch {
                                transactionViewModel.insertTransaction(
                                    Transaction(
                                        amount = amount,
                                        description = description
                                    )
                                )
                            }
                            showAddTransactionScreen = false
                        })
                    } else {
                        TransactionListScreen(
                            transactions = transactions,
                            onDeleteAllTransactions = {
                                lifecycleScope.launch {
                                    transactionViewModel.deleteAllTransactions()
                                }
                            },
                            onNavigateToAddTransaction = {
                                showAddTransactionScreen = true
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}