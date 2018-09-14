package com.sinothk.helper.image.widget.nineGridLayout;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.sinothk.helper.image.R;

import java.util.List;

public class NineGridView extends LinearLayout {

    public NineGridView(Context context) {
        super(context);
    }

    public NineGridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NineGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NineGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setData(List<Image> data) {
        if (data == null || data.size() == 0) {
            this.setVisibility(GONE);
        } else {
            this.setVisibility(VISIBLE);

            if (data.size() == 1) {
                showOneImage(data.get(0));
            } else {
                showMultiImage(data);
            }
        }
    }

    private void showOneImage(Image image) {
        boolean ignoreWidthHeight = true;

        ScreenTools screentools = ScreenTools.instance(getContext());
        int totalWidth = screentools.getScreenWidth() - screentools.dip2px(80);

        int imageWidth = 0;
        int imageHeight = 0;

        if (image.getWidth() != 0 && image.getHeight() != 0) {

            ignoreWidthHeight = false;

            imageWidth = screentools.dip2px(image.getWidth());
            imageHeight = screentools.dip2px(image.getHeight());

            if (image.getWidth() <= image.getHeight()) {
                if (imageHeight > totalWidth) {
                    imageHeight = totalWidth;
                    imageWidth = (imageHeight * image.getWidth()) / image.getHeight();
                }
            } else {
                if (imageWidth > totalWidth) {
                    imageWidth = totalWidth;
                    imageHeight = (imageWidth * image.getHeight()) / image.getWidth();
                }
            }
        } else {
            ignoreWidthHeight = true;
        }

        CustomImageView imageView = (CustomImageView) LayoutInflater.from(getContext()).inflate(R.layout.nine_grid_single_img, null);

        if (ignoreWidthHeight) {
            imageView.setLayoutParams(new ViewGroup.LayoutParams(totalWidth / 3 * 2, ViewGroup.LayoutParams.WRAP_CONTENT));
        } else {
            imageView.setLayoutParams(new ViewGroup.LayoutParams(imageWidth, imageHeight));
        }

        imageView.setClickable(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageUrl(image.getUrl());

        this.removeAllViews();
        this.addView(imageView);
    }

    private void showMultiImage(List<Image> data) {
        this.removeAllViews();

        NineGridLayout nineGridLayout = (NineGridLayout) LayoutInflater.from(getContext()).inflate(R.layout.nine_grid_multi_img, null);
        this.addView(nineGridLayout);

        nineGridLayout.setImagesData(data);
    }
}
