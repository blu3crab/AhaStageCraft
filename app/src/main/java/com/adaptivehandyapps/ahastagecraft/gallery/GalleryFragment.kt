package com.adaptivehandyapps.ahastagecraft.gallery

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.adaptivehandyapps.ahastagecraft.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GalleryFragment : Fragment() {
    private val TAG = "GalleryFragment"

    private lateinit var galleryViewModel: GalleryViewModel

    // TODO: consolidate image access
    var IMAGE_PICK_CODE = 1000

    private var _imageUri = MutableLiveData<Uri>(null)
    //var imageUri: Uri? = null
    val imageUri: LiveData<Uri>
        get() = _imageUri


    lateinit var imageView: ImageView
    //val myLazyString: String by lazy { "Hello" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
//        ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

//        val textView: TextView = root.findViewById(R.id.text_gallery)
//        galleryViewModel.text.observe(this, Observer {
//            textView.text = it
//        })

        // lateinit imageView
        imageView = root.findViewById(R.id.image_gallery)
        // launch Gallery intent to select photo
        pickImageFromGallery()

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
                    _imageUri.setValue(resultUri)
                    Log.d(TAG, "\nimageUri " + imageUri.value)

                    // display selection
                    Glide.with(this)
                        .load(_imageUri.value)
                        .apply(
                            RequestOptions()
//                            .override(2048)   // XML android:adjustViewBounds="true" provides override
                                .placeholder(R.drawable.loading_img)
                                .error(R.drawable.ic_broken_image)
                        )
                        .into(imageView)
                }
            }
        }
    }

}