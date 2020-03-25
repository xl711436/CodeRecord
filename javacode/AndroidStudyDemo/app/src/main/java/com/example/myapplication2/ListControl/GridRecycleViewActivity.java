package com.example.myapplication2.ListControl;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class GridRecycleViewActivity extends AppCompatActivity {

    private RecyclerView rv_grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle_view);

        ArrayList<String> curList  = new ArrayList<String>();
        for(int i=0;i <90; i++)
        {
            curList.add("hello" + i);
        }

        rv_grid = (RecyclerView)findViewById(R.id.rv_grid);

        GridLayoutManager curManager = new GridLayoutManager(GridRecycleViewActivity.this,3);
        rv_grid.setLayoutManager(curManager);

        rv_grid.setAdapter(new GridAdapter(GridRecycleViewActivity.this, curList, new IItemOnClick() {
            @Override
            public void OnClick(int pos, String content) {
                Toast.makeText(GridRecycleViewActivity.this,"g点击" + content + " " + pos,Toast.LENGTH_SHORT).show();
            }
        }));

        rv_grid.addItemDecoration(new GridDecoration());

    }
}
