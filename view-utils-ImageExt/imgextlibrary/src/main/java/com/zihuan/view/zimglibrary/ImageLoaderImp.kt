package com.zihuan.view.zimglibrary

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.net.URL

class ImageLoaderImp(private val context: Context) : ImageLoader {

    override fun displayImage(path: String, imageView: ImageView) {
        Glide.with(context)
            .applyDefaultRequestOptions(ImageConfig.mPlaceOptions!!)
            .load(LoadImageUrl(URL(path)))
            .into(imageView)
    }

    override fun displayImageBackground(path: String, imageView: ImageView) {
        Glide.with(ImageConfig.getContext())
            .applyDefaultRequestOptions(ImageConfig.mPlaceBackGroundOptions!!)
            .load(LoadImageUrl(URL(path)))
            .into(imageView)
    }

    override fun displayImage(resId: Int, imageView: ImageView) {
        imageView.setImageResource(resId)
    }
}