package com.king.image.imageviewer.loader

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.king.image.imageviewer.ImageDataSource
import java.io.File

/**
 * 图片加载器，目前内置实现的加载器有[GlideImageLoader]和 [PicassoImageLoader]。
 * 如果目前已有的加载器不满足您的需求，您也可以自己实现一个[ImageLoader]
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
interface ImageLoader {
    /**
     * 加载图片
     *
     * @param imageView           [ImageView]
     * @param model                图片数据源；支持[Uri]、 `url`、 `filePath`、[File]、 [DrawableRes]、[ImageDataSource]等类型
     * @param placeholderDrawable 加载时显示的占位图片
     * @param errorDrawable       加载失败时显示的图片
     */
    fun loadImage(
        imageView: ImageView,
        model: Any?,
        placeholderDrawable: Drawable? = null,
        errorDrawable: Drawable? = null,
    )
}
