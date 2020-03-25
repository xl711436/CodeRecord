package com.example.myapplication2.BaseControl;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

import com.example.myapplication2.R;

public class ImageviewActivity extends AppCompatActivity {

    private ImageView Iv_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        Iv_2 = (ImageView) findViewById(R.id.Iv_2);

        Glide.with(this).load("https://img.expreview.com/news/2020/02/08/image-20200208222646399.png").into(Iv_2);
    }

}
