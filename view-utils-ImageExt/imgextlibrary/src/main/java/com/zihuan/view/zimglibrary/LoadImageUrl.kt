package com.zihuan.view.zimglibrary

import com.bumptech.glide.load.model.GlideUrl
import java.net.URL

class LoadImageUrl(url: URL) : GlideUrl(url) {
    private val imageUrl: String = url.toString()

    /**
     * 截取关键图片url
     * @return key
     */
    private val imageBaseUrl: String
        get() = if (imageUrl.contains("?")) {
            val urls = imageUrl.split("?").toTypedArray()
            urls[0]
        } else {
            imageUrl
        }

    override fun getCacheKey(): String {
        return imageBaseUrl
    }

}