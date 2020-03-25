package com.example.myapplication2.BaseControl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.R;

public class ToastActivity extends AppCompatActivity {

    private Button btn_toast_1,btn_toast_2,btn_toast_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btn_toast_1 = (Button)findViewById(R.id.btn_toast_1);
        btn_toast_2 = (Button)findViewById(R.id.btn_toast_2);
        btn_toast_3 = (Button)findViewById(R.id.btn_toast_3);

        btn_toast_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"默认Toast",Toast.LENGTH_SHORT).show();
            }
        });

        btn_toast_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast curToast = Toast.makeText(getApplicationContext(),"默认Toast",Toast.LENGTH_SHORT);

                curToast.setGravity(Gravity.CENTER,0,0);
                curToast.show();
            }
        });

        btn_toast_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast cuToast = new Toast(getApplicationContext());
                LayoutInflater inflater  = LayoutInflater.from((ToastActivity.this));
                View view = inflater.inflate(R.layout.layout_toast,null);
                ImageView imageView = (ImageView)view.findViewById(R.id.iv_toast);
                TextView textView = (TextView)view.findViewById(R.id.tv_toast);
                imageView.setImageResource(R.drawable.image1);
                textView.setText("自定义");
                cuToast.setDuration(Toast.LENGTH_LONG);
                cuToast.setView(view);
                //多个show时，只会显示1次，但是时间会延长
                cuToast.show();
                cuToast.show();
                cuToast.show();
            }
        });
    }
}
