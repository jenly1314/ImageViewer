package com.king.image.imageviewer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.king.image.imageviewer.loader.ImageLoader
import java.io.File


/**
 * ImageViewer 是一个图片查看器。一般用来查看图片详情或查看大图时使用。
 * <p>
 * [ImageViewer.load]支持加载[Uri]、 `url`、 `filePath`、[File]、 [DrawableRes]、[ImageDataSource]等类型；
 * 对于加载多张图片数据也可以是支持类型对应的[List]或[Array]
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class ImageViewer private constructor(model: Any) {

    private var mOptionsCompat: ActivityOptionsCompat? = null

    private var imageViewerClass: Class<*>

    private var extrasBundle: Bundle? = null

    private var placeholderDrawableId = 0
    private var errorDrawableId = 0

    init {
        ImageViewerSpec.reset()
        when (model) {
            is List<*> -> ImageViewerSpec.listData = model
            is Array<*> -> ImageViewerSpec.listData = model.toList()
            else -> ImageViewerSpec.listData = listOf(model)
        }
        imageViewerClass = ImageViewerActivity::class.java
    }

    /**
     * 当前选中位置
     *
     * @param position 默认：0
     * @return
     */
    fun selection(position: Int): ImageViewer {
        ImageViewerSpec.position = position
        return this
    }

    /**
     * 设置占位图
     *
     * @param drawableResId
     * @return
     */
    fun placeholder(@DrawableRes drawableResId: Int): ImageViewer {
        this.placeholderDrawableId = drawableResId
        ImageViewerSpec.placeholderDrawable = null
        return this
    }

    /**
     * 设置占位图
     *
     * @param drawable
     * @return
     */
    fun placeholder(drawable: Drawable?): ImageViewer {
        ImageViewerSpec.placeholderDrawable = drawable
        this.placeholderDrawableId = 0
        return this
    }

    /**
     * 设置加载失败时显示的图片
     *
     * @param drawableResId
     * @return
     */
    fun error(@DrawableRes drawableResId: Int): ImageViewer {
        this.errorDrawableId = drawableResId
        ImageViewerSpec.errorDrawable = null
        return this
    }

    /**
     * 设置加载失败时显示的图片
     *
     * @param drawable
     * @return
     */
    fun error(drawable: Drawable?): ImageViewer {
        ImageViewerSpec.errorDrawable = drawable
        this.errorDrawableId = 0
        return this
    }

    /**
     * 设置图片加载器；如果有多处使用到[ImageViewer]，也可以使用[ImageViewer.setGlobalDefaultImageLoader]来
     * 设置全局默认的图片加载器；
     *
     * @param imageLoader
     * @return
     */
    fun imageLoader(imageLoader: ImageLoader): ImageViewer {
        ImageViewerSpec.imageLoader = imageLoader
        return this
    }

    /**
     * 设置是否显示指示器
     *
     * @param showIndicator 默认：false
     * @return
     */
    fun showIndicator(showIndicator: Boolean): ImageViewer {
        ImageViewerSpec.showIndicator = showIndicator
        return this
    }

    /**
     * 设置是否显示指示器
     *
     * @param showIndicator 默认：false
     * @return
     *
     * @Deprecated 使用[showIndicator]
     */
    @Deprecated(
        message = "This function is deprecated. Use showIndicator() instead.",
        replaceWith = ReplaceWith("showIndicator(showIndicator)"),
    )
    fun indicator(showIndicator: Boolean): ImageViewer {
        return showIndicator(showIndicator)
    }

    /**
     * 设置界面跳转过渡动画
     *
     * @param optionsCompat
     * @return
     */
    fun activityOptionsCompat(optionsCompat: ActivityOptionsCompat?): ImageViewer {
        this.mOptionsCompat = optionsCompat
        return this
    }

    /**
     * 设置屏幕方向
     *
     * @param orientation 默认：[ActivityInfo.SCREEN_ORIENTATION_BEHIND]
     * @return
     */
    fun orientation(orientation: Int): ImageViewer {
        ImageViewerSpec.orientation = orientation
        return this
    }

    /**
     * 设置主题风格
     *
     * @param theme 默认：[R.style.ImageViewerTheme]
     * @return
     */
    fun theme(@StyleRes theme: Int): ImageViewer {
        ImageViewerSpec.theme = theme
        return this
    }

    /**
     * 设置图片查看器Activity。如：ImageViewerActivity，当 ImageViewerActivity 的实现不满足你的需求时，你可以通过自定义实现
     *
     * @param cls
     * @return
     */
    fun imageViewerClass(cls: Class<*>): ImageViewer {
        imageViewerClass = cls
        return this
    }

    /**
     * 设置扩展数据 相当于 `intent.putExtras(extras)`
     *
     * @param extras
     * @return
     */
    fun extras(extras: Bundle?): ImageViewer {
        extrasBundle = extras
        return this
    }

    /**
     * 初始化资源
     *
     * @param context
     */
    private fun initResource(context: Context) {
        if (ImageViewerSpec.placeholderDrawable == null && placeholderDrawableId != 0) {
            ImageViewerSpec.placeholderDrawable =
                ContextCompat.getDrawable(context, placeholderDrawableId)
        }
        if (ImageViewerSpec.errorDrawable == null && errorDrawableId != 0) {
            ImageViewerSpec.errorDrawable = ContextCompat.getDrawable(context, errorDrawableId)
        }
    }

    /**
     * 启动
     *
     * @param activity      当前的[Activity]
     * @param sharedElement 过渡动画的共享元素
     */
    @JvmOverloads
    fun start(activity: Activity, sharedElement: View? = null) {
        checkNotNull(ImageViewerSpec.imageLoader())
        initResource(activity)

        activity.startActivity(
            obtainImageViewerIntent(activity),
            obtainActivityOptionsCompatBundle(activity, sharedElement),
        )
    }

    /**
     * 启动
     *
     * @param fragment      当前的[Fragment]
     * @param sharedElement 过渡动画的共享元素
     */
    @JvmOverloads
    fun start(fragment: Fragment, sharedElement: View? = null) {
        checkNotNull(ImageViewerSpec.imageLoader())
        val context = fragment.requireContext()
        initResource(context)

        fragment.startActivity(
            obtainImageViewerIntent(context),
            obtainActivityOptionsCompatBundle(fragment.requireActivity(), sharedElement),
        )
    }

    /**
     * 获取ImageViewer对应的[Intent]
     */
    private fun obtainImageViewerIntent(context: Context): Intent {
        return Intent(context, imageViewerClass).apply {
            extrasBundle?.also {
                this.putExtras(it)
            }
        }
    }

    /**
     * 获取 ActivityOptionsCompat 转 Bundle
     *
     * @param activity [Activity]
     * @param sharedElement 共享元素
     * @return
     */
    private fun obtainActivityOptionsCompatBundle(
        activity: Activity,
        sharedElement: View?,
    ): Bundle? {
        if (mOptionsCompat == null) {
            val sharedView = sharedElement ?: activity.findViewById(android.R.id.content)
            mOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity, sharedView, SHARED_ELEMENT,
            )
        }
        return mOptionsCompat!!.toBundle()
    }

    companion object {

        const val SHARED_ELEMENT: String = "shared_element"

        /**
         * 加载图片
         *
         * @param model 支持[Uri]、 `url`、 `filePath`、[File]、 [DrawableRes]、[ImageDataSource]等类型；
         * 对于加载多张图片数据也可以是支持类型对应的[List]或[Array]
         *
         * @return
         */
        @JvmStatic
        fun load(model: Any): ImageViewer {
            return ImageViewer(model)
        }

        /**
         * 设置全局默认的图片加载器；当设置了全局默认的图片加载器后，就可以在使用[ImageViewer]实例时，不用再单独
         * 调用[ImageViewer.imageLoader]去设置图片加载器了。
         *
         * @param imageLoader
         * @return
         */
        @JvmStatic
        fun setGlobalDefaultImageLoader(imageLoader: ImageLoader) {
            ImageViewerSpec.globalDefaultImageLoader = imageLoader
        }
    }
}
