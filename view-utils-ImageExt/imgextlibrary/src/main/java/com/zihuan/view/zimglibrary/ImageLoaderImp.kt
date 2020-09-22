package com.zihuan.view.zimglibrary

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.net.URL

class ImageLoaderImp(private val context: Context) : ImageLoader {

    override fun displayImage(path: String, imageView: ImageView) {
        Glide.with(context)
            .applyDefaultRequestOptions(ImageConfig.mPlaceOptions!!).apply {
                if (path.startsWith("https") || path.startsWith("http")) {
                    load(LoadImageUrl(URL(path)))
                } else {
                    load(path)
                }.into(imageView)
            }
    }

    override fun displayImageBackground(path: String, imageView: ImageView) {
        Glide.with(ImageConfig.getContext())
            .applyDefaultRequestOptions(ImageConfig.mPlaceBackGroundOptions!!).apply {
                if (path.startsWith("https") || path.startsWith("http")) {
                    load(LoadImageUrl(URL(path)))
                } else {
                    load(path)
                }.into(imageView)
            }
    }

    override fun displayImage(resId: Int, imageView: ImageView) {
        imageView.setImageResource(resId)
    }
}