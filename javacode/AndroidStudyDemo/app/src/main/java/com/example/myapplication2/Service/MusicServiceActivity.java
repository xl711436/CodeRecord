package com.example.myapplication2.Service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;

public class MusicServiceActivity extends AppCompatActivity {

    private Button btn_start,btn_stop,btn_notify,btn_notify2;
    private ServiceConnection serviceConnection = new ServiceConnection() {

        private MusicService curMusicService ;

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.LocalBinder localBinder = (MusicService.LocalBinder)service;
            curMusicService= localBinder.getService();
            Log.i("MusicService","onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("MusicService","onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btn_start = (Button)findViewById(R.id.btn_start);
        btn_stop = (Button)findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startService(new Intent(MusicServiceActivity.this,MusicService.class));
                bindService(new Intent(MusicServiceActivity.this,MusicService.class),serviceConnection,BIND_AUTO_CREATE);

                Intent firstIntent = new Intent(MusicServiceActivity.this,TestIntentService.class);
                Bundle firstBundle = new Bundle();
                firstBundle.putString("param", "oper1");
                firstIntent.putExtras(firstBundle);

                Intent secondIntent = new Intent(MusicServiceActivity.this,TestIntentService.class);
                Bundle secondBundle = new Bundle();
                secondBundle.putString("param", "oper2");
                secondIntent.putExtras(secondBundle);
                startService(firstIntent);
                startService(secondIntent);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            unbindService(serviceConnection);
            stopService(new Intent(MusicServiceActivity.this,MusicService.class));

                stopService(new Intent(MusicServiceActivity.this,TestIntentService.class));
            }
        });

        btn_notify= (Button)findViewById(R.id.btn_notify);
        btn_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "my_package_channel";//渠道名字
                String id = "my_package_channel_1"; // 渠道ID
                String description = "my_package_first_channel"; // 渠道解释说明
                PendingIntent pendingIntent;//非紧急意图，可设置可不设置

                NotificationCompat.Builder notificationBuilder = null;
                Intent intent = null;

                NotificationManager notificationManager =  (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);




                //判断是否是8.0上设备
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = null;
                    if (mChannel == null) {
                        mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_LOW);
                        mChannel.setDescription(description);
                        mChannel.enableLights(true); //是否在桌面icon右上角展示小红点
                        notificationManager.createNotificationChannel(mChannel);
                    }
                    notificationBuilder = new NotificationCompat.Builder(MusicServiceActivity.this);

                    RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.layout_notification);
                    remoteViews.setImageViewResource(R.id.image, R.drawable.bg_girl);
                    remoteViews.setTextViewText(R.id.title, "我是标题");
                    remoteViews.setTextViewText(R.id.content, "我是内容");

                    intent = new Intent(MusicServiceActivity.this, NotificationActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    pendingIntent = PendingIntent.getActivity(MusicServiceActivity.this, 0, intent, 0);

                    notificationBuilder.
                            setSmallIcon(R.drawable.ic_launcher_foreground)
                            .setContentTitle("我是标题")
                            .setContentText("我是内容")
                            .setContentIntent(pendingIntent)
                            .setChannelId(id)
                            .setContent(remoteViews)
                            .setAutoCancel(true);
                }else{
                    notificationBuilder = new NotificationCompat.Builder(MusicServiceActivity.this)
                            .setSmallIcon(R.drawable.bg_btn2)
                            .setContentTitle("我是标题")
                            .setContentText("我是内容")
                   .setWhen(System.currentTimeMillis())
                            .setAutoCancel(true);
                }

                notificationManager.notify(100, notificationBuilder.build());
            }
        });

        btn_notify2= (Button)findViewById(R.id.btn_notify2);
        btn_notify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                String channeId = "1";
                String channelName = "default";
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(channeId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
                    channel.enableLights(true);         // 开启指示灯，如果设备有的话
                    channel.setLightColor(Color.RED);   // 设置指示灯颜色
                    channel.setShowBadge(true);         // 检测是否显示角标
                    notificationManager.createNotificationChannel(channel);
                }
                //2.构建通知类
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MusicServiceActivity.this, "1");
                builder.setSmallIcon(R.mipmap.ic_launcher);//设置小图标
                builder.setContentTitle("微信");//标题
                builder.setContentText("您有一条未读消息!");//内容
                builder.setWhen(System.currentTimeMillis());    //时间

                //3.获取通知
                Notification notification = builder.build();

                //4.发送通知
                notificationManager.notify(100, notification);
            }
        });
    }
}
