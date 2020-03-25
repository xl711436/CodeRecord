package com.example.myapplication2.SubMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.Dialog.AlertDialogActivity;
import com.example.myapplication2.Dialog.CustomDialogActivity;
import com.example.myapplication2.Dialog.PopupWindowActivity;
import com.example.myapplication2.Dialog.ProgressActivity;
import com.example.myapplication2.BaseControl.TextViewActivity;
import com.example.myapplication2.BaseControl.ToastActivity;
import com.example.myapplication2.R;

public class DialogActivity extends AppCompatActivity {

    private Button btn_toast;
    private Button btn_alertdialog;
    private Button btn_progress;
    private Button btn_customdialog;
    private Button btn_popupwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);


        btn_toast = (Button)findViewById(R.id.btn_toast);
        btn_alertdialog = (Button)findViewById(R.id.btn_alertdialog);
        btn_progress = (Button)findViewById(R.id.btn_progress);
        btn_customdialog = (Button)findViewById(R.id.btn_customdialog);
        btn_popupwindow = (Button)findViewById(R.id.btn_popupwindow);

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogActivity.this, ToastActivity.class);
                startActivity(intent);
            }
        });
        btn_alertdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogActivity.this, AlertDialogActivity.class);
                startActivity(intent);
            }
        });
        btn_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogActivity.this, ProgressActivity.class);
                startActivity(intent);
            }
        });
        btn_customdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogActivity.this, CustomDialogActivity.class);
                startActivity(intent);
            }
        });
        btn_popupwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogActivity.this, PopupWindowActivity.class);
                startActivity(intent);
            }
        });
    }
}
