package com.zihuan.view.zimglibrary

import android.content.Context
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object ImageConfig {
    var mContext: Context? = null

    fun getContext(): Context {
        return mContext!!
    }

    var ImageLoader: ImageLoader? = null
        get() {
            return field ?: ImageLoaderImp(getContext())
        }

    /**加载中显示的占位图**/
    var defPlaceholder = 0

    /**加载错误显示的占位图**/
    var defErrImg = 0

    /**加载背景图显示的占位图**/
    var defPlaceholderBackGround = 0

    /**加载背景图错误显示的占位图**/
    var defErrImgBackGround = 0

    fun setConfig(action: ImageConfig.() -> Unit) {
        action()
    }

    /**占位图配置参数**/
    var mPlaceOptions: RequestOptions? = null
        get() = field ?: RequestOptions()
            .centerCrop()
            .diskCacheStrategy(strategy)
            .placeholder(defPlaceholder)//加载中显示的图片
            .error(defErrImg)//加载失败时显示的图片

    var mPlaceBackGroundOptions: RequestOptions? = null
        get() = field ?: RequestOptions()
            .centerCrop()
            .diskCacheStrategy(strategy)
            .placeholder(defPlaceholderBackGround)//加载中显示的图片
            .error(defErrImgBackGround)//加载失败时显示的图片失败时显示的图片


    //缓存模式
    var strategy: DiskCacheStrategy = DiskCacheStrategy.RESOURCE

//缓存策略
//    DiskCacheStrategy.NONE	表示不缓存任何内容。
//    DiskCacheStrategy.DATA	表示只缓存原始图片。
//    DiskCacheStrategy.RESOURCE	表示只缓存转换过后的图片。
//    DiskCacheStrategy.ALL	表示既缓存原始图片，也缓存转换过后的图片。
//    DiskCacheStrategy.AUTOMATIC	表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）。

//        1图片加载优先级
//        Priority.LOW
//        Priority.NORMAL
//        Priority.HIGH
//        Priority.IMMEDIATE
}