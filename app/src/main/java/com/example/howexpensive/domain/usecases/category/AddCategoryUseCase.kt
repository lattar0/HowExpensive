package com.example.howexpensive.domain.usecases.category

import com.example.howexpensive.data.local.entity.CategoryEntity
import com.example.howexpensive.data.repository.CategoryRepository

class AddCategoryUseCase(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(category: CategoryEntity): Long {
        return repository.upsertCategory(category)
    }
}