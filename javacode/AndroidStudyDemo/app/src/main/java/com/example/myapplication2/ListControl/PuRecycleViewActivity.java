package com.example.myapplication2.ListControl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class PuRecycleViewActivity extends AppCompatActivity {

    private RecyclerView rv_pu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycle_view);

        ArrayList<String> curList  = new ArrayList<String>();
        for(int i=0;i <90; i++)
        {
            curList.add("hello" + i);
        }

        rv_pu = (RecyclerView)findViewById(R.id.rv_pu);

        StaggeredGridLayoutManager curManager = new StaggeredGridLayoutManager( 4,StaggeredGridLayoutManager.VERTICAL);
        rv_pu.setLayoutManager(curManager);

        rv_pu.setAdapter(new PuAdapter(PuRecycleViewActivity.this, curList, new IItemOnClick() {
            @Override
            public void OnClick(int pos, String content) {
                Toast.makeText(PuRecycleViewActivity.this,"p点击" + content + " " + pos,Toast.LENGTH_SHORT).show();
            }
        }));

        rv_pu.addItemDecoration(new PuDecoration());
    }
}
