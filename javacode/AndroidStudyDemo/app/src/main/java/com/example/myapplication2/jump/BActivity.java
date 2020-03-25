package com.example.myapplication2.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication2.R;

public class BActivity extends AppCompatActivity {

    private TextView jump_tv_b;
    private Button jump_btn_return,btn_jumpa;


    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("AActivity","----onCreate-------");
        Log.i("AActivity","taskid:" + getTaskId() + "hash:" + hashCode());
        logtaskName();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.i("AActivity","----onCreate-------");
        Log.i("AActivity","taskid:" + getTaskId() + "hash:" + hashCode());
        logtaskName();

        jump_tv_b = (TextView)findViewById(R.id.jump_tv_b);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            jump_tv_b.setText(bundle.getString("key1"));
        }



        jump_btn_return = (Button)findViewById(R.id.jump_btn_return);
        btn_jumpa= (Button)findViewById(R.id.btn_jumpa);

        jump_btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reIntent = new Intent();

                Bundle curBundle = new Bundle();
                curBundle.putString("key1","re1");
                curBundle.putString("key2","re2");
                curBundle.putString("key3","re3");
                reIntent.putExtras(curBundle);

                setResult(Activity.RESULT_OK,reIntent);
                finish();
            }
        });

        btn_jumpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(BActivity.this,AActivity.class);
                startActivity(intent);
            }
        });


    }

    private void     logtaskName() {

        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.i("任务栈名称", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
