package com.example.myapplication2.ListControl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class PuAdapter extends RecyclerView.Adapter<PuViewHolder> {

    private Context mContext;
    private ArrayList<String> mTitleList;

    private IItemOnClick mOnClick;

    public PuAdapter(Context context, ArrayList<String> titleList, IItemOnClick mOnClick)
    {
        this.mContext = context;
        this.mTitleList = titleList;
        this.mOnClick = mOnClick;
    }

    @NonNull
    @Override
    public PuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PuViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_recycle_pu_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PuViewHolder holder, final int position) {

        if(position % 2 != 0)
        {
            holder.curImage.setImageResource(R.drawable.image1);
        }
        else
        {
            holder.curImage.setImageResource(R.drawable.image2);
        }
        holder.curImage.setTag(mTitleList.get(position));
        holder.curImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClick.OnClick(position,mTitleList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }
}
