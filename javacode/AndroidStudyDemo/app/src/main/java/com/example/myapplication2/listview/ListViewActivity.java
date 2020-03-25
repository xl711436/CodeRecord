package com.example.myapplication2.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class ListViewActivity extends Activity {

    private ListView lv_1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ArrayList<Be_ListViewInfo> curList = Be_ListViewInfo.GetTestList();

        lv_1 = (ListView)findViewById(R.id.lv_1);

        lv_1.setAdapter(new MyListAdapter(ListViewActivity.this,curList));

        lv_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"点击" + position,Toast.LENGTH_SHORT).show();
            }
        });
        lv_1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"长按" + position,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
