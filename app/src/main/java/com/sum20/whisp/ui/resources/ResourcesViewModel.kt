package com.sum20.whisp.ui.resources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResourcesViewModel : ViewModel() {

    //TODO CARDVIEWS AND SCROLLING VIEWS
    private val _text = MutableLiveData<String>().apply {
        value = "Everyone asks where's walkdo, but no one asks how's waldo *cries*"
    }
    val text: LiveData<String> = _text
}