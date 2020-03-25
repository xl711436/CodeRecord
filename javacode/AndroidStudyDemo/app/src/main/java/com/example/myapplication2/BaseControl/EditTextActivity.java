package com.example.myapplication2.BaseControl;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication2.R;

public class EditTextActivity extends AppCompatActivity {

    private EditText et_1;
    private Button btn_submit1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        et_1 = (EditText)findViewById(R.id.et_1);
        et_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Log.i("edit",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_submit1= (Button)findViewById(R.id.btn_submit1);
        btn_submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
