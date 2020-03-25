package com.example.myapplication2.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.R;

public class SqliteActivity extends AppCompatActivity {

    private Button btn_add,btn_delete,btn_select,btn_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        Log.i("SqliteActivity","onCreate");

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_select = (Button) findViewById(R.id.btn_select);
        btn_update = (Button) findViewById(R.id.btn_update);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(SqliteActivity.this);
                SQLiteDatabase cuDb = databaseHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.USERNAME ,"11");
                contentValues.put(DatabaseHelper.PASSWORD,"22");

               long result =  cuDb.insert("user",null,contentValues);
                Log.i("insert",String.valueOf(result));
                cuDb.execSQL("insert into user (" + DatabaseHelper.USERNAME  + "," + DatabaseHelper.PASSWORD + ") values('22','44')");

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(SqliteActivity.this);
                SQLiteDatabase cuDb = databaseHelper.getWritableDatabase();

                String whereStr = DatabaseHelper.USERNAME +"=?";
                String[] whereArgs = {"33"};
                long result = cuDb.delete("user",whereStr,whereArgs);
                Log.i("delete",String.valueOf(result));
            }
        });

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper databaseHelper = new DatabaseHelper(SqliteActivity.this);
                SQLiteDatabase cuDb = databaseHelper.getWritableDatabase();

                Cursor cursor = cuDb.query(DatabaseHelper.USER_TABLE_NAME,null,null,null,null,null,null);

                if(cursor.moveToFirst())
                {
                    int count = cursor.getCount();
                    Log.i("SqliteActivity"  ,"count" + String.valueOf(count));
                    for(int i = 0; i < count; i++)
                    {
                        String curName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.USERNAME));
                        cursor.moveToNext();
                        Log.i("SqliteActivity" + i,curName);
                    }
                }
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(SqliteActivity.this);
                SQLiteDatabase cuDb = databaseHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.USERNAME,"33");
                String whereStr = DatabaseHelper.USERNAME +"=?";
                String[] whereArgs = {"11"};
                long result =    cuDb.update(DatabaseHelper.USER_TABLE_NAME,contentValues,whereStr,whereArgs);
                Log.i("update",String.valueOf(result));
            }
        });

    }
}
