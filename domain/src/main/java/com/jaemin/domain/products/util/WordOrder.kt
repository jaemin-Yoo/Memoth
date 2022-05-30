package com.jaemin.domain.products.util

sealed class WordOrder(val orderType: OrderType){
    class Title(orderType: OrderType): WordOrder(orderType)
    class Date(orderType: OrderType): WordOrder(orderType)
    class Priority(orderType: OrderType): WordOrder(orderType)
}
