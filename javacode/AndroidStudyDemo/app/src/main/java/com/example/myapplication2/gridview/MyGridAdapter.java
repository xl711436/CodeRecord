package com.example.myapplication2.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication2.R;
import com.example.myapplication2.listview.Be_ListViewInfo;
import com.example.myapplication2.listview.Pe_ListViewItemHolder;

import java.util.ArrayList;

public class MyGridAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Be_GridViewInfo> showInfoList;

    public MyGridAdapter(Context I_Context,ArrayList<Be_GridViewInfo> I_ShowInfoList)
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
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pe_GridViewItemHolder holder = null;

        if(convertView == null)
        {
            convertView = mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new Pe_GridViewItemHolder();

            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_grid);
            holder.title = (TextView)convertView.findViewById(R.id.tv_title);


            Be_GridViewInfo curInfo = this.showInfoList.get(position);
            holder.title.setText(curInfo.Str_Title);


            Glide.with(this.mContext).load(curInfo.Str_Url).into(holder.imageView);

            convertView.setTag(holder);
        }
        else
        {
            holder = (Pe_GridViewItemHolder)convertView.getTag();
        }



        return convertView;
    }
}
