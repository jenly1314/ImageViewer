package com.king.image.imageviewer

import android.net.Uri
import androidx.annotation.DrawableRes
import java.io.File

/**
 * 图片数据源；当数据集合为自定义对象时，可通过实现此接口来将图片数据源直接返回
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
interface ImageDataSource {
    /**
     * 返回图片数据源
     *
     * @return 返回支持[Uri]、 `url`、 `filePath`、[File]、 [DrawableRes]等类型
     */
    fun getDataSource(): Any?
}
