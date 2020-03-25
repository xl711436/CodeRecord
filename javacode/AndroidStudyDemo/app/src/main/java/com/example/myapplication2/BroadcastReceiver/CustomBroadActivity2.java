package com.example.myapplication2.BroadcastReceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;

public class CustomBroadActivity2 extends AppCompatActivity {

    private Button btn_sendbroadmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad2);

        btn_sendbroadmessage = findViewById(R.id.btn_sendbroadmessage);

        btn_sendbroadmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent   = new Intent ("broadtest");
                LocalBroadcastManager.getInstance(CustomBroadActivity2.this).sendBroadcast(intent);
            }
        });
    }
}
