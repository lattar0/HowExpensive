package com.example.howexpensive.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.howexpensive.data.local.dao.CategoryDao
import com.example.howexpensive.data.local.dao.TransactionDao
import com.example.howexpensive.data.local.entity.CategoryEntity
import com.example.howexpensive.data.local.entity.TransactionEntity

@Database(
    entities = [
        TransactionEntity::class,
        CategoryEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        const val DATABASE_NAME = "finance_db"
    }
}