package com.example.myapplication2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication2.R;

public class AFragment extends Fragment {


    private TextView fr_tv_a;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fr_tv_a = view.findViewById(R.id.fr_tv_a);
      Bundle curBundle =   getArguments();
      if(curBundle !=null)
      {
          fr_tv_a.setText(curBundle.getString("key1"));
      }

    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        Log.i("AFragment","onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("AFragment","onDetach");
    }
}
