package com.adaptivehandyapps.ahastagecraft.gallery

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
//import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.adaptivehandyapps.ahastagecraft.R
import com.adaptivehandyapps.ahastagecraft.database.StageDatabase
//import com.adaptivehandyapps.ahastagecraft.databinding.FragmentGalleryBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GalleryFragment : Fragment() {
    private val TAG = "GalleryFragment"

    private lateinit var galleryViewModel: GalleryViewModel

    // TODO: consolidate image access
    var IMAGE_PICK_CODE = 1000

//    //var imageUri: Uri? = null
//    private var _imageUri = MutableLiveData<Uri>(null)
//        set(value) {_imageUri = value}
//
//    val imageUri: LiveData<Uri>
//        get() = _imageUri


    lateinit var imageView: ImageView
    //val myLazyString: String by lazy { "Hello" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
//        val binding: FragmentGalleryBinding = DataBindingUtil.inflate(
//            inflater, R.layout.fragment_gallery, container, false
//        )

        val application = requireNotNull(this.activity).application
        val datasource = StageDatabase.getInstance(application).stageDatabaseDao

        val viewModelFactory = GalleryViewModelFactory(datasource, application)
        // deprecated -> ViewModelProviders.of
        //galleryViewModel = ViewModelProviders.of(this, viewModelFactory).get(GalleryViewModel::class.java)
        galleryViewModel = ViewModelProvider(this, viewModelFactory).get(GalleryViewModel::class.java)
//        galleryViewModel.logAll()

//        galleryViewModel =
//            ViewModelProvider(this).get(GalleryViewModel::class.java)
//        Log.d(TAG,"stageCraft ViewModel " + galleryViewModel)
//
//        val textView: TextView = root.findViewById(R.id.text_gallery)
//        galleryViewModel.text.observe(this, Observer {
//            textView.text = it
//        })

        // lateinit imageView
//        imageView = binding.root.findViewById(R.id.image_gallery)
        imageView = root.findViewById(R.id.image_gallery)
        galleryViewModel._imageLabel.setValue("...scene label...")
        // launch Gallery intent to select photo
        pickImageFromGallery()

//        binding.setLifecycleOwner(this)
//        binding.galleryViewModel = galleryViewModel
//
//        return binding.root

        return root
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE) // GIVE AN INTEGER VALUE FOR IMAGE_PICK_CODE LIKE 1000
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            if (data?.data != null) {
                val resultUri = data?.data
                // if imageUri is defined
                resultUri?.let {
                    // retain selection
                    galleryViewModel._imageUri.setValue(resultUri)
                    Log.d(TAG, "\nimageUri " + galleryViewModel.imageUri.value)
//                    galleryViewModel.logAll()
//                    galleryViewModel.updateAndInsert()
//                    galleryViewModel.logAll()

//                    _imageUri.setValue(resultUri)
//                    Log.d(TAG, "\nimageUri " + imageUri.value)

                    // display selection
                    Glide.with(this)
                        .load(galleryViewModel._imageUri.value)
//                        .load(_imageUri.value)
                        .apply(
                            RequestOptions()
//                            .override(2048)   // XML android:adjustViewBounds="true" provides override
                                .placeholder(R.drawable.loading_img)
                                .error(R.drawable.ic_broken_image)
                        )
                        .into(imageView)
                }
                if (resultUri == null) {
                    Log.d(TAG, "\nimageUri NULL...")
                }
            }
        }
    }

}