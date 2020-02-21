package com.adaptivehandyapps.ahastagecraft.gallery

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adaptivehandyapps.ahastagecraft.database.StageDatabaseDao

//class GalleryViewModel : ViewModel() {
class GalleryViewModel(
        val database: StageDatabaseDao,
        application: Application) : AndroidViewModel(application) {

    // image label
    private val _imageLabel = MutableLiveData<String>().apply {
        value = "Cunningham Falls"
    }
    val text: LiveData<String> = _imageLabel

    // imageUri returned from Photos intent selection
    // var imageUri: Uri? = null
    var _imageUri = MutableLiveData<Uri>(null)
        set(value) {_imageUri = value}

    val imageUri: LiveData<Uri>
        get() = _imageUri

}