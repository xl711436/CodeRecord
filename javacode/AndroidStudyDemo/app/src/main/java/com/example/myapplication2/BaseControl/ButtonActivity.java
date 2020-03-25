package com.example.myapplication2.BaseControl;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication2.R;

public class ButtonActivity extends AppCompatActivity {

    private Button btn_btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btn_btn3 = (Button) findViewById(R.id.btn_3);
        btn_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"我被点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
