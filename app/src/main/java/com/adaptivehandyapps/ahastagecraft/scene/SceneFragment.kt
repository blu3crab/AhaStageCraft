//
// Created by MAT on 2/10/2020.
//
package com.adaptivehandyapps.ahastagecraft.scene

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
//import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.adaptivehandyapps.ahastagecraft.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class SceneFragment : Fragment() {
    private val TAG = "SceneFragment"

    private lateinit var sceneViewModel: SceneViewModel
    lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sceneViewModel =
            ViewModelProvider(this).get(SceneViewModel::class.java)
        Log.d(TAG,"stageCraft ViewModel " + sceneViewModel)

        val root = inflater.inflate(R.layout.fragment_scene, container, false)

        // lateinit imageView
        imageView = root.findViewById(R.id.image_scene)

        // display selected scene
        sceneViewModel.imageUri.value?.let {
            val imageUri = sceneViewModel.imageUri.value
            Log.d("SceneFragment","imageUri " + imageUri)
            Glide.with(this)
//                .load(R.drawable.kansas_view_to_south)
                .load(imageUri)
//                .load(stageCraftViewModel._imageUri.value)
                .apply(
                    RequestOptions()
                        .override(2048)
                        .placeholder(R.drawable.loading_img)
                        .error(R.drawable.ic_broken_image))
                .into(imageView)
        }

        return root
    }

//    private fun pickImageFromGallery() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, IMAGE_PICK_CODE) // GIVE AN INTEGER VALUE FOR IMAGE_PICK_CODE LIKE 1000
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
//            if (data?.data != null) {
//                imageUri = data?.data
//                Log.d("SceneFragment","imageUri " + imageUri.toString())
//                Glide.with(this)
//                    .load(imageUri)
//                    .apply(
//                        RequestOptions()
//                            .override(2048)
//                            .placeholder(R.drawable.loading_img)
//                            .error(R.drawable.ic_broken_image))
//                    .into(imageView)
//
//            }
//        }
//    }

}