package pe.gob.inei.cuestionarioena.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pe.gob.inei.cuestionarioena.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class E3P1Fragment extends Fragment {


    public E3P1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_e3_p1, container, false);
    }

}
