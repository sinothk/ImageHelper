package com.sinothk.helper.image.demo.RoundedImageView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sinothk.helper.image.demo.ImageHelperDemoMainActivity;
import com.sinothk.helper.image.demo.R;
import com.sinothk.helper.image.widget.roundedImageView.RoundedImageView;
import com.squareup.picasso.Picasso;

public class RoundedDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounded_demo);

        RoundedImageView imageView1 = findViewById(R.id.imageView1);
        Picasso.with(this).load("http://p0.so.qhimgs1.com/dmfd/235_200_/t014e4b443955fa0480.jpg").into(imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoundedDemoMainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
