package com.sinothk.helper.image.demo.selector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sinothk.helper.image.demo.R;
import com.sinothk.helper.image.picker.PhotoPickerActivity;
import com.sinothk.helper.image.picker.SelectModel;
import com.sinothk.helper.image.picker.intent.PhotoPickerIntent;

import java.io.File;
import java.util.ArrayList;

public class ImageSelectorDemoActivity extends AppCompatActivity {

    int REQUEST_CAMERA_CODE = 2;// 从相册选择

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_selector_demo_activity_main);

        textView = (TextView) findViewById(R.id.tv);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                MultiImageSelector.create().single().showCamera(true).start(MainActivity.this, IMAGE_FROM_PHOTOS);
//                MultiImageSelector.create().showCamera(true).start(MainActivity.this, IMAGE_FROM_PHOTOS);

                PhotoPickerIntent intent = new PhotoPickerIntent(ImageSelectorDemoActivity.this);

//                intent.setSelectModel(SelectModel.MULTI);
                intent.setSelectModel(SelectModel.SINGLE);
                intent.setSelectedPaths(path);

                intent.setMaxTotal(9);
                intent.setShowCamera(true, "com.sinothk.helper.image.demo"); // 是否显示拍照， 默认false

                startActivityForResult(intent, REQUEST_CAMERA_CODE);
            }
        });
    }

    ArrayList<String> path = new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == this.RESULT_OK) {

            //图片选择返回
            if (requestCode == REQUEST_CAMERA_CODE) {
                path = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                if (path != null) {

                    StringBuilder s = new StringBuilder();
                    for (int i = 0; i < path.size(); i++) {
                        s.append(path.get(i));
                    }
                    textView.setText(s.toString());
                }
                File file = new File("");

//                selectedImages = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
//                selectedImages.addAll(data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT));
//                imgUrl = buildlImgItms(data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT)).get(0).getPicUrl();
//                imgName = getPicNameFromPath(imgUrl);
//                Bitmap bitmap = getLoacalBitmap(imgUrl);
//                imgPhoto.setImageBitmap(ImageUtil.makeRoundCorner(bitmap));

            }
        }


//        // 选择照片返回
//        try {
//            if (data != null) {
//                ArrayList<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
//
//                String s = "";
//                for (int i = 0; i < path.size(); i++) {
//                    s += path.get(i);
//                }
//                textView.setText(s);
////                imageProcessor!!.compressPhoto(2, path, imageCompressCallback)
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
