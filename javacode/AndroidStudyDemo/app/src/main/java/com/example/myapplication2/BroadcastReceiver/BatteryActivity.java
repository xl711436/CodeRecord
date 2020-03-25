package com.example.myapplication2.BroadcastReceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication2.R;

public class BatteryActivity extends AppCompatActivity {
    private TextView tv_show;
    private ShowPowerReceiver showPowerReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        tv_show=(TextView)findViewById(R.id.tv_show);
          showPowerReceiver=new ShowPowerReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        //注册showPowerReceiver
        registerReceiver(showPowerReceiver, filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(showPowerReceiver);
    }

    class ShowPowerReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            //判断接收到的是否为电量变化的BroadCast Action
            if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
                //当前电量
                int level=intent.getIntExtra("level", 0);
                //总电量
                int scale=intent.getIntExtra("scale", 100);
                int current=level*100/scale;
                tv_show.setText("当前电量："+current+"%");
            }
        }
    }

}
