package com.sinothk.helper.image.demo.NineGridLayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.sinothk.helper.image.demo.R;
import com.sinothk.helper.image.widget.nineGridLayout.Image;

import java.util.ArrayList;
import java.util.List;


public class NineGridDemLayoutMainActivity extends AppCompatActivity {

    private ListView listView;
    private List<List<Image>> imagesList;

    private String[][] images = new String[][]{
//            {"http://p3.so.qhimgs1.com/t01e71c2e94dc62c583.jpg", "0", "0"},
            {"http://img.zcool.cn/community/015d9259701f24a8012193a3478a13.jpg@1280w_1l_2o_100sh.jpg", "0", "0"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "640", "640"}
            , {"http://p0.so.qhimgs1.com/t01067641db04be8e50.jpg", "800", "650"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nine_grid_demo_activity_main);

        listView = (ListView) findViewById(R.id.lv_main);

        imagesList = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ArrayList<Image> itemList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                itemList.add(new Image(images[j][0], Integer.parseInt(images[j][1]), Integer.parseInt(images[j][2])));
            }
            imagesList.add(itemList);
        }

        final MainAdapter adapter = new MainAdapter(NineGridDemLayoutMainActivity.this, imagesList);
        listView.setAdapter(adapter);
    }

}
