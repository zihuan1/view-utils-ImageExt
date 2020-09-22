package com.zihuan.view.zimglibrary

import android.widget.ImageView
import androidx.annotation.DrawableRes

/**配置加载器**/
interface ImageLoader {
    /**实现加载方法**/
    fun displayImage(path: String, imageView: ImageView)

    fun displayImageBackground(path: String, imageView: ImageView)

    fun displayImage(@DrawableRes resId: Int, imageView: ImageView)
}