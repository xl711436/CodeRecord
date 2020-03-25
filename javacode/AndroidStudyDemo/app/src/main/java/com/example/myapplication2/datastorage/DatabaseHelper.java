package com.example.myapplication2.datastorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE_NAME = "user";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String DBNAME = "test.db";
    public static final String CLASSNAME = "DatabaseHelper";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DatabaseHelper.DBNAME, null, 1);
        Log.i(DatabaseHelper.CLASSNAME,"init");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(username varchar(20) not null, password varchar(60) not null);");
        Log.i(DatabaseHelper.CLASSNAME,"onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(DatabaseHelper.CLASSNAME,"onUpgrade");
    }
}
