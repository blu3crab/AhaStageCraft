package com.adaptivehandyapps.ahastagecraft.gallery

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adaptivehandyapps.ahastagecraft.database.StageDatabaseDao
//import com.adaptivehandyapps.ahastagecraft.database.StageKit
//import kotlinx.coroutines.*


///////////////////////////////////////////////////////////////////////////////
//class GalleryViewModel : ViewModel() {
class GalleryViewModel(
        val database: StageDatabaseDao,
        application: Application) : AndroidViewModel(application) {
    ///////////////////////////////////////////////////////////////////////////////
    // data members
    private val TAG = "GalleryViewModel"

    // image label
    var _imageLabel = MutableLiveData<String>().apply {
        value =  "...dummy label..."
    }
//        set(value) {_imageLabel = value}

    val imageLabel: LiveData<String>
        get() = _imageLabel

    // imageUri returned from Photos intent selection
    // var imageUri: Uri? = null
    var _imageUri = MutableLiveData<Uri>(null)
        set(value) {_imageUri = value}

    val imageUri: LiveData<Uri>
        get() = _imageUri

//    // DB init
//    private var viewModelJob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
//
//    private var stageKitList = database.getAll()
//
//    private var stageKit = MutableLiveData<StageKit>()
//    init {
//        initializeStageKit()
//    }
//    private var stageKit : StageKit = initializeStageKit()
    ///////////////////////////////////////////////////////////////////////////////
    // fun
//    fun logAll() {
//        stageKitList = database.getAll()
//        stageKitList?.let {
//            Log.d(TAG, "stageKitList -> " + stageKitList.value)
//        }
//        if (stageKitList == null) {
//            Log.d(TAG, "stageKitList NULL ")
//        }
//    }
//
//    fun updateAndInsert() {
//        Log.d(TAG, "updateAndInsert...")
//        uiScope.launch {
//            var newStageKit = StageKit()
//            //val uri = myUriString.toUri()
//            //val myUri = Uri.parse("http://stackoverflow.com")
//            //Use toString() to convert a Uri to a String. Use Uri.parse() to convert a String to a Uri
//            newStageKit.imageUriString = _imageUri.value.toString()
//            Log.d(TAG, "\nnewStageKit.imageUriString " + newStageKit.imageUriString)
//            insert(newStageKit)
//            //var testStageKit = getNewestFromDatabase()
//        }
//    }
//
//    private fun initializeStageKit() {
//        uiScope.launch { stageKit.value = getNewestFromDatabase() }
//    }
//
//    private suspend fun getNewestFromDatabase(): StageKit? {
//        return withContext(Dispatchers.IO) {
//            var stageKit = database.getNewest()
//            stageKit
//        }
//    }
//
//    private suspend fun insert(stageKit: StageKit) {
//        withContext(Dispatchers.IO) {
//            database.insert(stageKit)
//        }
//    }
}