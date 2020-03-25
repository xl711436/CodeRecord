package com.example.myapplication2.CallMessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication2.R;

import java.util.ArrayList;

public class CallMessageActivity extends AppCompatActivity {


    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    private Button btn_call,btn_send;
    private EditText et_callnumber,et_messagenumber,et_messagecontent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_message);

        btn_call = (Button)findViewById(R.id.btn_call);
        btn_send = (Button)findViewById(R.id.btn_send);

        et_callnumber = (EditText)findViewById(R.id.et_callnumber);
        et_messagenumber = (EditText)findViewById(R.id.et_messagenumber);
        et_messagecontent = (EditText)findViewById(R.id.et_messagecontent);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_callnumber.getText().toString().trim() == null || et_callnumber.getText().toString().trim().equals("")) {
                    Toast.makeText(CallMessageActivity.this, "对不起，电话不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else if (et_callnumber.getText().toString().trim() != null && !(et_callnumber.getText().toString().trim().equals(""))) {

                    Intent intentcall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ et_callnumber.getText().toString().trim()));

                    int checkResult = ContextCompat.checkSelfPermission(CallMessageActivity.this, Manifest.permission.CALL_PHONE);
                    Log.i("CallMessageActivity","checkResult call  " + checkResult);


                    if (checkResult != PackageManager.PERMISSION_GRANTED){

                        if (ActivityCompat.shouldShowRequestPermissionRationale(CallMessageActivity.this, Manifest.permission.CALL_PHONE)) {

                            Log.i("CallMessageActivity","申请授权 call");

                            Toast.makeText(CallMessageActivity.this, "请授权！", Toast.LENGTH_LONG).show();

                            // 帮跳转到该应用的设置界面，让用户手动授权
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getPackageName(), null);
                            intent.setData(uri);
                            startActivity(intent);
                        }else{
                            Log.i("CallMessageActivity","直接请求授权");
                            // 不需要解释为何需要该权限，直接请求授权
                            ActivityCompat.requestPermissions(CallMessageActivity.this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_SEND_SMS);
                        }
                    }else {
                        Log.i("CallMessageActivity","直接call  " );
                        startActivity(intentcall);
                    }



                }
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int checkResult = ContextCompat.checkSelfPermission(CallMessageActivity.this, Manifest.permission.SEND_SMS);

                Log.i("CallMessageActivity","checkResult  " + checkResult);

                if (checkResult != PackageManager.PERMISSION_GRANTED){
                    // 没有获得授权，申请授权
                    if (ActivityCompat.shouldShowRequestPermissionRationale(CallMessageActivity.this, Manifest.permission.SEND_SMS)) {

                        Log.i("CallMessageActivity","申请授权");
                        // 返回值：
//                     如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                     如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                     如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                        // 弹窗需要解释为何需要该权限，再次请求授权
                        Toast.makeText(CallMessageActivity.this, "请授权！", Toast.LENGTH_LONG).show();

                        // 帮跳转到该应用的设置界面，让用户手动授权
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    }else{
                        Log.i("CallMessageActivity","直接请求授权");
                        // 不需要解释为何需要该权限，直接请求授权
                        ActivityCompat.requestPermissions(CallMessageActivity.this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
                    }
                }else {
                    Log.i("CallMessageActivity","直接发送  " );
                    // 已经获得授权，可以发短信
                    SendSms();
                }
            }
        });

    }

    private void SendSms() {
        // 获取数据内容
        String number = et_messagenumber.getText().toString();
        String content = et_messagecontent.getText().toString();
        // 为空判断
        if (TextUtils.isEmpty(number)||TextUtils.isEmpty(content)) {
            // 提醒用户
            Toast.makeText(this, "号码或内容不能为空！", Toast.LENGTH_SHORT).show();
        } else {
            // 使用SmsManager类
            SmsManager smsManager = SmsManager.getDefault();
            // 短信内容可能很长，需要分发
            ArrayList<String> parts = smsManager.divideMessage(content);
            // 发送短信，需要权限
//          smsManager.sendMultipartTextMessage(number, null, parts, null, null);
            for(String text : parts) {
                smsManager.sendTextMessage(number, null, text, null, null);
            }
            // 发送完成后弹窗提示
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("已发送！")
                    .setNegativeButton("好！", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 关闭当前弹窗
                            dialog.dismiss();
                        }
                    });
            AlertDialog dialog = builder.show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 授权成功，继续发短信
                    SendSms();
                } else {
                    // 授权失败！
                    Toast.makeText(this, "授权失败！", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }

    }

}
