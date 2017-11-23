package pe.gob.inei.cuestionarioena;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import pe.gob.inei.cuestionarioena.fragments.E1P1Fragment;
import pe.gob.inei.cuestionarioena.fragments.E1P2Fragment;
import pe.gob.inei.cuestionarioena.fragments.E1P3Fragment;
import pe.gob.inei.cuestionarioena.fragments.E1P4Fragment;

/**
 * Created by otin040 on 13/07/2017.
 */

public class Eval1Activity extends AppCompatActivity {



    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private E1P1Fragment E1P1Fragment;
    private E1P2Fragment E1P2Fragment;
    private E1P3Fragment E1P3Fragment;
    private E1P4Fragment E1P4Fragment;

    private Button btnAnterior;
    private Button btnSiguiente;
    private int fragmentActual = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eval01);

        mostrarBarra("PRIMERA EVALUACION", true);


        btnAnterior = (Button) findViewById(R.id.btnAnterior_eval1);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente_eval1);
        E1P1Fragment = new E1P1Fragment();
        E1P2Fragment = new E1P2Fragment();
        E1P3Fragment = new E1P3Fragment();
        E1P4Fragment = new E1P4Fragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,E1P1Fragment);
        fragmentTransaction.commit();




        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentActual){
                    case 0:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E1P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnAnterior.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E1P3Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        break;
                    case 2:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E1P4Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnSiguiente.setText("FINALIZAR");
                        break;
                    case 3:
                        guardarYVolver();
                        break;
                }
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentActual){
                    case 1:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E1P1Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnAnterior.setVisibility(View.GONE);
                        break;
                    case 2:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E1P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        break;
                    case 3:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E1P3Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnSiguiente.setText("SIGUIENTE");
                        break;
                }
            }
        });

    }

    public void mostrarBarra(String titulo, boolean flecha){
        toolbar = (Toolbar) findViewById(R.id.toolbar_eval1);
        setSupportActionBar(toolbar);
        toolbar.setTitle(titulo);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(flecha);
    }
    public void guardarYVolver(){
        //aqui ira funcion para guardar datos
        onBackPressed();
    }
}
