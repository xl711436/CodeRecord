package com.example.myapplication2.ListControl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class HorAdapter extends RecyclerView.Adapter<HorViewHolder> {

    private Context mContext;
    private ArrayList<String> mTitleList;

    private IItemOnClick mOnClick;

    public HorAdapter(Context context, ArrayList<String> titleList, IItemOnClick mOnClick)
    {
        this.mContext = context;
        this.mTitleList = titleList;
        this.mOnClick = mOnClick;
    }

    @NonNull
    @Override
    public HorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HorViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_recycle_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorViewHolder holder, final int position) {

        holder.textView.setText(mTitleList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
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
