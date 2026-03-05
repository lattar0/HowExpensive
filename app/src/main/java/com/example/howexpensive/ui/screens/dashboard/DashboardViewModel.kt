package com.example.howexpensive.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.howexpensive.data.local.entity.TransactionEntity
import com.example.howexpensive.domain.usecases.transaction.DeleteTransactionUseCase
import com.example.howexpensive.domain.usecases.transaction.GetBalanceUseCase
import com.example.howexpensive.domain.usecases.transaction.GetTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    getTransactionsUseCase: GetTransactionsUseCase,
    getBalanceUseCase: GetBalanceUseCase,
    private val deleteTransactionUseCase: DeleteTransactionUseCase
) : ViewModel() {

    private val _error = MutableStateFlow<String?>(null)

    val uiState: StateFlow<DashboardUiState> =
        combine(
            getBalanceUseCase(),
            getTransactionsUseCase(),
            _error
        ) { balance, transactions, error ->
            DashboardUiState(
                isLoading = false,
                balance = balance,
                transactions = transactions,
                error = error
            )
        }
            .catch { e ->
                _error.update { e.message ?: "Erro inesperado" }
                emit(DashboardUiState(isLoading = false, error = e.message))
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = DashboardUiState(isLoading = true)
            )

    fun deleteTransaction(transaction: TransactionEntity) {
        viewModelScope.launch {
            deleteTransactionUseCase(transaction)
        }
    }
}