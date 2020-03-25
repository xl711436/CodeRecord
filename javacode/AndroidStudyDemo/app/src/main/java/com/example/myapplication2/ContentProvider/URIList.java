package com.example.myapplication2.ContentProvider;

import com.example.myapplication2.datastorage.DatabaseHelper;

public class URIList {
    public static   final  String CONTENT = "content://";
    public static final String AUTHORITY = "com.example.myapplication2";

    public  static final    String USER_URI = CONTENT + AUTHORITY + "/" + DatabaseHelper.USER_TABLE_NAME;

}
