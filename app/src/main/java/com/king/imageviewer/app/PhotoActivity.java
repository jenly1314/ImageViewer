package com.king.imageviewer.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.king.image.imageviewer.ImageViewer;
import com.king.image.imageviewer.loader.GlideImageLoader;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_activity);
        init();
    }

    private void init(){
        ImageView iv = findViewById(R.id.iv);
        Glide.with(this).load(R.drawable.gif).into(iv);
    }

    public void onClick(View v){
        ImageViewer.load(R.drawable.gif)
                .imageLoader(new GlideImageLoader())
                .start(this,v);
    }
}
