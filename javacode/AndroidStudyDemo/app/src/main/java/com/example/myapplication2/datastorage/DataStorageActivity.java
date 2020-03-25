package com.example.myapplication2.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;

public class DataStorageActivity extends AppCompatActivity {

    private Button btn_sharedPreference,btn_file,btn_sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        btn_sharedPreference = (Button)findViewById(R.id.btn_sharedPreference);
        btn_file= (Button)findViewById(R.id.btn_file);
        btn_sqlite= (Button)findViewById(R.id.btn_sqlite);

        btn_sharedPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });

        btn_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataStorageActivity.this, FileActivity.class);
                startActivity(intent);
            }
        });

        btn_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataStorageActivity.this, SqliteActivity.class);
                startActivity(intent);
            }
        });

    }
}
