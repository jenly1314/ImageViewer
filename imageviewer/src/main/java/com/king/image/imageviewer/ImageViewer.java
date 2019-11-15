package com.king.image.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.king.image.imageviewer.loader.ImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/**
 * ImageViewer 是一个图片查看器。一般用来查看图片详情或查看大图时使用。
 *
 * {@link ImageViewer} 支持加载{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
 * 如果使用{@code GlideImageLoader}会支持的类型会更多。
 * 使用{@code ImageViewer}时，必须配置一个实现的{@link ImageLoader}。
 * 目前内置默认实现的{@link ImageLoader}有{@code GlideImageLoader} 和{@code PicassoImageLoader}
 * 如果不满足您的需求，您也可以自己实现一个{@link ImageLoader}
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public final class ImageViewer {

    private ViewerSpec mViewerSpec;

    private ActivityOptionsCompat mOptionsCompat;

    private int placeholderDrawableId;
    private int errorDrawableId;

    private ImageViewer(@NonNull List<?> data){
        mViewerSpec = ViewerSpec.INSTANCE;
        mViewerSpec.reset();
        mViewerSpec.listData = data;
    }

    private ImageViewer(@NonNull Object data){
        mViewerSpec = ViewerSpec.INSTANCE;
        mViewerSpec.reset();
        List<Object> listData = new ArrayList<>();
        listData.add(data);
        mViewerSpec.listData = listData;
    }

    /**
     * 加载图片
     * @param data List中的泛型支持{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
     * @return
     */
    public static ImageViewer load(@NonNull List<?> data){
        return new ImageViewer(data);
    }

    /**
     * 加载图片
     * @param path  支持{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
     * @return
     */
    public static ImageViewer load(@NonNull String path){
        return new ImageViewer(path);
    }

    /**
     * 加载图片
     * @param uri  支持{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
     * @return
     */
    public static ImageViewer load(@NonNull Uri uri){
        return new ImageViewer(uri);
    }

    /**
     * 加载图片
     * @param resourceId  支持{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
     * @return
     */
    public static ImageViewer load(@DrawableRes int resourceId){
        return new ImageViewer(resourceId);
    }

    /**
     * 加载图片
     * @param file  支持{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
     * @return
     */
    public static ImageViewer load(@NonNull File file){
        return new ImageViewer(file);
    }

    /**
     * 加载图片
     * @param data  支持{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
     * @return
     */
    public static ImageViewer load(@NonNull Object data){
        return new ImageViewer(data);
    }

    /**
     * 当前选中位置
     * @param position 默认：0
     * @return
     */
    public ImageViewer selection(int position){
        mViewerSpec.position = position;
        return this;
    }

    /**
     * 设置占位图
     * @param resourceId
     * @return
     */
    public ImageViewer placeholder(@DrawableRes int resourceId){
        this.placeholderDrawableId = resourceId;
        this.mViewerSpec.placeholderDrawable = null;
        return this;
    }

    /**
     * 设置占位图
     * @param drawable
     * @return
     */
    public ImageViewer placeholder(@Nullable Drawable drawable){
        this.mViewerSpec.placeholderDrawable = drawable;
        this.placeholderDrawableId = 0;
        return this;
    }

    /**
     * 设置加载失败时显示的图片
     * @param resourceId
     * @return
     */
    public ImageViewer error(@DrawableRes int resourceId){
        this.errorDrawableId = resourceId;
        this.mViewerSpec.errorDrawable = null;
        return this;
    }

    /**
     * 设置加载失败时显示的图片
     * @param drawable
     * @return
     */
    public ImageViewer error(@Nullable Drawable drawable){
        this.mViewerSpec.errorDrawable = drawable;
        this.errorDrawableId = 0;
        return this;
    }

    /**
     * 设置图片加载器
     * @param imageLoader
     * @return
     */
    public ImageViewer imageLoader(@NonNull ImageLoader imageLoader){
        this.mViewerSpec.imageLoader = imageLoader;
        return this;
    }

    /**
     * 设置是否显示指示器
     * @param showIndicator  默认：false
     * @return
     */
    public ImageViewer indicator(boolean showIndicator){
        this.mViewerSpec.isShowIndicator = showIndicator;
        return this;
    }

    /**
     * 设置界面跳转过渡动画
     * @param optionsCompat
     * @return
     */
    public ImageViewer activityOptionsCompat(ActivityOptionsCompat optionsCompat){
        this.mOptionsCompat = optionsCompat;
        return this;
    }

    /**
     * 设置屏幕方向
     * @param orientation  默认：{@link ActivityInfo#SCREEN_ORIENTATION_BEHIND}
     * @return
     */
    public ImageViewer orientation(int orientation){
        this.mViewerSpec.orientation = orientation;
        return this;
    }

    /**
     * 设置主题风格
     * @param theme  默认：{@link R.style#ImageViewerTheme}
     * @return
     */
    public ImageViewer theme(@StyleRes int theme){
        this.mViewerSpec.theme = theme;
        return this;
    }

    /**
     * 初始化资源
     * @param context
     */
    private void initResource(Context context){
        if(mViewerSpec.placeholderDrawable == null && placeholderDrawableId != 0){
            mViewerSpec.placeholderDrawable = ContextCompat.getDrawable(context,placeholderDrawableId);
        }
        if(mViewerSpec.errorDrawable == null && errorDrawableId != 0){
            mViewerSpec.errorDrawable = ContextCompat.getDrawable(context,errorDrawableId);
        }
    }

    /**
     * 启动
     * @param activity 当前的{@link Activity}
     */
    public void start(@NonNull Activity activity){
        start(activity,null);
    }

    /**
     * 启动
     * @param activity 当前的{@link Activity}
     * @param sharedElement 过渡动画共享元素
     */
    public void start(@NonNull Activity activity,@Nullable View sharedElement){
        initResource(activity);
        Intent intent = new Intent(activity,ImageViewerActivity.class);

        if(mOptionsCompat == null){
            if(sharedElement != null){
                mOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,sharedElement,ImageViewerActivity.SHARED_ELEMENT);
            }else{
                mOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(activity,R.anim.iv_anim_in,R.anim.iv_anim_out);
            }
        }

        Bundle bundle = null;
        if(mOptionsCompat!=null){
            bundle = mOptionsCompat.toBundle();
        }

        activity.startActivity(intent,bundle);
    }

    /**
     * 启动
     * @param fragment 当前的{@link Fragment}
     */
    public void start(@NonNull Fragment fragment){
        start(fragment,null);
    }

    /**
     * 启动
     * @param fragment 当前的{@link Fragment}
     * @param sharedElement 过渡动画的共享元素
     */
    public void start(@NonNull Fragment fragment, @Nullable View sharedElement){
        initResource(fragment.getContext());
        Intent intent = new Intent(fragment.getContext(),ImageViewerActivity.class);

        if(mOptionsCompat == null){
            if(sharedElement != null){
                mOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(fragment.getActivity(),sharedElement,ImageViewerActivity.SHARED_ELEMENT);
            }else{
                mOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(fragment.getContext(),R.anim.iv_anim_in,R.anim.iv_anim_out);
            }
        }

        Bundle bundle = null;
        if(mOptionsCompat!=null){
            bundle = mOptionsCompat.toBundle();
        }

        fragment.startActivity(intent,bundle);
    }

}
