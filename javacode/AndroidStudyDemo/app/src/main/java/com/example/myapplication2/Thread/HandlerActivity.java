package com.example.myapplication2.Thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.R;

import org.w3c.dom.Text;

public class HandlerActivity extends AppCompatActivity {

    private Handler mHandler;
    private Handler mHandler1;

    private TextView tv_test ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        tv_test = (TextView)findViewById(R.id.tv_test);

        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandlerActivity.this, com.example.myapplication2.BaseControl.ButtonActivity.class);
                startActivity(intent);
            }
        },3000);

        mHandler1 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what)
                {
                    case 1:
                    {
                        Toast.makeText(HandlerActivity.this,"成功1",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 2:
                    {
                        Toast.makeText(HandlerActivity.this,"成功2",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default:
                    {
                        break;
                    }
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                mHandler1.sendMessage(message);


            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message = new Message();



                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                message.what = 2;
                mHandler1.sendMessage(message);
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(HandlerActivity.this,"成功3",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();

        tv_test.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(HandlerActivity.this,"成功4",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
