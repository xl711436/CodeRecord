package com.example.myapplication2.BaseControl;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication2.R;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup rg_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        rg_1 = (RadioGroup)findViewById(R.id.rg_1);

        rg_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton curChecked = (RadioButton)findViewById(checkedId);
                Toast.makeText(RadioButtonActivity.this,curChecked.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
