package com.jaemin.domain.products.repository

import com.jaemin.domain.products.entity.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {

    fun getWords(): Flow<List<Word>>

    suspend fun getWordById(id: Int): Word?

    suspend fun insertWord(word: Word)

    suspend fun deleteWord(word: Word)
}