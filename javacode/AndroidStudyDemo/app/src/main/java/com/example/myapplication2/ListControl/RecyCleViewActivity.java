package com.example.myapplication2.ListControl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;

public class RecyCleViewActivity extends AppCompatActivity {

    private Button btn_linear;
    private Button btn_hor;
    private Button btn_grid;
    private Button btn_pu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_cle_view);

        btn_linear = (Button)findViewById(R.id.btn_linear);

        btn_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curIntent = new Intent(RecyCleViewActivity.this,LinearRecycleViewActivity.class);
                startActivity(curIntent);
            }
        });

        btn_hor = (Button)findViewById(R.id.btn_hor);

        btn_hor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curIntent = new Intent(RecyCleViewActivity.this,HorRecycleViewActivity.class);
                startActivity(curIntent);
            }
        });


        btn_grid = (Button)findViewById(R.id.btn_grid);

        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curIntent = new Intent(RecyCleViewActivity.this,GridRecycleViewActivity.class);
                startActivity(curIntent);
            }
        });

        btn_pu = (Button)findViewById(R.id.btn_pu);

        btn_pu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curIntent = new Intent(RecyCleViewActivity.this,PuRecycleViewActivity.class);
                startActivity(curIntent);
            }
        });





    }
}
