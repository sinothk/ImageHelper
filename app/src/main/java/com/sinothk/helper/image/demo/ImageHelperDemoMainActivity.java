package com.sinothk.helper.image.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sinothk.helper.image.demo.NineGridLayout.NineGridDemLayoutMainActivity;
import com.sinothk.helper.image.demo.RoundedImageView.RoundedDemoMainActivity;
import com.sinothk.helper.image.demo.compress.CompressFilePathMainActivity;
import com.sinothk.helper.image.demo.selector.ImageSelectorDemoActivity;
import com.sinothk.helper.image.loader.ImageLoader;

public class ImageHelperDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button cacheSizeBtn = this.findViewById(R.id.cacheSizeBtn);
        final Button getCacheBtn = this.findViewById(R.id.getCacheBtn);
        getCacheBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cacheSizeBtn.setText("清除：" + ImageLoader.getCacheSize(ImageHelperDemoMainActivity.this));
            }
        });

        // 清除
        cacheSizeBtn.setText("清除：" + ImageLoader.getCacheSize(this));
        cacheSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageLoader.clearCache(ImageHelperDemoMainActivity.this, new ImageLoader.OnClearCacheListener() {
                    @Override
                    public void onFinish(boolean isSuccess, String msg) {
                        if (isSuccess) {
                            cacheSizeBtn.setText("清除：" + ImageLoader.getCacheSize(ImageHelperDemoMainActivity.this));
                        } else {
                            Toast.makeText(ImageHelperDemoMainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void gotoRoundedImageView(View view) {
        startActivity(new Intent(ImageHelperDemoMainActivity.this, RoundedDemoMainActivity.class));
    }

    public void gotoNineGridLayout(View view) {
        startActivity(new Intent(ImageHelperDemoMainActivity.this, NineGridDemLayoutMainActivity.class));
    }

    public void gotoCompressDemoActivity(View view) {
        startActivity(new Intent(ImageHelperDemoMainActivity.this, CompressFilePathMainActivity.class));
    }

    public void gotoImageSelectorDemoActivity(View view) {
        startActivity(new Intent(ImageHelperDemoMainActivity.this, ImageSelectorDemoActivity.class));
    }
}
