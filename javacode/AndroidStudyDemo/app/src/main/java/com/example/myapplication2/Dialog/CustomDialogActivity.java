package com.example.myapplication2.Dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication2.R;
import com.example.myapplication2.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button btn_custom_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        btn_custom_dialog = (Button)findViewById(R.id.btn_custom_dialog);

        btn_custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog curDialog = new CustomDialog(CustomDialogActivity.this)
                        .setStr_tv_title("测试标题")
                        .setStr_tv_content("测试内容")
                        .setStr_tv_confirm("确定1", new CustomDialog.ICustomDialogOnClick() {
                            @Override
                            public void OnClick(CustomDialog dialog) {
                                Toast.makeText(CustomDialogActivity.this,"确定2",Toast.LENGTH_SHORT).show();
                            }
                        }).setStr_tv_cancel("取消1", new CustomDialog.ICustomDialogOnClick() {
                            @Override
                            public void OnClick(CustomDialog dialog) {
                                Toast.makeText(CustomDialogActivity.this,"取消2",Toast.LENGTH_SHORT).show();
                            }
                        });
                curDialog.show();
            }
        });
    }
}
