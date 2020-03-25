package com.example.myapplication2.Network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication2.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class RequestActivity extends AppCompatActivity {

    private TextView tv_content;

    private Button btn_getdata;

    private EditText ev_url;




    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        tv_content = (TextView)findViewById(R.id.tv_content);
        btn_getdata = (Button)findViewById(R.id.btn_getdata);
        ev_url = (EditText)findViewById(R.id.ev_url);


        btn_getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String requestUrl = ev_url.getText().toString();
                new RequestNetworkDataTask().execute(requestUrl);

            }
        });

    }

    private String requestData(String urlString)
    {
        String R_Result = "";
        try {
            URL url = new URL(urlString);
            try {
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setConnectTimeout(30* 1000);
                connection.setRequestMethod("GET");
                connection.connect();

                int responseCode = connection.getResponseCode();
                String responseMessage = connection.getResponseMessage();

                InputStream inputStream = connection.getInputStream();

                Reader reader = new InputStreamReader(inputStream,"UTF-8");
                char[] buffer = new char[1024];
                reader.read(buffer);
                R_Result = new String(buffer);

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return R_Result;
    }


    public static String SendGet(String I_Url, String I_Param) {
        String R_Result = "";
        BufferedReader in = null;
        try {
            String urlNameString = I_Url + "?" + I_Param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent" , "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();


            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(  connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                R_Result += line;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return R_Result;
    }


    class RequestNetworkDataTask extends   AsyncTask<String,Integer,String>
   {

       @Override
       protected String doInBackground(String... strings) {
           String result = SendGet(strings[0],"");
           return result;
       }

       @Override
       protected void onPostExecute(String s) {
           super.onPostExecute(s);
           tv_content.setText(s);
       }
   }
}
