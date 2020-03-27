package com.cypherx.coronavirus.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "COVID - 19 world-wide"
    }

    val text: LiveData<String> = _text
}