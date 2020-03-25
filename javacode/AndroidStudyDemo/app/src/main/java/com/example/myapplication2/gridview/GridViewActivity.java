package com.example.myapplication2.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.R;
import com.example.myapplication2.listview.Be_ListViewInfo;
import com.example.myapplication2.listview.ListViewActivity;
import com.example.myapplication2.listview.MyListAdapter;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    private GridView curGridView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        curGridView  =(GridView)findViewById(R.id.gv_1);

        ArrayList<Be_GridViewInfo> curList = Be_GridViewInfo.GetTestList();
        curGridView.setAdapter(new MyGridAdapter(GridViewActivity.this,curList));

        curGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"点击" + position,Toast.LENGTH_SHORT).show();
            }
        });
        curGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"长按" + position,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
