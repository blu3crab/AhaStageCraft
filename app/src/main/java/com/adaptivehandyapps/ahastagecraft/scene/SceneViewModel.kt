//
// Created by MAT on 2/10/2020.
//
package com.adaptivehandyapps.ahastagecraft.scene

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SceneViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "SCENE Fragment!"
    }
    val text: LiveData<String> = _text

    //var imageUri: Uri? = null
    var _imageUri = MutableLiveData<Uri>(null)
        set(value) {_imageUri = value}

    val imageUri: LiveData<Uri>
        get() = _imageUri

}