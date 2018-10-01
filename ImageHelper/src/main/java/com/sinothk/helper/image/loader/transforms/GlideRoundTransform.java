package com.sinothk.helper.image.loader.transforms;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

/**
 * @ author LiangYT
 * @ create 2018/9/30 17:50
 * @ Describe
 */
public class GlideRoundTransform extends BitmapTransformation {

    private float radius;

    public GlideRoundTransform(Context context) {
        radius = 10;
    }

    public GlideRoundTransform(Context context, float radius) {
        this.radius = radius;
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        return cornersCrop(pool, toTransform);
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {

    }

    private Bitmap cornersCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint  paint  = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
        return result;
    }

//    @Override
//    public String getId() {
//        return getClass().getName();
//    }
}

