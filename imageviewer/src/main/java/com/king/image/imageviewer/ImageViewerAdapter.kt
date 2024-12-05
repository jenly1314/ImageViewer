package com.king.image.imageviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.github.chrisbanes.photoview.PhotoView

/**
 * 图片浏览适配器
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class ImageViewerAdapter(private val listData: List<*>) :
    RecyclerView.Adapter<ImageViewerAdapter.ImageHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_viewer_list_item, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.displayImage(listData[position])
        holder.photoView.setOnClickListener { v: View? ->
            mOnItemClickListener?.onClick(v, holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.mOnItemClickListener = listener
    }

    /**
     * 点击Item监听
     */
    fun interface OnItemClickListener {
        /**
         * 点击Item
         *
         * @param v
         * @param position
         */
        fun onClick(v: View?, position: Int)
    }

    class ImageHolder(itemView: View) : ViewHolder(itemView) {

        val photoView: PhotoView = itemView.findViewById(R.id.photoView)

        fun displayImage(model: Any?) {
            ImageViewerSpec.imageLoader()?.loadImage(
                imageView = photoView,
                model = model,
                placeholderDrawable = ImageViewerSpec.placeholderDrawable,
                errorDrawable = ImageViewerSpec.errorDrawable,
            )
        }
    }
}
