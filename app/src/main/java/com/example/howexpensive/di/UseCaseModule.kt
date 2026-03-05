package com.example.howexpensive.di

import com.example.howexpensive.data.repository.CategoryRepository
import com.example.howexpensive.data.repository.TransactionRepository
import com.example.howexpensive.domain.usecases.category.AddCategoryUseCase
import com.example.howexpensive.domain.usecases.transaction.AddTransactionUseCase
import com.example.howexpensive.domain.usecases.category.DeleteCategoryUseCase
import com.example.howexpensive.domain.usecases.transaction.DeleteTransactionUseCase
import com.example.howexpensive.domain.usecases.transaction.GetBalanceUseCase
import com.example.howexpensive.domain.usecases.category.GetCategoriesUseCase
import com.example.howexpensive.domain.usecases.category.GetCategoryByIdUseCase
import com.example.howexpensive.domain.usecases.transaction.GetTotalByTypeUseCase
import com.example.howexpensive.domain.usecases.transaction.GetTransactionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    // ---------- Transactions ----------
    @Provides
    fun provideGetTransactionsUseCase(repo: TransactionRepository): GetTransactionsUseCase =
        GetTransactionsUseCase(repo)

    @Provides
    fun provideAddTransactionUseCase(repo: TransactionRepository): AddTransactionUseCase =
        AddTransactionUseCase(repo)

    @Provides
    fun provideDeleteTransactionUseCase(repo: TransactionRepository): DeleteTransactionUseCase =
        DeleteTransactionUseCase(repo)

    @Provides
    fun provideGetBalanceUseCase(repo: TransactionRepository): GetBalanceUseCase =
        GetBalanceUseCase(repo)

    @Provides
    fun provideGetTotalByTypeUseCase(repo: TransactionRepository): GetTotalByTypeUseCase =
        GetTotalByTypeUseCase(repo)

    @Provides
    fun provideGetCategoriesUseCase(repo: CategoryRepository): GetCategoriesUseCase =
        GetCategoriesUseCase(repo)

    @Provides
    fun provideGetCategoryByIdUseCase(repo: CategoryRepository): GetCategoryByIdUseCase =
        GetCategoryByIdUseCase(repo)

    @Provides
    fun provideAddCategoryUseCase(repo: CategoryRepository): AddCategoryUseCase =
        AddCategoryUseCase(repo)

    @Provides
    fun provideDeleteCategoryUseCase(repo: CategoryRepository): DeleteCategoryUseCase =
        DeleteCategoryUseCase(repo)
}