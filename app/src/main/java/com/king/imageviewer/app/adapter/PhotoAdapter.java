package com.king.imageviewer.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.king.imageviewer.app.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class PhotoAdapter extends Adapter<PhotoAdapter.PhotoHolder> {

    private List<String> mDatas;

    private OnItemClickListener mOnItemClickListener;

    public PhotoAdapter(List<String> list){
        this.mDatas = list !=null ? list : new ArrayList<String>();
    }

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_photo_item,parent,false);
        return new PhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, final int position) {
        holder.displayImage(mDatas.get(position));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
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

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    public interface OnItemClickListener{
        void onClick(View v, int position);
    }

    static class PhotoHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        private PhotoHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }

        private void displayImage(String url){
            Glide.with(imageView).load(url).into(imageView);
        }

    }

}
