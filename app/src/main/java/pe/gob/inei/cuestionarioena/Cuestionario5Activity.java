package pe.gob.inei.cuestionarioena;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import pe.gob.inei.cuestionarioena.fragments.C4P1Fragment;
import pe.gob.inei.cuestionarioena.fragments.C4P2Fragment;
import pe.gob.inei.cuestionarioena.fragments.C5P1Fragment;
import pe.gob.inei.cuestionarioena.fragments.C5P2Fragment;

public class Cuestionario5Activity extends AppCompatActivity
{

    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private C5P1Fragment c5P1Fragment;
    private C5P2Fragment c5P2Fragment;
    private Button btnAnterior;
    private Button btnSiguiente;
    private int fragmentActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario5);

        mostrarBarra("QUINTO CONTROL DE LECTURA", true);

        btnAnterior = (Button) findViewById(R.id.btnAnterior_cuestionario5);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente_cuestionario5);
        c5P1Fragment = new C5P1Fragment();
        c5P2Fragment = new C5P2Fragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,c5P1Fragment);
        fragmentTransaction.commit();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentActual){
                    case 0:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,c5P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnAnterior.setVisibility(View.VISIBLE);
                        btnSiguiente.setText("FINALIZAR");
                        break;
                    case 1:
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
                        fragmentTransaction.replace(R.id.container,c5P1Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnAnterior.setVisibility(View.GONE);
                        btnSiguiente.setText("SIGUIENTE");
                        break;
                }
            }
        });
    }

    public void mostrarBarra(String titulo, boolean flecha){
        toolbar = (Toolbar) findViewById(R.id.toolbar_cuestionario5);
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
