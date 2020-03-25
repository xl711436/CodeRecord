package com.example.myapplication2.Network;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.ContentProvider.ContentProvideActivity;
import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkActivity extends AppCompatActivity {

    private Button btn_request,btn_download;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        btn_request = (Button)findViewById(R.id.btn_request);
        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NetworkActivity.this, RequestActivity.class);
                startActivity(intent);
            }
        });

        btn_download = (Button)findViewById(R.id.btn_download);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       String localPath = getFilesDir() + File.separator + "mm.txt";
                        //    String localPath = File.separator +"storage" + File.separator +"emulated" + File.separator + "0" + File.separator + "mm.txt";
                        Log.i("localPath",localPath);
                        download("http://192.168.11.130:8070/bb.txt",localPath);
                    }
                }).start();



            }
        });

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo  = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifi =  networkInfo.isConnected();
        Log.i ("NetworkActivity","isWifi" + String.valueOf(isWifi));

        NetworkInfo networkInfo1  = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobile =  networkInfo1.isConnected();

        Log.i ("NetworkActivity","isMobile" + String.valueOf(isMobile));
        NetworkInfo networkInfo2 = connectivityManager.getActiveNetworkInfo();
        boolean isConnect = networkInfo2.isConnected();



        Log.i ("NetworkActivity","isConnect" + String.valueOf(isConnect));




    }

    private void download(String urlPath,String localPath)
    {
        URL url;
        try {
              url= new URL(urlPath);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            int contentLength = urlConnection.getContentLength();
            Log.i("","contentLength" + contentLength);

            File curFile = new File(localPath);

            File curFolder = curFile.getParentFile();
            if(!curFolder.exists())
            {
                curFolder.mkdir();
            }

            if(curFile.exists())
            {
                curFile.delete();
            }

            int downloadSize = 0;
            byte[] bytes = new byte[1024];
            int length = 0;
            OutputStream outputStream = new FileOutputStream(localPath);
            while((length = inputStream.read(bytes)) != -1)
            {
                outputStream.write(bytes,0,length);
                downloadSize += length;
                int progress = downloadSize * 100 / contentLength;

                Log.i("下载","progress " + progress);
            }

            Log.i("下载","downlaod success ");

            inputStream.close();
            outputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
