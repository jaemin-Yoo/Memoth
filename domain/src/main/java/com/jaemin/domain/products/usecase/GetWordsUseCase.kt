package com.jaemin.domain.products.usecase

import com.jaemin.domain.products.entity.Word
import com.jaemin.domain.products.repository.WordRepository
import com.jaemin.domain.products.util.OrderType
import com.jaemin.domain.products.util.WordOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetWordsUseCase (
    private val repository: WordRepository
) {
    operator fun invoke(
        wordOrder: WordOrder = WordOrder.Date(OrderType.Descending)
    ): Flow<List<Word>> {
        return repository.getWords().map { words ->
            when(wordOrder.orderType){
                is OrderType.Ascending ->{
                    when(wordOrder){
                        is WordOrder.Title -> words.sortedBy { it.title.lowercase() }
                        is WordOrder.Date -> words.sortedBy { it.timestamp }
                        is WordOrder.Priority -> words.sortedBy { it.priority }
                    }
                }

                is OrderType.Descending -> {
                    when(wordOrder){
                        is WordOrder.Title -> words.sortedByDescending { it.title.lowercase() }
                        is WordOrder.Date -> words.sortedByDescending { it.timestamp }
                        is WordOrder.Priority -> words.sortedByDescending { it.priority }
                    }
                }
            }
        }
    }
}