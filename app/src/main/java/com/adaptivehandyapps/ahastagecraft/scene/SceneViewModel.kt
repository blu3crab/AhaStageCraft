//
// Created by MAT on 2/10/2020.
//
package com.adaptivehandyapps.ahastagecraft.scene

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SceneViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "SCENE Fragment!"
    }
    val text: LiveData<String> = _text
}