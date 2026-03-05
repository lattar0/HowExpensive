package com.example.howexpensive.domain.usecases.transaction

import com.example.howexpensive.data.local.entity.TransactionEntity
import com.example.howexpensive.data.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class GetTransactionsUseCase(
    private val repository: TransactionRepository
) {
    operator fun invoke(): Flow<List<TransactionEntity>> {
        return repository.getAllTransactions()
    }
}