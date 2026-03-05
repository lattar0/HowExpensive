package com.example.howexpensive.ui.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.howexpensive.data.local.entity.TransactionEntity
import com.example.howexpensive.data.model.TransactionType
import com.example.howexpensive.domain.usecases.transaction.AddTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val addTransactionUseCase: AddTransactionUseCase
) : ViewModel() {

    fun addTransaction(
        description: String,
        amount: Double,
        type: TransactionType,
        categoryId: Long?
    ) {
        if (description.isBlank()) return
        if (amount <= 0) return

        viewModelScope.launch {
            val entity = TransactionEntity(
                description = description,
                amount = amount,
                type = type,
                categoryId = categoryId
            )

            addTransactionUseCase(entity)
        }
    }
}