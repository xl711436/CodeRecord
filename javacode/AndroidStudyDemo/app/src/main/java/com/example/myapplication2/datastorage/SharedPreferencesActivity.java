package com.example.myapplication2.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication2.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText et_name;
    private Button btn_save,btn_show;
    private TextView tv_show;

    private SharedPreferences curSharePreference;
    private SharedPreferences.Editor curEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        curSharePreference = getSharedPreferences("data",MODE_PRIVATE);
        curEditor = curSharePreference.edit();


        et_name= (EditText)findViewById(R.id.et_name);
        btn_save= (Button) findViewById(R.id.btn_save);
        btn_show= (Button) findViewById(R.id.btn_show);
        tv_show= (TextView) findViewById(R.id.tv_show);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curEditor.putString("key1",et_name.getText().toString());
                curEditor.apply();
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_show.setText(curSharePreference.getString("key1",""));
            }
        });

    }
}
