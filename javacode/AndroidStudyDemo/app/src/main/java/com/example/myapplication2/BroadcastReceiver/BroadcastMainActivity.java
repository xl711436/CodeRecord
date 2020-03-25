package com.example.myapplication2.BroadcastReceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;
import com.example.myapplication2.SubMenu.BaseControlActivity;
import com.example.myapplication2.SubMenu.ListActivity;

public class BroadcastMainActivity extends AppCompatActivity {

    private Button btn_custombroad;
    private Button btn_battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_main);

        btn_custombroad = (Button)findViewById(R.id.btn_custombroad);
        btn_battery = (Button)findViewById(R.id.btn_battery);

        btn_custombroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadcastMainActivity.this, CustomeBroadActivity.class);
                startActivity(intent);
            }
        });

        btn_battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(BroadcastMainActivity.this, BatteryActivity.class);
                startActivity(intent);
            }
        });

    }
}
