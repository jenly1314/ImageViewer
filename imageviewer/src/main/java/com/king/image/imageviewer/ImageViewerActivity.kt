package com.king.image.imageviewer

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback

/**
 * 浏览图片时的界面
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
open class ImageViewerActivity : AppCompatActivity() {

    private var tvIndicator: TextView? = null

    private lateinit var mAdapter: ImageViewerAdapter

    private var mSize = 0

    private var isShowIndicator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ImageViewerSpec.orientation
        setTheme(ImageViewerSpec.theme)
        setContentView(getLayoutId())
        init()
    }

    /**
     * 获取布局
     *
     * @return 返回布局ID
     */
    @LayoutRes
    protected open fun getLayoutId(): Int {
        return R.layout.image_viewer_activity
    }

    /**
     * 初始化
     */
    protected open fun init() {
        tvIndicator = findViewById(R.id.tvIndicator)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        viewPager.registerOnPageChangeCallback(
            object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (isShowIndicator) {
                        updateIndicator(position, mSize)
                    }
                }
            },
        )

        ViewCompat.setTransitionName(viewPager, ImageViewer.SHARED_ELEMENT)

        mAdapter = ImageViewerAdapter(ImageViewerSpec.listData)
        viewPager.adapter = mAdapter

        mAdapter.setOnItemClickListener { _, _ ->
            finishAfterTransition()
        }

        val position = ImageViewerSpec.position
        mSize = mAdapter.itemCount
        if (position >= 0 && mSize > 0) {
            viewPager.setCurrentItem(position, false)
            updateIndicator(position, mSize)
        }

        isShowIndicator = ImageViewerSpec.showIndicator && mSize > 0
        if (isShowIndicator) {
            tvIndicator?.visibility = View.VISIBLE
        }
    }

    /**
     * 更新指示器
     *
     * @param position
     * @param size
     */
    private fun updateIndicator(position: Int, size: Int) {
        tvIndicator?.text = String.format("%s/%s", position.plus(1).coerceAtMost(size), size)
    }

}
