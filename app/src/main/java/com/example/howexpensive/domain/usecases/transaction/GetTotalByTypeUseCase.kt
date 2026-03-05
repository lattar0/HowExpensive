package com.example.howexpensive.domain.usecases.transaction

import com.example.howexpensive.data.model.TransactionType
import com.example.howexpensive.data.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class GetTotalByTypeUseCase(
    private val repository: TransactionRepository
) {
    operator fun invoke(type: TransactionType): Flow<Double> {
        return repository.getTotalByType(type)
    }
}