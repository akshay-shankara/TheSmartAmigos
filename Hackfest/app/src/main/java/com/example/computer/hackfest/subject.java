package com.example.computer.hackfest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class subject extends Fragment {
    View myView;
    Button phy,civ,math,mech;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.subjects, container, false);

        phy = (Button) myView.findViewById(R.id.buttonPHY);
        civ = (Button) myView.findViewById(R.id.buttonCIV);
        math = (Button) myView.findViewById(R.id.buttonMAT);
        mech = (Button) myView.findViewById(R.id.buttonMECH);

        phy.setOnClickListener(myListener);
        civ.setOnClickListener(myListener);
        math.setOnClickListener(myListener);
        mech.setOnClickListener(myListener);

        return myView;
    }
    View.OnClickListener myListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            int i = v.getId();
            Fragment frag = new unit();
            FragmentManager fm = getFragmentManager();
            switch(i){
                case R.id.buttonPHY: fm.beginTransaction().replace(R.id.container,frag).commit();
                                     break;
            }
        }
    };

}
