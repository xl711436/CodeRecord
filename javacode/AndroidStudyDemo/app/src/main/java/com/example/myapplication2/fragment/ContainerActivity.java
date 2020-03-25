package com.example.myapplication2.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;

public class ContainerActivity extends AppCompatActivity {

    private AFragment aFragment;
    private BFragment bFragment;
    private Button btn_change_a,btn_change_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        btn_change_a = (Button)findViewById(R.id.btn_change_a);
        btn_change_b = (Button)findViewById(R.id.btn_change_b);
        aFragment = new AFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();

        btn_change_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bFragment = new BFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
            }
        });

        btn_change_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aFragment = new AFragment();
                Bundle curBundle = new Bundle();
                curBundle.putString("key1","aabbcc");
                aFragment.setArguments(curBundle);
                //addToBackStack 添加到回退栈，响应返回事件
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,aFragment).addToBackStack(null).commitAllowingStateLoss();
            }
        });

    }
}
