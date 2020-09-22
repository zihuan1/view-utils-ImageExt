package com.zihuan.view.zimglibrary

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

val loaderImp = ImageConfig.ImageLoader
/**默认的加载图片扩展**/
inline fun ImageView.loader(url: String) {
    loaderImp?.displayImage(url, this)
}

inline fun ImageView.loaderBackGround(url: String) {
    loaderImp?.displayImageBackground(url, this)
}

/**添加本地资源图片**/
inline fun ImageView.loader(@DrawableRes res: Int) {
    loaderImp?.displayImage(res, this)
}

/**
 * 获取视频缩略图
 * @param frame 截取第几秒的帧 由于是微妙所以乘以1000000,不传的话会返回有代表性的一帧,详情见frame注释
 */
inline fun ImageView.loaderImageForVideo(path: String, frame: Int = 0) {
    Glide.with(ImageConfig.getContext())
        .setDefaultRequestOptions(
            ImageConfig.mPlaceBackGroundOptions!!
                .frame(frame.times(1000000).toLong())
                .centerCrop()
                .placeholder(ImageConfig.defPlaceholderBackGround)
                .error(ImageConfig.defErrImgBackGround)
        )
        .load(path)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}

/** 圆角图片**/
//inline fun ImageView.loaderCircle(url: String, cornerType: RoundedCornersTransformation.CornerType) {
//    Glide.with(ZImageConfig.getContext())
//        .load(url)
//        .bitmapTransform(
//            CenterCrop(ZImageConfig.getContext()),//解决圆角与centercrop冲突
//            RoundedCornersTransformation(ZImageConfig.getContext(), 4, 0, cornerType)
//        )
//        .crossFade()
//        .diskCacheStrategy(DiskCacheStrategy.SOURCE)//缓存策略
//        .into(this)
//}