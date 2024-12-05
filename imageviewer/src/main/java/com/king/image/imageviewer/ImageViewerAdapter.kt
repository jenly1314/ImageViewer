package com.king.image.imageviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class ImageViewerAdapter extends Adapter<ImageViewerAdapter.ImageHolder> {

    private final List<?> mListData;

    private OnItemClickListener mOnItemClickListener;

    public ImageViewerAdapter(List<?> list) {
        this.mListData = list != null ? list : new ArrayList<>();
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_viewer_list_item, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        holder.displayImage(mListData.get(position));
        holder.photoView.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(v, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListData != null ? mListData.size() : 0;
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    /**
     * 点击Item监听
     */
    public interface OnItemClickListener {
        /**
         * 点击Item
         *
         * @param v
         * @param position
         */
        void onClick(View v, int position);
    }

    static class ImageHolder extends RecyclerView.ViewHolder {

        ImageView photoView;

        private ImageHolder(@NonNull View itemView) {
            super(itemView);
            photoView = itemView.findViewById(R.id.photoView);
        }

        private void displayImage(Object data) {
            if (ViewerSpec.INSTANCE.imageLoader != null) {
                ViewerSpec.INSTANCE.imageLoader.loadImage(photoView.getContext(), photoView, data, ViewerSpec.INSTANCE.placeholderDrawable, ViewerSpec.INSTANCE.errorDrawable);
            }
        }
    }

}
