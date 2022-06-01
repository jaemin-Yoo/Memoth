package com.jaemin.presentation.base.viewmodel

import androidx.lifecycle.ViewModel
import com.jaemin.domain.products.usecase.WordUseCases
import com.jaemin.presentation.base.words.WordsEvent
import com.jaemin.presentation.base.words.WordsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor(
    private val wordUseCases: WordUseCases
) : ViewModel(){

    fun onEvent(event: WordsEvent) {
        when(event){
            is WordsEvent.Order -> {

            }
            is WordsEvent.DeleteWord -> {

            }
            is WordsEvent.RestoreWord -> {

            }
            is WordsEvent.ToggleOrderSection -> {

            }
        }
    }
}