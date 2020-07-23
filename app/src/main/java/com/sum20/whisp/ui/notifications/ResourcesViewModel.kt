package com.sum20.whisp.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResourcesViewModel : ViewModel() {

    //TODO CARDVIEWS AND SCROLLING VIEWS
    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}