package com.king.image.imageviewer;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class ImageViewerActivity extends AppCompatActivity {

    static final String SHARED_ELEMENT = "shared_element";

    private TextView tvIndicator;

    ImageViewerAdapter mAdapter;

    ViewerSpec mViewerSpec;

    private int mSize;

    private boolean isShowIndicator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewerSpec = ViewerSpec.INSTANCE;
        setRequestedOrientation(mViewerSpec.orientation);
        setTheme(mViewerSpec.theme);
        setContentView(R.layout.image_viewer_activity);
        init();
    }

    private void init(){
        tvIndicator = findViewById(R.id.tvIndicator);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(isShowIndicator){
                    updateIndicator(position,mSize);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        ViewCompat.setTransitionName(viewPager,SHARED_ELEMENT);

        mAdapter = new ImageViewerAdapter(mViewerSpec.listData);
        viewPager.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ImageViewerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                onBackPressed();
            }
        });


        int position = mViewerSpec.position;
        mSize = mAdapter.getItemCount();
        if(position>=0){
            viewPager.setCurrentItem(position,false);
            updateIndicator(position,mSize);
        }

        isShowIndicator = mViewerSpec.isShowIndicator && mSize > 0;
        if(isShowIndicator){
            tvIndicator.setVisibility(View.VISIBLE);
        }
    }

    private void updateIndicator(int position,int size){
        tvIndicator.setText(String.format("%s/%s",Math.min(position + 1,size),size));
    }

    @Override
    protected void onDestroy() {
        if(mViewerSpec != null ){
            mViewerSpec.imageLoader = null;
        }
        super.onDestroy();
    }
}
