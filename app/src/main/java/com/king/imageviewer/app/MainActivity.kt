package com.king.imageviewer.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.king.image.imageviewer.ImageViewer;
import com.king.image.imageviewer.loader.GlideImageLoader;
import com.king.image.imageviewer.loader.ImageLoader;
import com.king.image.imageviewer.loader.PicassoImageLoader;

import java.io.File;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

/**
 * ImageViewer 是一个图片查看器。一般用来查看图片详情或查看大图时使用。
 *
 * {@link ImageViewer} 支持加载{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
 * 如果使用{@link GlideImageLoader}会支持的类型会更多。
 * 使用{@link ImageViewer}时，必须配置一个实现的{@link ImageLoader}。
 * 目前内置默认实现的{@link ImageLoader}有{@link GlideImageLoader} 和{@link PicassoImageLoader}
 * 如果不满足您的需求，您也可以自己实现一个{@link ImageLoader}
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void startActivity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                startActivity(PhotoActivity.class);
                break;
            case R.id.btn2:
                startActivity(PhotoListActivity.class);
                break;
        }

    }
}
