package com.example.myapplication2.BaseControl;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.myapplication2.R;

public class CheckBoxActivity extends AppCompatActivity {

     private CheckBox cb_1,cb_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cb_1 = (CheckBox) findViewById(R.id.cb_1);
        cb_2 = (CheckBox) findViewById(R.id.cb_2);


        cb_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,buttonView.getText() + (isChecked ?"选中":"未选中"),Toast.LENGTH_SHORT).show();
            }
        });

        cb_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,buttonView.getText() + (isChecked ?"选中":"未选中"),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
