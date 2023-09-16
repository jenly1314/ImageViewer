package com.king.image.imageviewer;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public class ImageViewerActivity extends AppCompatActivity {

    private TextView tvIndicator;

    ImageViewerAdapter mAdapter;

    private int mSize;

    private boolean isShowIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ViewerSpec.INSTANCE.orientation);
        setTheme(ViewerSpec.INSTANCE.theme);
        setContentView(getLayoutId());
        init();
    }

    /**
     * 获取布局
     *
     * @return 返回布局ID
     */
    @LayoutRes
    protected int getLayoutId() {
        return R.layout.image_viewer_activity;
    }

    /**
     * 初始化
     */
    protected void init() {
        tvIndicator = findViewById(R.id.tvIndicator);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (isShowIndicator) {
                    updateIndicator(position, mSize);
                }
            }
        });

        ViewCompat.setTransitionName(viewPager, ImageViewer.SHARED_ELEMENT);

        mAdapter = new ImageViewerAdapter(ViewerSpec.INSTANCE.listData);
        viewPager.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener((v, position) -> onBackPressed());

        int position = ViewerSpec.INSTANCE.position;
        mSize = mAdapter.getItemCount();
        if (position >= 0) {
            viewPager.setCurrentItem(position, false);
            updateIndicator(position, mSize);
        }

        isShowIndicator = ViewerSpec.INSTANCE.isShowIndicator && mSize > 0;
        if (isShowIndicator) {
            tvIndicator.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 更新指示器
     *
     * @param position
     * @param size
     */
    private void updateIndicator(int position, int size) {
        tvIndicator.setText(String.format("%s/%s", Math.min(position + 1, size), size));
    }

}
