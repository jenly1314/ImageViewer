package com.king.imageviewer.app

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.king.image.imageviewer.ImageViewer
import com.king.image.imageviewer.ImageViewerSpec
import com.king.image.imageviewer.loader.GlideImageLoader

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class PhotoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_activity)
        init()
    }

    private fun init() {
        val imageView = findViewById<ImageView>(R.id.imageView)
        ImageViewerSpec.imageLoader()?.loadImage(imageView, R.drawable.gif)
    }

    fun onClick(v: View?) {
        ImageViewer.load(R.drawable.gif)
//            .imageLoader(GlideImageLoader()) // 设置图片加载器；也可通过ImageViewer.setGlobalDefaultImageLoader(GlideImageLoader()) 设置全局默认的图片加载器
            .start(this, v)
    }
}
