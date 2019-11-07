package com.king.image.imageviewer.loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.king.image.imageviewer.ImageViewer;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.io.File;

import androidx.annotation.Nullable;

/**
 * 当使用{@link GlideImageLoader}时，必须依赖{@link Picasso}库。
 * 为了保证{@link ImageViewer}体积最小化，和用户更多可能的选择性，并未将{@link Picasso}打包进aar。
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class PicassoImageLoader implements ImageLoader {

    @Override
    public void loadImage(Context context, ImageView imageView,Object data, @Nullable Drawable placeholderDrawable,@Nullable Drawable errorDrawable) {
        RequestCreator requestCreator = null;
        if(data instanceof Uri){
            requestCreator = Picasso.get().load((Uri)data);
        }else if(data instanceof String){
            requestCreator = Picasso.get().load((String)data);
        }else if(data instanceof Integer){
            requestCreator = Picasso.get().load((Integer) data);
        }else if(data instanceof File){
            requestCreator = Picasso.get().load((File) data);
        }

        if(requestCreator!=null){
            if(placeholderDrawable != null){
                requestCreator.placeholder(placeholderDrawable);
            }
            if(errorDrawable != null){
                requestCreator.error(errorDrawable);
            }
            requestCreator.into(imageView);
        }

    }
}
