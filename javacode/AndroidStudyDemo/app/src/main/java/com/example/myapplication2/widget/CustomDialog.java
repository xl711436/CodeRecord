package com.example.myapplication2.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication2.R;

import org.w3c.dom.Text;

public class CustomDialog extends Dialog {

    private TextView cd_tv_title,cd_tv_content,cd_tv_cancel,cd_tv_confirm;
    private String str_title,str_content,str_cancel,str_confirm;

    private ICustomDialogOnClick cancelClick,confirmClick;

    public CustomDialog setStr_tv_title(String str_tv_title) {
        str_title =str_tv_title;
        return this;
    }

    public CustomDialog setStr_tv_content(String str_tv_content) {
        str_content = str_tv_content;
        return this;
    }

    public CustomDialog setStr_tv_cancel(String str_tv_cancel,ICustomDialogOnClick cancelClick) {
        str_cancel=str_tv_cancel;
        this.cancelClick = cancelClick;
        return this;
    }

    public CustomDialog setStr_tv_confirm(String str_tv_confirm , ICustomDialogOnClick confirmClick) {
        str_confirm = str_tv_confirm;
        this.confirmClick = confirmClick;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        cd_tv_title = (TextView) findViewById(R.id.cd_tv_title);
        cd_tv_content = (TextView) findViewById(R.id.cd_tv_content);
        cd_tv_cancel = (TextView) findViewById(R.id.cd_tv_cancel);
        cd_tv_confirm = (TextView) findViewById(R.id.cd_tv_confirm);
        if(!TextUtils.isEmpty(str_title))
        {
            cd_tv_title.setText(str_title) ;
        }

        if(!TextUtils.isEmpty(str_content))
        {
            cd_tv_content.setText(str_content) ;
        }

        if(!TextUtils.isEmpty(str_cancel))
        {
            cd_tv_cancel.setText(str_cancel) ;
        }

        if(!TextUtils.isEmpty(str_confirm))
        {
            cd_tv_confirm.setText(str_confirm) ;
        }

        CustomOnClickListener curListener = new CustomOnClickListener(this);

        cd_tv_cancel.setOnClickListener(curListener);
        cd_tv_confirm.setOnClickListener(curListener);
    }



    public interface ICustomDialogOnClick {
        void OnClick(CustomDialog dialog);
    }

    public class  CustomOnClickListener  implements View.OnClickListener
    {
        private CustomDialog curDialog;
        public CustomOnClickListener(CustomDialog dialog)
        {
            curDialog = dialog;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.cd_tv_confirm:
                {
                    if(confirmClick != null)
                    {
                        confirmClick.OnClick(curDialog);
                    }
                    break;
                }
                case R.id.cd_tv_cancel:
                {
                    if(cancelClick != null)
                    {
                        cancelClick.OnClick(curDialog);
                    }
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
    }
}
