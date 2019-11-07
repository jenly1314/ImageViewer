package com.king.imageviewer.app;

import android.os.Bundle;
import android.view.View;

import com.king.image.imageviewer.ImageViewer;
import com.king.image.imageviewer.loader.GlideImageLoader;
import com.king.imageviewer.app.adapter.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class PhotoListActivity extends AppCompatActivity {

    private List<String> listData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_list_activity);
        init();
    }

    private void init(){
        listData = new ArrayList<>();
        for (int i=1;i<20;i++){
            listData.add(String.format("https://jenly.coding.me/medias/featureimages/%d.jpg",i));
        }

        PhotoAdapter adapter = new PhotoAdapter(listData);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(PhotoListActivity.this,2));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PhotoAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                //图片查看器
                // data 可以多张图片List或单张图片，支持的类型可以是{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
                ImageViewer.load(listData)//要加载的图片数据，单张或多张
                        .selection(position)//当前选中位置
                        .indicator(true)//是否显示指示器，默认不显示
                        .imageLoader(new GlideImageLoader())//加载器，*必须配置，目前内置的有GlideImageLoader或PicassoImageLoader，也可以自己实现
//                      .imageLoader(new PicassoImageLoader())
                        .start(PhotoListActivity.this,v);
            }
        });

    }
}
