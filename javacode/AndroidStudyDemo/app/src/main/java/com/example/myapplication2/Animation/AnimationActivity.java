package com.example.myapplication2.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;

public class AnimationActivity extends AppCompatActivity {

    private Button btn_objectanimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        btn_objectanimation = (Button)findViewById(R.id.btn_objectanimation);

        btn_objectanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(AnimationActivity.this, ObjectAnimationActivity.class);
                startActivity(intent);
            }
        });



    }
}
