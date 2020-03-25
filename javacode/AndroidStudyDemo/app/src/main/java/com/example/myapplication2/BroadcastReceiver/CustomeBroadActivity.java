package com.example.myapplication2.BroadcastReceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication2.R;

public class CustomeBroadActivity extends AppCompatActivity {

    private Button btn_broad2;
    private TextView tv_broadmessage;

    private  MyBroadcast myBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);

        tv_broadmessage = (TextView)findViewById(R.id.tv_broadmessage);

        btn_broad2 = (Button)findViewById(R.id.btn_broad2);
        btn_broad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomeBroadActivity.this, CustomBroadActivity2.class);
                startActivity(intent);
            }
        });

        myBroadcast = new MyBroadcast();
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction("broadtest");
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcast,intentFilter);


    }


    private class MyBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction())
            {
                case "broadtest":
                {
                    tv_broadmessage.setText("aaa");
                    break;
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcast);
    }
}
