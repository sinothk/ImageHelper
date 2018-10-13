package com.sinothk.helper.image.demo.compress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sinothk.helper.image.demo.R;
import com.sinothk.helper.image.utils.compress.CompressCallback;
import com.sinothk.helper.image.utils.compress.ImageCompress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 根据路径压缩，然后返回路径
 */
public class CompressFilePathMainActivity extends AppCompatActivity {

    private TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compress_demo_activity);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        ImageCompress.setDebug(true);
        ImageCompress.compressReset();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 单一文件
                saveIntoFile1();
            }
        });


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveIntoFile2();
            }
        });
    }

    private void saveIntoFile1() {

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

            ImageCompress.execute(outfile1.getPath(), new CompressCallback() {
                @Override
                public void compressed(Object obj) {
                    if (obj == null) {
                        return;
                    }
                    String newPath = (String) obj;
                    textView1.setText(newPath);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveIntoFile2() {

        try {
            final InputStream is1 = getResources().getAssets().open("test_4.jpg");
            final InputStream is2 = getResources().getAssets().open("test_3.jpg");
            final InputStream is3 = getResources().getAssets().open("test_2.jpg");

            final File outfile1 = new File(getExternalFilesDir(null), "batch-test-4.jpg");
            final File outfile2 = new File(getExternalFilesDir(null), "batch-test-3.jpg");
            final File outfile3 = new File(getExternalFilesDir(null), "batch-test-2.jpg");

            FileOutputStream fos = new FileOutputStream(outfile1);
            byte[] buffer = new byte[4096];
            int len = -1;
            while ((len = is1.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos = new FileOutputStream(outfile2);
            buffer = new byte[4096];
            len = -1;
            while ((len = is2.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos = new FileOutputStream(outfile3);
            buffer = new byte[4096];
            len = -1;
            while ((len = is3.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
//            fos = new FileOutputStream(outfile4);
//            buffer = new byte[4096];
//            len = -1;
//            while ((len = is4.read(buffer)) != -1) {
//                fos.write(buffer, 0, len);
//            }
            fos.close();

            is1.close();
            is2.close();
            is3.close();
//            is4.close();

            String[] pathArr = new String[3];
            pathArr[0] = outfile1.getPath();
            pathArr[1] = outfile2.getPath();
            pathArr[2] = outfile3.getPath();

            ImageCompress.execute(pathArr, new CompressCallback() {
                @Override
                public void compressed(Object obj) {
                    if (obj == null) {
                        Log.e("a", "a=" + "compress bitmap failed!");
                    } else {

                        final String[] ps = ((String[]) obj);

                        String content = "";
                        for (int i = 0; i < ps.length; i++) {
                            content += ps[i] + ", ";
                        }

                        Log.e("压缩结果：", "path = " + content);
                        textView2.setText(content);
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImageCompress.compressReset();
    }
}

