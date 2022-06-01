package com.jaemin.presentation.base.words

import com.jaemin.domain.products.entity.Word
import com.jaemin.domain.products.util.OrderType
import com.jaemin.domain.products.util.WordOrder

data class WordsState(
    val words: List<Word> = emptyList(),
    val wordOrder: WordOrder = WordOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)