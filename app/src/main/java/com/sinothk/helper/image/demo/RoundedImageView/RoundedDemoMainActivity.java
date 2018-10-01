package com.sinothk.helper.image.demo.RoundedImageView;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.request.target.Target;
import com.sinothk.helper.image.demo.R;
import com.sinothk.helper.image.loader.ImageLoader;
import com.sinothk.helper.image.loader.OnLoadListener;
import com.sinothk.helper.image.loader.TransformationStyle;
import com.sinothk.helper.image.utils.ImageUtil;
import com.sinothk.helper.image.widget.roundedImageView.RoundedImageView;

public class RoundedDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounded_demo);

        RoundedImageView imageView1 = findViewById(R.id.imageView1);
        RoundedImageView imageView2 = findViewById(R.id.imageView2);
        RoundedImageView imageView3 = findViewById(R.id.imageView3);
        RoundedImageView imageView4 = findViewById(R.id.imageView4);

        RoundedImageView imageView5 = findViewById(R.id.imageView5);
        final RoundedImageView imageView6 = findViewById(R.id.imageView6);

        ImageLoader.loadNetImg(this, "http://p0.so.qhimgs1.com/dmfd/235_200_/t014e4b443955fa0480.jpg", imageView1);
        ImageLoader.loadNetImgWithResize(this, "http://p0.so.qhimgs1.com/dmfd/235_200_/t014e4b443955fa0480.jpg", imageView2, R.drawable.top_img, 200, 200);
        ImageLoader.loadNetImg(this, "http://p0.so.qhimgs1.com/dmfd/235_200_/t014e4b443955fa0480.jpg", imageView3, R.drawable.top_img);

        ImageLoader.loadNetImgWithCallback(this, "http://p0.so.qhimgs1.com/dmfd/235_200_/t014e4b443955fa0480.jpg", imageView5, R.drawable.top_img, new OnLoadListener() {
            @Override
            public void onResourceReady(Drawable resource, Object model) {
                Bitmap blurBitmap = ImageUtil.getBlurBitmap(resource, 20);

                imageView6.setImageBitmap(blurBitmap);
            }

            @Override
            public void onLoadFailed(Object model, Target<Drawable> target) {
                if (model == null) {

                }
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoundedDemoMainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageView7 = findViewById(R.id.imageView7);
        ImageView imageView8 = findViewById(R.id.imageView8);

        // 圆形裁剪
        ImageLoader.loadNetImgWithTransformation(this, "http://p0.so.qhimgs1.com/dmfd/235_200_/t014e4b443955fa0480.jpg",
                imageView7, R.drawable.top_img, TransformationStyle.getCropCircle());

        // 圆角图片
        ImageLoader.loadNetImgWithTransformation(this, "http://p0.so.qhimgs1.com/dmfd/235_200_/t014e4b443955fa0480.jpg",
                imageView8, R.drawable.top_img, TransformationStyle.getRoundTransform(this, 50));

    }
}
