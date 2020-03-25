package com.example.myapplication2.BaseControl;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication2.R;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTv3;
    private TextView mTv4;
    private TextView mTv5;
    private TextView mTv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        mTv3 = (TextView) findViewById(R.id.tv_3);
        mTv3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        mTv3.getPaint().setAntiAlias(true);

        mTv4 = (TextView) findViewById(R.id.tv_4);
        mTv4.setText(Html.fromHtml("<u>得分444<u>"));

        mTv5 = (TextView) findViewById(R.id.tv_5);
        String cd =  String.valueOf(mTv5.isFocused());
        Log.i(cd,cd);
        mTv5.requestFocus();
          cd =  String.valueOf(mTv5.isFocused());
        Log.i(cd,cd);

    }

}
