package com.adaptivehandyapps.ahastagecraft.gallery

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    //var imageUri: Uri? = null
    var _imageUri = MutableLiveData<Uri>(null)
        set(value) {_imageUri = value}

    val imageUri: LiveData<Uri>
        get() = _imageUri

}