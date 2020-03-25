package com.example.myapplication2.ListControl;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

public class PuViewHolder extends RecyclerView.ViewHolder {

    public ImageView curImage;

    public PuViewHolder(View itemView)
    {
        super(itemView);
        curImage = (ImageView) itemView.findViewById(R.id.iv_recycle);
    }

}
