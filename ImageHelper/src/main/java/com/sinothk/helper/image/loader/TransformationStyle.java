package com.sinothk.helper.image.loader;

import android.content.Context;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.sinothk.helper.image.loader.transforms.GlideCircleTransform;
import com.sinothk.helper.image.loader.transforms.GlideRoundTransform;

/**
 * @ author LiangYT
 * @ create 2018/9/30 17:15
 * @ Describe
 */
public class TransformationStyle {

    public static BitmapTransformation getCropCircle() {
        return new GlideCircleTransform();
    }

    public static BitmapTransformation getRoundTransform(Context mContext, int dp) {
        return new GlideRoundTransform(mContext, dp);
    }

    //new BlurTransformation(context, 25, 3)
}
