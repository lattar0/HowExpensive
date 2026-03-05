package com.example.howexpensive.data.repository

import com.example.howexpensive.data.local.dao.CategoryDao
import com.example.howexpensive.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

class CategoryRepository(
    private val dao: CategoryDao
) {

    fun getAllCategories(): Flow<List<CategoryEntity>> {
        return dao.getAll()
    }

    fun getCategoryById(id: Long): Flow<CategoryEntity?> {
        return dao.getById(id)
    }

    suspend fun upsertCategory(category: CategoryEntity): Long {
        return dao.upsert(category)
    }

    suspend fun upsertCategories(categories: List<CategoryEntity>): List<Long> {
        return dao.upsertAll(categories)
    }

    suspend fun deleteCategory(category: CategoryEntity) {
        dao.delete(category)
    }

    suspend fun deleteCategoryById(id: Long) {
        dao.deleteById(id)
    }
}