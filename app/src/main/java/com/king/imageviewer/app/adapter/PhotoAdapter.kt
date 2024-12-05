package com.king.imageviewer.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.king.image.imageviewer.ImageViewerSpec
import com.king.imageviewer.app.R

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class PhotoAdapter(private val listData: List<String>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    private var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_photo_item, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.displayImage(listData[position])
        holder.imageView.setOnClickListener { v: View? ->
            mOnItemClickListener?.onClick(v, holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.mOnItemClickListener = listener
    }

    interface OnItemClickListener {
        fun onClick(v: View?, position: Int)
    }

    class PhotoHolder(itemView: View) : ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun displayImage(url: String) {
            ImageViewerSpec.imageLoader()?.loadImage(
                imageView,
                url,
                ContextCompat.getDrawable(itemView.context, R.drawable.ic_image_placeholder),
                ContextCompat.getDrawable(itemView.context, R.drawable.ic_image_error),
            )
        }
    }
}
