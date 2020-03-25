package com.example.myapplication2.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication2.R;

public class AActivity extends AppCompatActivity {

    private Button btn_jump1, btn_jumpb,btn_jumpa;

    @Override
    protected void onDestroy() {
        Log.i("AActivity","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.i("AActivity","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i("AActivity","onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("AActivity","onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.i("AActivity","onPause");
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("AActivity","----onCreate-------");
        Log.i("AActivity","taskid:" + getTaskId() + "hash:" + hashCode());
        logtaskName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.i("AActivity","----onCreate-------");
        Log.i("AActivity","taskid:" + getTaskId() + "hash:" + hashCode());
        logtaskName();
        btn_jump1 =(Button)findViewById(R.id.btn_jump1);
        btn_jumpb =(Button)findViewById(R.id.btn_jumpb);
        btn_jumpa=(Button)findViewById(R.id.btn_jumpa);
        btn_jump1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //显示调用1
          /*      Intent intent = new Intent(AActivity.this,BActivity.class);
                startActivity(intent);

                //显示调用2
                Intent intent = new Intent();
                intent.setClass(AActivity.this,BActivity.class);
                startActivity(intent);



                //显示调用3
                Intent intent = new Intent();
                intent.setClassName(AActivity.this,"com.example.myapplication2.jump.BActivity");
                startActivity(intent);

                //显示调用4
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(AActivity.this,"com.example.myapplication2.jump.BActivity"));
                startActivity(intent);


                //隐式
                Intent intent = new Intent();
                intent.setAction("test.B");
                startActivity(intent);


                //隐式 传值
                Intent intent = new Intent();
                intent.setAction("test.B");
                //intent.putExtra("key1","value1");
                Bundle curBundle = new Bundle();
                curBundle.putString("key1","value1");
                curBundle.putString("key2","value2");
                curBundle.putString("key3","value3");
                intent.putExtras(curBundle);
                startActivity(intent); */


                //隐式 传值 双向
                Intent intent = new Intent();
                intent.setAction("test.B");
                //intent.putExtra("key1","value1");
                Bundle curBundle = new Bundle();
                curBundle.putString("key1","value1");
                curBundle.putString("key2","value2");
                curBundle.putString("key3","value3");
                intent.putExtras(curBundle);

                startActivityForResult(intent,0);

            }
        });

        btn_jumpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(AActivity.this,BActivity.class);
                startActivity(intent);
            }
        });

        btn_jumpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });

    }

    //接收跳转的返回值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle curBundle = data.getExtras();
        Toast.makeText(AActivity.this,curBundle.getString("key1"),Toast.LENGTH_SHORT).show();

    }

    private void     logtaskName(){

        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.i("任务栈名称",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
