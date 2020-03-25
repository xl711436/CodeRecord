package com.example.myapplication2.Animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication2.R;

public class ObjectAnimationActivity extends AppCompatActivity {

    private TextView  tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation);

        tv_test =findViewById(R.id.tv_test);

      //  tv_test.animate().translationY(500).setDuration(2000).start();


        /*
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i'i("aaa",animation.getAnimatedValue() + "");
                Log.("aaa",animation.getAnimatedFraction() + "");
            }
        });
        */

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv_test,"translationY",0,500,1000,300,700,200);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}
