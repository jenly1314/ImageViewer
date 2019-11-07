package com.king.image.imageviewer.loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.king.image.imageviewer.ImageViewer;

import androidx.annotation.Nullable;

/**
 * 当使用{@link GlideImageLoader}时，必须依赖{@link Glide}库。
 * 为了保证{@link ImageViewer}体积最小化，和用户更多可能的选择性，并未将{@link Glide}打包进aar。
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class GlideImageLoader implements ImageLoader {
    @Override
    public void loadImage(Context context, ImageView imageView,Object data, @Nullable Drawable placeholderDrawable,@Nullable Drawable errorDrawable) {
        Glide.with(context).load(data).placeholder(placeholderDrawable).error(errorDrawable).into(imageView);
    }
}
