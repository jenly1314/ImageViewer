package com.king.image.imageviewer.loader

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import com.king.image.imageviewer.ImageDataSource
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import java.io.File

/**
 * 当使用[PicassoImageLoader]时，必须依赖[Picasso](https://github.com/square/picasso)库
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class PicassoImageLoader : ImageLoader {

    override fun loadImage(
        imageView: ImageView,
        model: Any?,
        placeholderDrawable: Drawable?,
        errorDrawable: Drawable?,
    ) {
        val requestCreator = getRequestCreate(model)
        if (placeholderDrawable != null) {
            requestCreator?.placeholder(placeholderDrawable)
        }
        if (errorDrawable != null) {
            requestCreator?.error(errorDrawable)
        }
        requestCreator?.into(imageView)
    }

    /**
     * 获取 [RequestCreator]
     */
    private fun getRequestCreate(model: Any?): RequestCreator? {
        return when (model) {
            is ImageDataSource -> getRequestCreate(model.getDataSource())
            is String -> Picasso.get().load(model)
            is Uri -> Picasso.get().load(model)
            is Int -> Picasso.get().load(model)
            is File -> Picasso.get().load(model)
            else -> {
                Log.w("PicassoImageLoader", "Illegal value type ${model?.javaClass?.canonicalName}")
                null
            }
        }
    }
}
