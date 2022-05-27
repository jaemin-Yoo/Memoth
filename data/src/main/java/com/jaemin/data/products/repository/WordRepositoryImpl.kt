package com.jaemin.data.products.repository

import com.jaemin.data.products.datasource.WordDao
import com.jaemin.domain.products.entity.Word
import com.jaemin.domain.products.repository.WordRepository
import kotlinx.coroutines.flow.Flow

class WordRepositoryImpl(
    private val dao: WordDao
) : WordRepository {
    override fun getWords(): Flow<List<Word>> {
        return dao.getWords()
    }

    override suspend fun getWordById(id: Int): Word? {
        return dao.getWordById(id)
    }

    override suspend fun insertWord(word: Word) {
        dao.insertWord(word)
    }

    override suspend fun deleteWord(word: Word) {
        dao.deleteWord(word)
    }
}