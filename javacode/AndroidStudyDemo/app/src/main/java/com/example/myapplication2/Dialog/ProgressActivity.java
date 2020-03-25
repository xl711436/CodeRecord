package com.example.myapplication2.Dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication2.R;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar pb3;
    private Button btn_start,btn_progress1,btn_progress2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        pb3 = (ProgressBar) findViewById(R.id.pb3);
        pb3.setProgress(60);
        btn_start= (Button) findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handler.sendEmptyMessage(0);
            }
        });

        btn_progress1= (Button) findViewById(R.id.btn_progress1);
        btn_progress2= (Button) findViewById(R.id.btn_progress2);



        btn_progress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);

                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");
                progressDialog.show();
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(ProgressActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btn_progress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);

                progressDialog.setTitle("提示");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMessage("正在加载...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressActivity.this,"棒",Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.show();
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(ProgressActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
        Handler handler = new Handler()
        {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(pb3.getProgress() < 100)
                {
                    handler.postDelayed(runnable,100);
                }else
                {
                    Toast.makeText(ProgressActivity.this,"加载完成",Toast.LENGTH_SHORT).show();
                }

            }
        };

        Runnable runnable = new  Runnable(){

            @Override
            public void run() {
                pb3.setProgress(pb3.getProgress() +1);
                handler.sendEmptyMessage(0);
            }
        };

}
