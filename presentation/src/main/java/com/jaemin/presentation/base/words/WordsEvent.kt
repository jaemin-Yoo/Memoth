package com.jaemin.presentation.base.words

import com.jaemin.domain.products.entity.Word
import com.jaemin.domain.products.util.WordOrder

sealed class WordsEvent {
    data class Order(val wordOrder: WordOrder): WordsEvent()
    data class DeleteWord(val word: Word): WordsEvent()
    object RestoreWord: WordsEvent()
    object ToggleOrderSection: WordsEvent()
}
