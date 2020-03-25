package com.example.myapplication2.ContentProvider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;
import com.example.myapplication2.SubMenu.BaseControlActivity;
import com.example.myapplication2.datastorage.DatabaseHelper;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

public class ContentProvideActivity extends AppCompatActivity {

    private Button btn_contract;
    private Button btn_message;
    private Button btn_custom;
    private Button btn_app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provide);

        btn_contract = (Button)findViewById(R.id.btn_contract);
        btn_message = (Button)findViewById(R.id.btn_message);
        btn_custom = (Button)findViewById(R.id.btn_custom);
        btn_app= (Button)findViewById(R.id.btn_app);



        btn_contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = null;
                try {

                    cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            String displayName = cursor.getString(cursor.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                            String number = cursor.getString(cursor.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER));
                            Log.i("ContentProvideActivity" , displayName + "\n" + number);
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }


            }
        });

        btn_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm = getPackageManager();
                List<PackageInfo> installedPackages = pm.getInstalledPackages(0);  // 获取所以已安装的包


                for (PackageInfo packageInfo : installedPackages) {

                    String packageName = packageInfo.packageName;  // 包名
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;  // 应用信息
                    String name = applicationInfo.loadLabel(pm).toString();  // 应用名称

                    Log.i("packageName   ",packageName);
                    Log.i("name   ",name);
                }


            }
        });

        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btn_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cursor cursor = null;
                try {

                    cursor = getContentResolver().query(Uri.parse(URIList.USER_URI),null,null,null,null,null);

                    if (cursor != null&&   cursor.moveToFirst())
                     {
                        int count = cursor.getCount();
                        Log.i("btn_custom"  ,"count" + String.valueOf(count));
                        for(int i = 0; i < count; i++)
                        {
                            String curName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.USERNAME));
                            cursor.moveToNext();
                            Log.i("btn_custom" + i,curName);
                        }

                    }



                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }


            }
        });

    }
}
