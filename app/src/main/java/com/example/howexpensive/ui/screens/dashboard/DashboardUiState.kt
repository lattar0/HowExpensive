package com.example.howexpensive.ui.screens.dashboard

import com.example.howexpensive.data.local.entity.TransactionEntity

data class DashboardUiState(
    val isLoading: Boolean = true,
    val balance: Double = 0.0,
    val transactions: List<TransactionEntity> = emptyList(),
    val error: String? = null
)