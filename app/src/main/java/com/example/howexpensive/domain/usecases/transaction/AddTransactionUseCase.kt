package com.example.howexpensive.domain.usecases.transaction

import com.example.howexpensive.data.local.entity.TransactionEntity
import com.example.howexpensive.data.repository.TransactionRepository

class AddTransactionUseCase(
    private val repository: TransactionRepository
) {
    suspend operator fun invoke(transaction: TransactionEntity): Long {
        return repository.upsertTransaction(transaction)
    }
}