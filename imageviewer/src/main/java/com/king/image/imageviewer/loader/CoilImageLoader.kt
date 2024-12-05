package com.king.image.imageviewer.loader

import android.graphics.drawable.Drawable
import android.widget.ImageView
import coil.load
import com.king.image.imageviewer.ImageDataSource

/**
 * 当使用[CoilImageLoader]时，必须依赖[COIL](https://github.com/coil-kt/coil)库
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class CoilImageLoader : ImageLoader {

    override fun loadImage(
        imageView: ImageView,
        model: Any?,
        placeholderDrawable: Drawable?,
        errorDrawable: Drawable?,
    ) {
        if (model is ImageDataSource) {
            loadImage(imageView, model.getDataSource(), placeholderDrawable, errorDrawable)
        } else {
            imageView.load(model) {
                placeholder(placeholderDrawable)
                error(errorDrawable)
            }
        }
    }

}
