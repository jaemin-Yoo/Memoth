package com.jaemin.domain.products.usecase

import com.jaemin.domain.products.entity.Word
import com.jaemin.domain.products.repository.WordRepository

class DeleteWordUseCase(
    private val repository: WordRepository
) {

    suspend operator fun invoke(word: Word){
        repository.deleteWord(word)
    }
}