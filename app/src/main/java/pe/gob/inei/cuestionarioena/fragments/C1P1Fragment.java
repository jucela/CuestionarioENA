package pe.gob.inei.cuestionarioena.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.database.sqlite.SQLiteDatabase;

import pe.gob.inei.cuestionarioena.AtributosPreg;
import pe.gob.inei.cuestionarioena.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class C1P1Fragment extends Fragment {

    private RadioButton r1,r2,r3,r4,r5;

    public C1P1Fragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_c1_p1, container, false);

        r1 = (RadioButton) view.findViewById(R.id.r1);
        r2 = (RadioButton) view.findViewById(R.id.r2);
        r3 = (RadioButton) view.findViewById(R.id.r3);
        r4 = (RadioButton) view.findViewById(R.id.r4);
        r5 = (RadioButton) view.findViewById(R.id.r5);



        return view;
    }



    public void setear(AtributosPreg a)
    {
        if(r1.isChecked() == true)
            a.setC1_p1_1("1");
        else if(r2.isChecked() == true)
            a.setC1_p1_1("2");
        else if(r3.isChecked() == true)
            a.setC1_p1_1("3");
        else if(r4.isChecked() == true)
            a.setC1_p1_1("4");
        else if(r5.isChecked() == true)
            a.setC1_p1_1("5");
    }

    public void getear(AtributosPreg a)
    {
        if(a.getC1_p1_1() == "1")
            r1.setChecked(true);
        else if(a.getC1_p1_1() == "2")
            r2.setChecked(true);
        else if(a.getC1_p1_1() == "3")
            r3.setChecked(true);
        else if(a.getC1_p1_1() == "4")
            r4.setChecked(true);
        else if(a.getC1_p1_1() == "5")
            r5.setChecked(true);

    }



}
