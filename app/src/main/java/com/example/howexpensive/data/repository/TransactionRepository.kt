package com.example.howexpensive.data.repository

import com.example.howexpensive.data.local.dao.TransactionDao
import com.example.howexpensive.data.local.entity.TransactionEntity
import com.example.howexpensive.data.model.TransactionType
import kotlinx.coroutines.flow.Flow

class TransactionRepository(
    private val dao: TransactionDao
) {

    fun getAllTransactions(): Flow<List<TransactionEntity>> {
        return dao.getAll()
    }

    fun getTransactionsByType(type: TransactionType): Flow<List<TransactionEntity>> {
        return dao.getByType(type)
    }

    fun getTransactionsByCategory(categoryId: Long): Flow<List<TransactionEntity>> {
        return dao.getByCategory(categoryId)
    }

    fun getTransactionById(id: Long): Flow<TransactionEntity?> {
        return dao.getById(id)
    }

    suspend fun upsertTransaction(transaction: TransactionEntity): Long {
        return dao.upsert(transaction)
    }

    suspend fun upsertTransactions(transactions: List<TransactionEntity>): List<Long> {
        return dao.upsertAll(transactions)
    }

    suspend fun deleteTransaction(transaction: TransactionEntity) {
        dao.delete(transaction)
    }

    suspend fun deleteTransactionById(id: Long) {
        dao.deleteById(id)
    }

    fun getTotalByType(type: TransactionType): Flow<Double> {
        return dao.getTotalByType(type)
    }

    fun getBalance(): Flow<Double> {
        return dao.getBalance()
    }
}