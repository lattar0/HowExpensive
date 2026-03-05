package com.example.howexpensive.domain.usecases.category

import com.example.howexpensive.data.local.entity.CategoryEntity
import com.example.howexpensive.data.repository.CategoryRepository

class DeleteCategoryUseCase(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(category: CategoryEntity) {
        repository.deleteCategory(category)
    }
}