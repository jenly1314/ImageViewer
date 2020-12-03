package com.king.image.imageviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class ImageViewerAdapter extends Adapter<ImageViewerAdapter.ImageHolder> {

    private List<?> mDatas;

    private OnItemClickListener mOnItemClickListener;

    public ImageViewerAdapter(List<?> list){
        this.mDatas = list !=null ? list :  new ArrayList<>();
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vp_image_viewer_item,parent,false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, final int position) {
        holder.displayImage(mDatas.get(position));
        holder.photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener!=null){
                    mOnItemClickListener.onClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    public interface OnItemClickListener{
        void onClick(View v,int position);
    }

    static class ImageHolder extends RecyclerView.ViewHolder {

        ImageView photoView;

        private ImageHolder(@NonNull View itemView) {
            super(itemView);
            photoView = itemView.findViewById(R.id.photoView);
        }

        private void displayImage(Object data){
            if(ViewerSpec.INSTANCE.imageLoader != null){
                ViewerSpec.INSTANCE.imageLoader.loadImage(photoView.getContext(),photoView,data,ViewerSpec.INSTANCE.placeholderDrawable,ViewerSpec.INSTANCE.errorDrawable);
            }
        }

    }

}
