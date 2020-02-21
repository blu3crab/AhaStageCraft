//
// Created by MAT on 2/21/2020.
//
package com.adaptivehandyapps.ahastagecraft.gallery

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adaptivehandyapps.ahastagecraft.database.StageDatabaseDao
import java.lang.IllegalArgumentException

class GalleryViewModelFactory (
    val datasource: StageDatabaseDao,
    val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GalleryViewModel::class.java)) {
            return GalleryViewModel(datasource, application) as T
        }
        throw IllegalArgumentException("Ooops! unknown ViewModel class...")
    }
}
