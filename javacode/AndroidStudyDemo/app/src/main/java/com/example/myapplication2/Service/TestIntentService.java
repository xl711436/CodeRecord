package com.example.myapplication2.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

// 在 onHandleIntent 方法中后台执行 任务， 执行完后自动结束，可以多次启动
public class TestIntentService extends IntentService {

    public TestIntentService() {
        super("TestIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService(String name) {
        super(name);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        Log.i("TestIntentService","onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        Log.i("TestIntentService","onStart");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("TestIntentService","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String action = intent.getExtras().getString("param");
        Log.i("TestIntentService","onHandleIntent  " + action);
    }
}
