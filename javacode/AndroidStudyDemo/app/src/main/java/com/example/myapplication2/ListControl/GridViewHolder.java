package com.example.myapplication2.ListControl;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

public class GridViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public GridViewHolder(View itemView)
    {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.tv_title);
    }

}
