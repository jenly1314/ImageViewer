package com.king.image.imageviewer.loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.king.image.imageviewer.ImageDataSource;

import java.io.File;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;


/**
 * 图片加载器，目前内置实现的加载器有{@link GlideImageLoader} 和 {@link PicassoImageLoader}。
 * 如果目前已有的加载器不满足您的需求，您也可以自己实现{@link ImageLoader}
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public interface ImageLoader {

    /**
     * 加载图片
     * @param context
     * @param imageView
     * @param data 图片数据源  支持 {@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}, {@link ImageDataSource}...等
     * @param placeholderDrawable 占位图
     * @param errorDrawable  加载失败时显示的图片
     */
    void loadImage(Context context, ImageView imageView,Object data, @Nullable Drawable placeholderDrawable,@Nullable Drawable errorDrawable);
}
