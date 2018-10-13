package com.sinothk.helper.image.crop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import com.sinothk.helper.image.R;


public class CropImageMainActivity extends Activity {

    public static final int STYLE_1 = 1;// 1:底图缩放，浮层不变
    public static final int STYLE_2 = 2;// 2:底图不变，浮层移动
    public static final int STYLE_3 = 3;// 3:底图不变，浮层移动与缩放(长方形)
    public static final int STYLE_4 = 4;// 4:底图不变，浮层移动与缩放(正方形)

    private String oldImgPath = "";

    public static void start(Activity currActivity, String imgPath, int requestCode) {
        Intent mIntent = new Intent(currActivity, CropImageMainActivity.class);
        mIntent.putExtra("imgPath", imgPath);
        mIntent.putExtra("style", STYLE_4);
        currActivity.startActivityForResult(mIntent, requestCode);
    }

    public static void start(Activity currActivity, String imgPath, int requestCode, int style) {
        Intent mIntent = new Intent(currActivity, CropImageMainActivity.class);
        mIntent.putExtra("imgPath", imgPath);
        mIntent.putExtra("style", style);
        currActivity.startActivityForResult(mIntent, requestCode);
    }

    /**
     * =================Fragment===================
     */
    public static void start(Fragment currFragment, String imgPath, int requestCode) {
        Intent mIntent = new Intent(currFragment.getContext(), CropImageMainActivity.class);
        mIntent.putExtra("imgPath", imgPath);
        mIntent.putExtra("style", STYLE_4);
        currFragment.startActivityForResult(mIntent, requestCode);
    }

    public static void start(Fragment currFragment, String imgPath, int requestCode, int style) {
        Intent mIntent = new Intent(currFragment.getContext(), CropImageMainActivity.class);
        mIntent.putExtra("imgPath", imgPath);
        mIntent.putExtra("style", style);
        currFragment.startActivityForResult(mIntent, requestCode);
    }

    /**
     * ====================================
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        FileUtil.init(CropImageMainActivity.this);

        oldImgPath = getIntent().getStringExtra("imgPath");

        int index = getIntent().getIntExtra("style", STYLE_4);
        if (index == STYLE_1) {
            cropImage1(oldImgPath);
        } else if (index == STYLE_2) {
            cropImage2(oldImgPath);
        } else if (index == STYLE_3) {
            cropImage3(oldImgPath);
        } else if (index == STYLE_4) {
            cropImage4(oldImgPath);
        }
    }

    private void cropImage1(String oldImgPath) {
        setContentView(R.layout.cropimage_fragment_style1);

        final CropImageView mCropImage = (CropImageView) findViewById(R.id.cropImg);

        mCropImage.setDrawable(BitmapDrawable.createFromPath(oldImgPath), 250, 250);
//        mCropImage.setDrawable(getResources().getDrawable(R.drawable.precrop), 250, 250);

        findViewById(R.id.save).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        FileUtil.writeImage(mCropImage.getCropImage(), FileUtil.SDCARD_PAHT + "/crop.png", 100);

                        Intent mIntent = new Intent();
                        mIntent.putExtra("cropImagePath", FileUtil.SDCARD_PAHT + "/crop.png");
                        setResult(RESULT_OK, mIntent);
                        finish();
                    }
                }).start();
            }
        });

        findViewById(R.id.cancel).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                setResult(-100, mIntent);
                finish();
            }
        });
    }

    private void cropImage2(String oldImgPath) {
        setContentView(R.layout.cropimage_fragment_style2);
        final CropImageView2 mCropImage = (CropImageView2) findViewById(R.id.cropImg);

//        mCropImage.setDrawable(getResources().getDrawable(R.drawable.precrop), 250, 250);
        mCropImage.setDrawable(BitmapDrawable.createFromPath(oldImgPath), 250, 250);

        findViewById(R.id.save).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        FileUtil.writeImage(mCropImage.getCropImage(), FileUtil.SDCARD_PAHT + "/crop.png", 100);
                        Intent mIntent = new Intent();
                        mIntent.putExtra("cropImagePath", FileUtil.SDCARD_PAHT + "/crop.png");
                        setResult(RESULT_OK, mIntent);
                        finish();
                    }
                }).start();
            }
        });

        findViewById(R.id.cancel).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                setResult(-100, mIntent);
                finish();
            }
        });
    }

    private void cropImage3(String oldImgPath) {
        setContentView(R.layout.cropimage_fragment_style3);
        final CropImageView3 mCropImage = (CropImageView3) findViewById(R.id.cropImg);

//        mCropImage.setDrawable(getResources().getDrawable(R.drawable.precrop), 250, 250);
        mCropImage.setDrawable(BitmapDrawable.createFromPath(oldImgPath), 250, 250);

        findViewById(R.id.save).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        FileUtil.writeImage(mCropImage.getCropImage(), FileUtil.SDCARD_PAHT + "/crop.png", 100);
                        Intent mIntent = new Intent();
                        mIntent.putExtra("cropImagePath", FileUtil.SDCARD_PAHT + "/crop.png");
                        setResult(RESULT_OK, mIntent);
                        finish();
                    }
                }).start();
            }
        });

        findViewById(R.id.cancel).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                setResult(-100, mIntent);
                finish();
            }
        });
    }

    private void cropImage4(String oldImgPath) {
        setContentView(R.layout.cropimage_fragment_style4);
        final CropImageView4 mCropImage = (CropImageView4) findViewById(R.id.cropImg);

        mCropImage.setDrawable(BitmapDrawable.createFromPath(oldImgPath), 250, 250);
//        mCropImage.setDrawable(getResources().getDrawable(R.drawable.precrop), 250, 250);

        findViewById(R.id.save).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        FileUtil.writeImage(mCropImage.getCropImage(), FileUtil.SDCARD_PAHT + "/crop.png", 100);
                        Intent mIntent = new Intent();
                        mIntent.putExtra("cropImagePath", FileUtil.SDCARD_PAHT + "/crop.png");
                        setResult(RESULT_OK, mIntent);
                        finish();
                    }
                }).start();
            }
        });

        findViewById(R.id.cancel).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                setResult(-100, mIntent);
                finish();
            }
        });
    }
}
