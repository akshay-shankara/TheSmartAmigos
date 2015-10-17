package com.example.computer.hackfest;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;

public class Notes_Fragment extends Fragment {
    View myView;
    Button sem1, sem2, cs, ec, is, civ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.notes, container, false);

        sem1 = (Button) myView.findViewById(R.id.buttonSem1);
        sem2 = (Button) myView.findViewById(R.id.buttonSem2);
        ec = (Button) myView.findViewById(R.id.buttonEC);
        cs = (Button) myView.findViewById(R.id.buttonCS);
        is = (Button) myView.findViewById(R.id.buttonIS);
        civ = (Button) myView.findViewById(R.id.buttonCIV);

        sem1.setOnClickListener(listener);
        sem2.setOnClickListener(listener);
        ec.setOnClickListener(listener);
        cs.setOnClickListener(listener);
        is.setOnClickListener(listener);
        civ.setOnClickListener(listener);
        return myView;
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = v.getId();
            Fragment frag = new subject();
            FragmentManager fm = getFragmentManager();
            switch(i){
                case R.id.buttonSem1: fm.beginTransaction().replace(R.id.container,frag).commit();
                                        break;

            }
        }
    };


}
