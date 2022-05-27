package com.jaemin.data.products.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jaemin.domain.products.entity.Word

@Database(
    entities = [Word::class],
    version = 1
)
abstract class WordDatabase: RoomDatabase() {

    abstract val wordDao: WordDao
}