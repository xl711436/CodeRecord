package com.example.myapplication2.ListControl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class LinearRecycleViewActivity extends AppCompatActivity {

    private RecyclerView rv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycle_view);

        ArrayList<String> curList  = new ArrayList<String>();
        for(int i=0;i <30; i++)
        {
            curList.add("hello" + i);
        }

        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(LinearRecycleViewActivity.this));
        rv_main.setAdapter(new LinearAdapter(LinearRecycleViewActivity.this, curList, new IItemOnClick() {
            @Override
            public void OnClick(int pos, String content) {
                Toast.makeText(LinearRecycleViewActivity.this,"点击" + content + " " + pos,Toast.LENGTH_SHORT).show();
            }
        }));

        rv_main.addItemDecoration(new LinearDecoration());
    }
}
