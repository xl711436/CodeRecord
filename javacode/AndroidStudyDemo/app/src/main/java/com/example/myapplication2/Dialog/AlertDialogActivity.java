package com.example.myapplication2.Dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication2.R;

public class AlertDialogActivity extends AppCompatActivity {

    private Button btn_dialog_1,btn_dialog_2,btn_dialog_3,btn_dialog_4,btn_dialog_5;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btn_dialog_1 = (Button)findViewById(R.id.btn_dialog_1);
        btn_dialog_2 = (Button)findViewById(R.id.btn_dialog_2);
        btn_dialog_3 = (Button)findViewById(R.id.btn_dialog_3);
        btn_dialog_4 = (Button)findViewById(R.id.btn_dialog_4);
        btn_dialog_5 = (Button)findViewById(R.id.btn_dialog_5);

        btn_dialog_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setTitle("请回答");
                builder.setMessage("你觉得课程如何？");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setPositiveButton("棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"你很诚实",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("还行", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"你再看看",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("不好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"不要乱说",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        btn_dialog_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] array2 = new String[]{"男","女"};
                AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                builder2.setTitle("选择性别");
                builder2.setItems(array2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"选中" + array2[which],Toast.LENGTH_SHORT).show();
                    }
                });
                builder2.show();
            }
        });

        btn_dialog_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] array3 = new String[]{"男","女"};
                AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                builder3.setTitle("选择性别");
                builder3.setSingleChoiceItems(array3,1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"选中" + array3[which],Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder3.setCancelable(false);
                builder3.show();
            }
        });

        btn_dialog_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] array4 = new String[]{"唱歌","跳舞","写代码"};
                boolean[] isSelected = new boolean[]{false,false,true};
                AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                builder4.setTitle("选择兴趣");
                builder4.setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(getApplicationContext(), array4[which] + isChecked,Toast.LENGTH_SHORT).show();
                            }
                        });

                builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"你很诚实",Toast.LENGTH_SHORT).show();
                    }
                });
                builder4.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"你再看看",Toast.LENGTH_SHORT).show();
                    }
                });
                builder4.show();
            }
        });

        btn_dialog_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_alert_dialog,null);

               final Button btnLogin = (Button) view.findViewById(R.id.btn_login);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"你再看看" + btnLogin.getText(),Toast.LENGTH_SHORT).show();
                    }
                });
                builder5.setTitle("请先登录");
                builder5.setView(view);
                builder5.show();
            }
        });

    }
}
