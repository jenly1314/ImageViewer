package com.king.imageviewer.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.king.image.imageviewer.ImageViewer
import com.king.image.imageviewer.ImageViewerSpec
import com.king.image.imageviewer.loader.GlideImageLoader

/**
 * ImageViewer 示例
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun startActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.btn1 -> startActivity(PhotoActivity::class.java)
            R.id.btn2 -> startActivity(PhotoListActivity::class.java)
        }
    }
}
