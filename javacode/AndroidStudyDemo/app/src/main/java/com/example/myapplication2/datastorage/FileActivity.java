package com.example.myapplication2.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication2.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileActivity extends AppCompatActivity {

    private EditText et_name;
    private Button btn_save,btn_show;
    private TextView tv_show;
    private ImageView Iv_load,Iv_load1;

    private String mFileName = "bb.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        et_name = (EditText) findViewById(R.id.et_name);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_show = (Button) findViewById(R.id.btn_show);
        tv_show = (TextView) findViewById(R.id.tv_show);

        Iv_load = (ImageView) findViewById(R.id.Iv_load);
        Iv_load1 = (ImageView) findViewById(R.id.Iv_load1);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(et_name.getText().toString());
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_show.setText(read());
            }
        });

        File curFile = new File(getFilesDir(), "cc.txt");

        Log.i("FileActivity", "getFileDir:" + getFilesDir().getAbsolutePath() + "");
        Log.i("FileActivity", "file path:" + curFile.getAbsolutePath() + "");

        String state = Environment.getExternalStorageState();
        Log.i("FileActivity", state);

        //扫描目录
        String[] fileNames = null;
        try {
            fileNames = getAssets().list("imageaa/");
            for (int i = 0; i < fileNames.length; i++) {
                Log.i("FileActivity", fileNames[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //加载图片
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("imageaa/020.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            Iv_load.setImageBitmap(bitmap);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取音乐
        AssetFileDescriptor assetFileDescriptor;
        try {
            assetFileDescriptor = getAssets().openFd("musicaa/a1ah.mp3");
            MediaPlayer player = new MediaPlayer();
            player.reset();
            player.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取res目录下raw目录的文件


        InputStream rawInputStream = getResources().openRawResource(R.raw.image16);
        Bitmap bitmap = BitmapFactory.decodeStream(rawInputStream);
        Iv_load1.setImageBitmap(bitmap);


    }

    private void save(String content)
    {
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if(fileOutputStream != null)
            {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String read()
    {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buff))> 0)
            {
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;

    }
}
