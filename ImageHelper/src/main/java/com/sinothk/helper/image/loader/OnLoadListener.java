package com.sinothk.helper.image.loader;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.Target;

/**
 * @ author LiangYT
 * @ create 2018/9/30 16:52
 * @ Describe
 */
public interface OnLoadListener {
    void onResourceReady(Drawable resource, Object model);

    void onLoadFailed(Object model, String target);
}
