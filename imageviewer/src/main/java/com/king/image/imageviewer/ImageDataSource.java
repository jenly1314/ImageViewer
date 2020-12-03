package com.king.image.imageviewer;

import android.net.Uri;

import java.io.File;

import androidx.annotation.DrawableRes;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public interface ImageDataSource {

    /**
     * 返回图片数据源
     * @return {@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}
     */
    Object getDataSource();
}
