package com.example.myapplication2.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication2.R;


public class MusicService extends Service {

    public MediaPlayer mediaPlayer;
    private IBinder iBinder = new LocalBinder();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MusicService","onCreate");

        mediaPlayer = MediaPlayer.create(this, R.raw.aa);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        Log.i("MusicService","onStartCommand");
        return START_NOT_STICKY;// super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
        Log.i("MusicService","onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MusicService","onBind");
        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.i("MusicService","onUnbind");
        return super.onUnbind(intent);
    }

    public class LocalBinder extends Binder{
        MusicService getService(){
            return  MusicService.this;
        }
    }
}
