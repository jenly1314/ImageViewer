package com.king.image.imageviewer

import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import com.king.image.imageviewer.loader.ImageLoader

/**
 * 浏览图片时的一些配置
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
object ImageViewerSpec {

    var position: Int = 0
        internal set

    var listData: List<*> = emptyList<Any>()
        internal set

    internal var globalDefaultImageLoader: ImageLoader? = null

    internal var imageLoader: ImageLoader? = null

    var showIndicator: Boolean = false
        internal set

    var placeholderDrawable: Drawable? = null
        internal set

    var errorDrawable: Drawable? = null
        internal set

    var theme: Int = R.style.ImageViewerTheme
        internal set

    var orientation: Int = ActivityInfo.SCREEN_ORIENTATION_BEHIND
        internal set

    /**
     * 获取[ImageLoader]；优先返回[imageLoader]；如果[imageLoader]为空则返回[globalDefaultImageLoader]
     *
     * 设置[imageLoader]可通过调用[ImageViewer.imageLoader]函数来配置
     *
     * 设置全局默认的[globalDefaultImageLoader]可通过调用[ImageViewer.setGlobalDefaultImageLoader]函数来配置
     *
     */
    @JvmStatic
    fun imageLoader(): ImageLoader? {
        return imageLoader ?: globalDefaultImageLoader
    }

    /**
     * 重置配置；此函数会重置除[globalDefaultImageLoader]外的所有配置
     */
    internal fun reset() {
        position = 0
        listData = emptyList<Any>()
        showIndicator = false
        imageLoader = null
        placeholderDrawable = null
        errorDrawable = null
        theme = R.style.ImageViewerTheme
        orientation = ActivityInfo.SCREEN_ORIENTATION_BEHIND
    }
}
