package com.example.computer.hackfest;


import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;


public class Discussion extends Fragment{
    View myView;
    @Nullable
    @Override
   public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.first_layout,container,false);
       return myView;
   }
}
