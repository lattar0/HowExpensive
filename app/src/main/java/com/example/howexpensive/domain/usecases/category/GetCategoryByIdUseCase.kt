package com.example.howexpensive.domain.usecases.category

import com.example.howexpensive.data.local.entity.CategoryEntity
import com.example.howexpensive.data.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class GetCategoryByIdUseCase(
    private val repository: CategoryRepository
) {
    operator fun invoke(id: Long): Flow<CategoryEntity?> {
        return repository.getCategoryById(id)
    }
}