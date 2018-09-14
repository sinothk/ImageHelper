package com.sinothk.helper.image.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sinothk.helper.image.demo.NineGridLayout.NineGridDemLayoutMainActivity;
import com.sinothk.helper.image.demo.RoundedImageView.RoundedDemoMainActivity;

public class ImageHelperDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoRoundedImageView(View view) {
        startActivity(new Intent(ImageHelperDemoMainActivity.this, RoundedDemoMainActivity.class));
    }

    public void gotoNineGridLayout(View view) {
        startActivity(new Intent(ImageHelperDemoMainActivity.this, NineGridDemLayoutMainActivity.class));
    }
}
