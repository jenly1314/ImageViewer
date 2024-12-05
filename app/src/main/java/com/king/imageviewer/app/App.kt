package com.king.imageviewer.app

import android.app.Application
import com.king.image.imageviewer.ImageViewer
import com.king.image.imageviewer.loader.GlideImageLoader

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // 设置全局默认的图片加载器
        ImageViewer.setGlobalDefaultImageLoader(GlideImageLoader())
    }
}
