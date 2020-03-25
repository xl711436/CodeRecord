package com.example.myapplication2.ListControl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class HorRecycleViewActivity extends AppCompatActivity {

    private RecyclerView rv_hor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycle_view);

        ArrayList<String> curList  = new ArrayList<String>();
        for(int i=0;i <30; i++)
        {
            curList.add("hello" + i);
        }

        rv_hor = (RecyclerView)findViewById(R.id.rv_hor);

        LinearLayoutManager curManager = new LinearLayoutManager(HorRecycleViewActivity.this);
        curManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_hor.setLayoutManager(curManager);

        rv_hor.setAdapter(new HorAdapter(HorRecycleViewActivity.this, curList, new IItemOnClick() {
            @Override
            public void OnClick(int pos, String content) {
                Toast.makeText(HorRecycleViewActivity.this,"h点击" + content + " " + pos,Toast.LENGTH_SHORT).show();
            }
        }));

        rv_hor.addItemDecoration(new HorDecoration());

    }
}
