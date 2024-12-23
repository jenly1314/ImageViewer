package com.king.image.imageviewer.loader

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.king.image.imageviewer.ImageDataSource

/**
 * 当使用[GlideImageLoader]时，必须依赖[Glide](https://github.com/bumptech/glide)库
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class GlideImageLoader : ImageLoader {

    override fun loadImage(
        imageView: ImageView,
        model: Any?,
        placeholderDrawable: Drawable?,
        errorDrawable: Drawable?,
    ) {
        if (model is ImageDataSource) {
            loadImage(imageView, model.getDataSource(), placeholderDrawable, errorDrawable)
        } else {
            Glide.with(imageView)
                .load(model)
                .placeholder(placeholderDrawable)
                .error(errorDrawable)
                .into(imageView)
        }
    }
}
