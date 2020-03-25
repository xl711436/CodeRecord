package com.example.myapplication2.ContentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication2.datastorage.DatabaseHelper;

public class TestContentProvider extends ContentProvider {

    private  static UriMatcher sUriMatcher;
    private static final int URI_MATCH_USER = 1;

    private DatabaseHelper curHelper;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(URIList.AUTHORITY, DatabaseHelper.USER_TABLE_NAME,URI_MATCH_USER);
    }
    @Override
    public boolean onCreate() {
        curHelper = new DatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String tableName = getTableName(uri);
        Cursor cursor =   curHelper.getReadableDatabase().query(tableName,projection,selection,selectionArgs,null,null,sortOrder);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    private String getTableName(Uri uri)
    {
        int type = sUriMatcher.match(uri);
        String tableName ="";
        switch (type)
        {
            case URI_MATCH_USER:
                tableName = DatabaseHelper.USER_TABLE_NAME;
                break;
            default:
            {
                break;
            }
        }
        return tableName;
    }
}
