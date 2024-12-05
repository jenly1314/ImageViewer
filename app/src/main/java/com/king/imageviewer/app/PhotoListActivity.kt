package com.king.imageviewer.app

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.king.image.imageviewer.ImageViewer
import com.king.imageviewer.app.adapter.PhotoAdapter

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class PhotoListActivity : AppCompatActivity() {

    private val listData: List<String> by lazy {
        List(16) {
            "https://jenly1314.github.io/medias/featureimages/${it.plus(1)}.jpg"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_list_activity)
        init()
    }

    private fun init() {
        val adapter = PhotoAdapter(listData)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(
            object : PhotoAdapter.OnItemClickListener {
                override fun onClick(v: View?, position: Int) {
                    ImageViewer.load(listData) // 要加载的图片数据，单张或多张
//                        .imageLoader(CoilImageLoader()) // 图片加载器，目前内置的有CoilImageLoader、GlideImageLoader和PicassoImageLoader，也可以自己实现
//                        .imageLoader(GlideImageLoader())
//                        .imageLoader(PicassoImageLoader())
                        .selection(position) // 选中位置
                        .showIndicator(true) // 是否显示指示器，默认不显示
//                        .placeholder(R.drawable.ic_image_placeholder) // 设置占位图
//                        .error(R.drawable.ic_image_error) // 设置加载失败时显示的图片
//                        .theme(R.style.ImageViewerTheme)// 设置主题风格，默认：R.style.ImageViewerTheme
                        .orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) // 设置屏幕方向,默认：ActivityInfo.SCREEN_ORIENTATION_BEHIND
                        .start(this@PhotoListActivity, v)
                }
            },
        )
    }
}
