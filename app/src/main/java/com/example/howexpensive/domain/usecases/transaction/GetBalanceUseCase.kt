package com.example.howexpensive.domain.usecases.transaction

import com.example.howexpensive.data.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class GetBalanceUseCase(
    private val repository: TransactionRepository
) {
    operator fun invoke(): Flow<Double> {
        return repository.getBalance()
    }
}