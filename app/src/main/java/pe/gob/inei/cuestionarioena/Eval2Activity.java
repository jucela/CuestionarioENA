package pe.gob.inei.cuestionarioena;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import pe.gob.inei.cuestionarioena.fragments.E2P1Fragment;
import pe.gob.inei.cuestionarioena.fragments.E2P2Fragment;
import pe.gob.inei.cuestionarioena.fragments.E2P3Fragment;

/**
 * Created by otin040 on 13/07/2017.
 */

public class Eval2Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private E2P1Fragment E2P1Fragment;
    private E2P2Fragment E2P2Fragment;
    private E2P3Fragment E2P3Fragment;
    private Button btnAnterior;
    private Button btnSiguiente;
    private int fragmentActual = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eval02);

        mostrarBarra("SEGUNDA EVALUACION", true);

        btnAnterior = (Button) findViewById(R.id.btnAnterior_eval2);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente_eval2);
        E2P1Fragment = new E2P1Fragment();
        E2P2Fragment = new E2P2Fragment();
        E2P3Fragment = new E2P3Fragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,E2P1Fragment);
        fragmentTransaction.commit();



        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentActual){
                    case 0:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E2P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnAnterior.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E2P3Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnSiguiente.setText("FINALIZAR");
                        break;
                    case 2:
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
                        fragmentTransaction.replace(R.id.container,E2P1Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnAnterior.setVisibility(View.GONE);
                        break;
                    case 2:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E2P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnSiguiente.setText("SIGUIENTE");
                        break;
                }
            }
        });

    }

    public void mostrarBarra(String titulo, boolean flecha){
        toolbar = (Toolbar) findViewById(R.id.toolbar_eval2);
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
