package com.king.image.imageviewer;

import android.graphics.drawable.Drawable;

import com.king.image.imageviewer.loader.ImageLoader;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
enum ViewerSpec {

    INSTANCE;

    volatile int position;

    List<?> listData;

    @Nullable
    ImageLoader imageLoader;

    boolean isShowIndicator;

    @Nullable Drawable placeholderDrawable;

    @Nullable
    Drawable errorDrawable;

    void reset(){
        position = 0;
        listData = null;
        imageLoader = null;
        isShowIndicator = false;
        placeholderDrawable = null;
        errorDrawable = null;
    }

}
