package com.jaemin.domain.products.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}