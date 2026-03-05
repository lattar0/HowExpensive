package com.example.howexpensive.di

import com.example.howexpensive.data.local.dao.CategoryDao
import com.example.howexpensive.data.local.dao.TransactionDao
import com.example.howexpensive.data.repository.CategoryRepository
import com.example.howexpensive.data.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTransactionRepository(
        dao: TransactionDao
    ): TransactionRepository = TransactionRepository(dao)

    @Provides
    @Singleton
    fun provideCategoryRepository(
        dao: CategoryDao
    ): CategoryRepository = CategoryRepository(dao)
}