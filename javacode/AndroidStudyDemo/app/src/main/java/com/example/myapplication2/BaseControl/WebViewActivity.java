package com.example.myapplication2.BaseControl;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication2.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView wv_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wv_1 = (WebView) findViewById(R.id.wv_1);

        //加载本地url
      //  wv_1.loadUrl("file:///android_asset/test.html");

        wv_1.getSettings().setJavaScriptEnabled(true);
        wv_1.setWebViewClient(new MyWebViewwClient());
        wv_1.setWebChromeClient(new MyWebChromeClient());
        wv_1.loadUrl("https://m.baidu.com");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && wv_1.canGoBack())
        {
            wv_1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    class MyWebViewwClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.i("" , "start" + url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.i("" ,"finish" + url);
            wv_1.loadUrl("javascript:alert('hello')");
        }
    }

    class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }
}
