package com.king.image.imageviewer;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;

import com.king.image.imageviewer.loader.ImageLoader;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@SuppressWarnings("unused")
enum ViewerSpec {

    INSTANCE;

    int position;

    List<?> listData;

    @Nullable
    ImageLoader imageLoader;

    boolean isShowIndicator;

    @Nullable Drawable placeholderDrawable;

    @Nullable
    Drawable errorDrawable;

    @StyleRes
    int theme = R.style.ImageViewerTheme;

    int orientation = ActivityInfo.SCREEN_ORIENTATION_BEHIND;

    public int getPosition() {
        return position;
    }

    public List<?> getListData() {
        return listData;
    }

    public boolean isShowIndicator() {
        return isShowIndicator;
    }

    public int getTheme() {
        return theme;
    }

    public int getOrientation() {
        return orientation;
    }

    void reset(){
        position = 0;
        listData = null;
        isShowIndicator = false;
        placeholderDrawable = null;
        errorDrawable = null;
        theme = R.style.ImageViewerTheme;
        orientation = ActivityInfo.SCREEN_ORIENTATION_BEHIND;
    }

}
