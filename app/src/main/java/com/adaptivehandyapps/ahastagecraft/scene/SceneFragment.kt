//
// Created by MAT on 2/10/2020.
//
package com.adaptivehandyapps.ahastagecraft.scene

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.adaptivehandyapps.ahastagecraft.R


class SceneFragment : Fragment() {

    private lateinit var sceneViewModel: SceneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sceneViewModel =
            ViewModelProviders.of(this).get(SceneViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_scene, container, false)
        val imageView: ImageView = root.findViewById(R.id.image_scene)
        imageView.visibility = View.VISIBLE

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
//        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));

//        val uri = "@drawable/ic_launcher" //
//        val imageResource = resources.getIdentifier(uri, null, VerifyAccess.getPackageName())
//
//        imageview = findViewById(R.id.imageView) as ImageView
//        val res = resources.getDrawable(imageResource)
        //imageView.setImageResource()
//        sceneViewModel.text.observe(viewLifecycleOwner, Observer {
//            imageView.setImageResource() = it
//        })
        return root
    }
}