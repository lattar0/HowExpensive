package com.example.howexpensive.data.local.database

import androidx.room.TypeConverter
import com.example.howexpensive.data.model.TransactionType

class Converters {

    @TypeConverter
    fun fromTransactionType(type: TransactionType): String {
        return type.name
    }

    @TypeConverter
    fun toTransactionType(value: String): TransactionType {
        return TransactionType.valueOf(value)
    }
}