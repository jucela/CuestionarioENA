package pe.gob.inei.cuestionarioena;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import pe.gob.inei.cuestionarioena.fragments.E4P1Fragment;
import pe.gob.inei.cuestionarioena.fragments.E4P2Fragment;
import pe.gob.inei.cuestionarioena.fragments.E4P3Fragment;

public class Eval4Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private pe.gob.inei.cuestionarioena.fragments.E4P1Fragment E4P1Fragment;
    private pe.gob.inei.cuestionarioena.fragments.E4P2Fragment E4P2Fragment;
    private pe.gob.inei.cuestionarioena.fragments.E4P3Fragment E4P3Fragment;
    private Button btnAnterior;
    private Button btnSiguiente;
    private int fragmentActual = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eval04);

        mostrarBarra("SEGUNDA EVALUACION", true);

        btnAnterior = (Button) findViewById(R.id.btnAnterior_eval4);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente_eval4);
        E4P1Fragment = new E4P1Fragment();
        E4P2Fragment = new E4P2Fragment();
        E4P3Fragment = new E4P3Fragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,E4P1Fragment);
        fragmentTransaction.commit();



        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentActual){
                    case 0:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E4P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnAnterior.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E4P3Fragment);
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
                        fragmentTransaction.replace(R.id.container,E4P1Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnAnterior.setVisibility(View.GONE);
                        break;
                    case 2:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,E4P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnSiguiente.setText("SIGUIENTE");
                        break;
                }
            }
        });

    }

    public void mostrarBarra(String titulo, boolean flecha){
        toolbar = (Toolbar) findViewById(R.id.toolbar_eval4);
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
