package com.example.myapplication2.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication2.R;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Be_ListViewInfo> showInfoList;

    public MyListAdapter(Context I_Context,ArrayList<Be_ListViewInfo> I_ShowInfoList)
    {
        this.mContext = I_Context;
        this.showInfoList = I_ShowInfoList;
        mLayoutInflater = LayoutInflater.from(I_Context);
    }
    @Override
    public int getCount() {
        return this.showInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return showInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pe_ListViewItemHolder holder = null;

        if(convertView == null)
        {
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new Pe_ListViewItemHolder();

            holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            holder.title = (TextView)convertView.findViewById(R.id.tv_title);
            holder.time = (TextView)convertView.findViewById(R.id.tv_time);

            Be_ListViewInfo curInfo = this.showInfoList.get(position);
            holder.title.setText(curInfo.Str_Title);
            holder.time.setText(curInfo.Str_Time);

            Glide.with(this.mContext).load(curInfo.Str_Url).into(holder.imageView);

            convertView.setTag(holder);
        }
        else
        {
            holder = (Pe_ListViewItemHolder)convertView.getTag();
        }



        return convertView;
    }


}
