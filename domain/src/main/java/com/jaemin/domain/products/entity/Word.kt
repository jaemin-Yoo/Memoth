package com.jaemin.domain.products.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    val title: String,
    val content: String,
    val timestamp: Long,
    val priority: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)