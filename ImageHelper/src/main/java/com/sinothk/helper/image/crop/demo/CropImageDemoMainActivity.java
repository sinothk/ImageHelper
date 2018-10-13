package com.sinothk.helper.image.crop.demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.sinothk.helper.image.R;
import com.sinothk.helper.image.crop.CropImageMainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class CropImageDemoMainActivity extends Activity {

    private final int requestCode = 100;
    private ImageView retImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cropimage_demo_main);

        findViewById(R.id.btn1).setOnClickListener(listener);
        findViewById(R.id.btn2).setOnClickListener(listener);
        findViewById(R.id.btn3).setOnClickListener(listener);
        findViewById(R.id.btn4).setOnClickListener(listener);

        retImg = (ImageView) findViewById(R.id.retImg);
    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int index = 1;

            if (v.getId() == R.id.btn1) {
                index = CropImageMainActivity.STYLE_1;
            }else if (v.getId() == R.id.btn2) {
                index = CropImageMainActivity.STYLE_2;
            }else if (v.getId() == R.id.btn3) {
                index = CropImageMainActivity.STYLE_3;
            }else if (v.getId() == R.id.btn4) {
                index = CropImageMainActivity.STYLE_4;
            }

            try {
                final InputStream is1 = getResources().getAssets().open("test_4.jpg");

                final File outfile1 = new File(getExternalFilesDir(null), "test_4.jpg");

                FileOutputStream fos = new FileOutputStream(outfile1);
                byte[] buffer = new byte[4096];
                int len = -1;
                while ((len = is1.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                is1.close();

                CropImageMainActivity.start(CropImageDemoMainActivity.this, outfile1.getPath(), requestCode, index);//
            }catch (Exception r){

            }

        }
    };

    @Override
    protected void onActivityResult(int _requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == _requestCode && resultCode == RESULT_OK) {
            String path = data.getStringExtra("cropImagePath");
            retImg.setImageDrawable(BitmapDrawable.createFromPath(path));
        }
    }
}
