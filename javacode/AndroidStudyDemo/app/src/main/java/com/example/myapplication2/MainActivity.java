package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.myapplication2.BroadcastReceiver.BroadcastMainActivity;
import com.example.myapplication2.CallMessage.CallMessageActivity;
import com.example.myapplication2.ContentProvider.ContentProvideActivity;
import com.example.myapplication2.Network.NetworkActivity;
import com.example.myapplication2.Service.MusicServiceActivity;
import com.example.myapplication2.Animation.AnimationActivity;
import com.example.myapplication2.BroadcastReceiver.CustomeBroadActivity;
import com.example.myapplication2.SubMenu.BaseControlActivity;
import com.example.myapplication2.SubMenu.DialogActivity;
import com.example.myapplication2.SubMenu.ListActivity;
import com.example.myapplication2.datastorage.DataStorageActivity;
import com.example.myapplication2.Thread.HandlerActivity;
import com.example.myapplication2.fragment.ContainerActivity;
import com.example.myapplication2.jump.AActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Button btn_basecontrol,btn_list,btn_dialog;


    private Button btn_jump;
    private Button btn_fragment;

    private Button btn_handler;

    private Button btn_datastorage;
    private Button btn_broadcast;
    private Button btn_animation;


    private Button  btn_service;
    private Button  btn_contentprovide;
    private Button btn_network;
    private Button btn_callmessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_basecontrol = (Button)findViewById(R.id.btn_basecontrol);
        btn_list = (Button)findViewById(R.id.btn_list);
        btn_dialog = (Button)findViewById(R.id.btn_dialog);

        btn_basecontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent   intent = new Intent(MainActivity.this, BaseControlActivity.class);
                startActivity(intent);
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });




         btn_jump= (Button)findViewById(R.id.btn_jump);
        btn_fragment= (Button)findViewById(R.id.btn_fragment);
        btn_handler= (Button)findViewById(R.id.btn_handler);
        btn_datastorage= (Button)findViewById(R.id.btn_datastorage);
        btn_broadcast= (Button)findViewById(R.id.btn_broadcast);
        btn_animation= (Button)findViewById(R.id.btn_animation);

        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, ContainerActivity.class);
                startActivity(intent);
            }
        });

        btn_handler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

        btn_datastorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, DataStorageActivity.class);
                startActivity(intent);
            }
        });

        btn_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, BroadcastMainActivity.class);
                startActivity(intent);
            }
        });

        btn_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });



        btn_service= (Button)findViewById(R.id.btn_service);

        btn_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, MusicServiceActivity.class);
                startActivity(intent);
            }
        });

        btn_contentprovide = (Button)findViewById(R.id.btn_contentprovide);
        btn_contentprovide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, ContentProvideActivity.class);
                startActivity(intent);
            }
        });

        btn_network = (Button)findViewById(R.id.btn_network);
        btn_network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
            }
        });

        btn_callmessage = (Button)findViewById(R.id.btn_callmessage);
        btn_callmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(MainActivity.this, CallMessageActivity.class);
                startActivity(intent);
            }
        });


        File curFile =  Environment.getExternalStorageDirectory();
        Log.i("内存存储目录",curFile.getPath());
        File   curFile1 =Environment.getRootDirectory();
        Log.i("根目录",curFile1.getPath());
    }



}
