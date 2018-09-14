package com.sinothk.helper.image.demo.NineGridLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sinothk.helper.image.demo.R;
import com.sinothk.helper.image.widget.nineGridLayout.Image;
import com.sinothk.helper.image.widget.nineGridLayout.NineGridView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * creator  Lukey on 2016/6/14
 */
public class MainAdapter extends BaseAdapter {

    private Context context;
    private List<List<Image>> datalist;

    public MainAdapter(Context context, List<List<Image>> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        List<Image> itemList = datalist.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.nine_grid_demo_activity_main_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.item_time = (TextView) convertView.findViewById(R.id.item_time);

            viewHolder.nineGridView = (NineGridView) convertView.findViewById(R.id.nineGridView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nineGridView.setData(itemList);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);

        viewHolder.item_time.setText(str);
        return convertView;
    }

    class ViewHolder {

        public NineGridView nineGridView;

        public TextView item_time;
    }
}
