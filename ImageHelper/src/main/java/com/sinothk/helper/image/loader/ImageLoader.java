package com.sinothk.helper.image.loader;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.math.BigDecimal;

/**
 * @ author LiangYT
 * @ create 2018/9/30 11:15
 * @ Describe ：https://blog.csdn.net/github_33304260/article/details/72526237
 */
public class ImageLoader {

    /**
     * 无预览图加载
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadNetImg(Context context, String url, ImageView imageView) {
        if (context != null) {
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .thumbnail(0.2f)
                    .into(imageView);
        } else {
            throw new NullPointerException("loadNetImg: context != null");
        }
    }

    /**
     * 添加预览图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultDrawable
     */
    public static void loadNetImg(Context context, String url, ImageView imageView, Drawable defaultDrawable) {
        if (context != null) {

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(defaultDrawable)
                    .error(defaultDrawable)
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .thumbnail(0.2f)
                    .into(imageView);
        } else {
            throw new NullPointerException("loadNetImg: context != null");
        }
    }


    /**
     * 添加预览图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultResId
     */
    public static void loadNetImg(Context context, Uri url, ImageView imageView, int defaultResId) {
        if (context != null) {

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(defaultResId)
                    .error(defaultResId)
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .thumbnail(0.2f)
                    .into(imageView);
        } else {
            throw new NullPointerException("loadNetImg: context != null");
        }
    }

    /**
     * 添加预览图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultResId
     */
    public static void loadNetImg(Context context, String url, ImageView imageView, int defaultResId) {
        if (context != null) {

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(defaultResId)
                    .error(defaultResId)
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .thumbnail(0.2f)
                    .into(imageView);
        } else {
            throw new NullPointerException("loadNetImg: context != null");
        }
    }

    /**
     * 添加预览图片
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultResId
     * @param transformation
     */
    public static void loadNetImgWithTransformation(Context context, String url, ImageView imageView, int defaultResId, BitmapTransformation transformation) {
        if (context != null) {

            RequestOptions options =  new RequestOptions()
                    .centerCrop()
                    .placeholder(defaultResId)
                    .error(defaultResId)
                    .transform(transformation)
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .thumbnail(0.2f)
                    .into(imageView);

        } else {
            throw new NullPointerException("loadNetImg: context != null");
        }
    }

    /**
     * 预加载图片，设置显示宽高大小
     *
     * @param context
     * @param url
     * @param imageView
     * @param defaultImgResId
     * @param width
     * @param height
     */
    public static void loadNetImgWithResize(Context context, String url, ImageView imageView, int defaultImgResId, int width, int height) {
        if (context != null) {

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(defaultImgResId)
                    .error(defaultImgResId)
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .fitCenter()
                    .override(width, height);

            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .thumbnail(0.2f)
                    .into(imageView);
        } else {
            throw new NullPointerException("loadNetImg: context != null");
        }
    }

    public static void loadNetImgWithCallback(Context context, String url, ImageView imageView, int defaultImgResId, final OnLoadListener onLoadListener) {
        if (context != null) {

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(defaultImgResId)
                    .error(defaultImgResId)
                    .priority(Priority.HIGH)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .thumbnail(0.2f)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.e("loadNetImgWithResize", "onLoadFailed --->" + e);
                            onLoadListener.onLoadFailed(model, e.getMessage());
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            Log.e("loadNetImgWithResize", "onResourceReady---> " + resource);
                            onLoadListener.onResourceReady(resource, model);

                            return false;
                        }
                    })
                    .into(imageView);
        } else {
            throw new NullPointerException("loadNetImg: context != null");
        }
    }

    /**
     * 清除缓存
     *
     * @param mActivity
     */
    public static void clearCache(final Activity mActivity, final OnClearCacheListener onClearCacheListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CacheUtil.clearCache(mActivity);

                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            onClearCacheListener.onFinish(true, "清理完成");
                        }
                    });
                } catch (Exception e) {
                    onClearCacheListener.onFinish(false, "清理失败：" + e.getMessage());
                }
            }
        }).start();
    }

    public interface OnClearCacheListener {
        void onFinish(boolean isSuccess, String msg);
    }

    /**
     * 获得缓存大小
     *
     * @return
     */
    public static String getCacheSize(Context mContext) {
        return CacheUtil.getCacheSize(mContext);
    }

    private static class CacheUtil {

        /**
         * 清除所有Cache：必须在后台线程中调用，建议同时clearMemory()
         * 清除图片所有缓存
         */
        public static void clearCache(final Context context) {
            if (context != null) {
                clearImageDiskCache(context);
                clearImageMemoryCache(context);
                String ImageExternalCatchDir = context.getExternalCacheDir() + ExternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR;
                deleteFolderFile(ImageExternalCatchDir, true);
            }
        }

        /**
         * 删除指定目录下的文件，这里用于缓存的删除
         *
         * @param filePath       filePath
         * @param deleteThisPath deleteThisPath
         */
        private static void deleteFolderFile(String filePath, boolean deleteThisPath) {
            if (!TextUtils.isEmpty(filePath)) {
                try {
                    File file = new File(filePath);
                    if (file.isDirectory()) {
                        File files[] = file.listFiles();
                        for (File file1 : files) {
                            deleteFolderFile(file1.getAbsolutePath(), true);
                        }
                    }
                    if (deleteThisPath) {
                        if (!file.isDirectory()) {
                            file.delete();
                        } else {
                            if (file.listFiles().length == 0) {
                                file.delete();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 清除图片磁盘缓存
         */
        public static void clearImageDiskCache(final Context context) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Glide.get(context).clearDiskCache();
//                        BusUtil.getBus().post(new GlideCacheClearSuccessEvent());
                        }
                    }).start();
                } else {
                    Glide.get(context).clearDiskCache();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 清除图片内存缓存
         */
        public static void clearImageMemoryCache(Context context) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                    Glide.get(context).clearMemory();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // ====================================================================================================================================
        static String getCacheSize(Context context) {
            try {
                return getFormatSize(getFolderSize(new File(context.getCacheDir() + "/" + InternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        /**
         * 获取指定文件夹内所有文件大小的和
         *
         * @param file file
         * @return size
         * @throws Exception
         */
        private static long getFolderSize(File file) throws Exception {
            long size = 0;
            try {
                File[] fileList = file.listFiles();
                for (File aFileList : fileList) {
                    if (aFileList.isDirectory()) {
                        size = size + getFolderSize(aFileList);
                    } else {
                        size = size + aFileList.length();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return size;
        }

        /**
         * 格式化单位
         *
         * @param size size
         * @return size
         */
        private static String getFormatSize(double size) {

            double kiloByte = size / 1024;
            if (kiloByte < 1) {
                return size + "Byte";
            }

            double megaByte = kiloByte / 1024;

            if (megaByte < 1) {
                BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
                return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
            }

            double gigaByte = megaByte / 1024;
            if (gigaByte < 1) {
                BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
                return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
            }

            double teraBytes = gigaByte / 1024;
            if (teraBytes < 1) {
                BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
                return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
            }
            BigDecimal result4 = new BigDecimal(teraBytes);

            return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
        }
    }
}
