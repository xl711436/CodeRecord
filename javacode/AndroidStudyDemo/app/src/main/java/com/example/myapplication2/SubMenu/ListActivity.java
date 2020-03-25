package com.example.myapplication2.SubMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.Dialog.AlertDialogActivity;
import com.example.myapplication2.Dialog.ProgressActivity;
import com.example.myapplication2.BaseControl.ToastActivity;
import com.example.myapplication2.ListControl.RecyCleViewActivity;
import com.example.myapplication2.R;
import com.example.myapplication2.gridview.GridViewActivity;
import com.example.myapplication2.listview.ListViewActivity;

public class ListActivity extends AppCompatActivity {

    private Button btn_listview;
    private Button btn_gridview;
    private Button btn_recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        btn_listview = (Button)findViewById(R.id.btn_listview);
        btn_gridview = (Button)findViewById(R.id.btn_gridview);
        btn_recyclerview = (Button)findViewById(R.id.btn_recyclerview);


        btn_listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        btn_gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, GridViewActivity.class);
                startActivity(intent);
            }
        });
        btn_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, RecyCleViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
