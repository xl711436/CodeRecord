package com.example.myapplication2.SubMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.BaseControl.ButtonActivity;
import com.example.myapplication2.BaseControl.CheckBoxActivity;
import com.example.myapplication2.BaseControl.EditTextActivity;
import com.example.myapplication2.BaseControl.ImageviewActivity;
import com.example.myapplication2.BaseControl.RadioButtonActivity;
import com.example.myapplication2.BaseControl.TextViewActivity;
import com.example.myapplication2.BaseControl.WebViewActivity;
import com.example.myapplication2.R;

public class BaseControlActivity extends AppCompatActivity {


    private Button btn_textview;
    private Button btn_button;
    private Button btn_edittext;
    private Button btn_radiobutton;
    private Button btn_checkbox;
    private Button btn_imageview;
    private Button  btn_webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_control);


        btn_textview = (Button)findViewById(R.id.btn_textview);
        btn_button = (Button)findViewById(R.id.btn_button);
        btn_edittext = (Button)findViewById(R.id.btn_edittext);
        btn_radiobutton = (Button)findViewById(R.id.btn_radiobutton);
        btn_checkbox = (Button)findViewById(R.id.btn_checkbox);
        btn_imageview = (Button)findViewById(R.id.btn_imageview);
        btn_webview = (Button)findViewById(R.id.btn_webview);

        btn_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseControlActivity.this, TextViewActivity.class);
                startActivity(intent);
            }
        });

        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(BaseControlActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });

        btn_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(BaseControlActivity.this, EditTextActivity.class);
                startActivity(intent);
            }
        });

        btn_radiobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(BaseControlActivity.this, RadioButtonActivity.class);
                startActivity(intent);
            }
        });

        btn_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(BaseControlActivity.this, CheckBoxActivity.class);
                startActivity(intent);
            }
        });

        btn_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(BaseControlActivity.this, ImageviewActivity.class);
                startActivity(intent);
            }
        });

        btn_webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent   intent = new Intent(BaseControlActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });









    }
}
