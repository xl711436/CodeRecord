package com.example.myapplication2.Dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.R;

public class PopupWindowActivity extends AppCompatActivity {

    private Button btn_pop;
    private PopupWindow curPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        btn_pop = (Button)findViewById(R.id.btn_pop);
        btn_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View curView = getLayoutInflater().inflate(R.layout.layout_pop,null);

              final    TextView curText = curView.findViewById(R.id.pop_tv_ok);
                curText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(PopupWindowActivity.this,curText.getText(),Toast.LENGTH_SHORT).show();
                    }
                });


                curPop = new PopupWindow(curView,btn_pop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                curPop.setOutsideTouchable(true);
                curPop.setFocusable(true);
                curPop.showAsDropDown(btn_pop);
            }
        });
    }
}
