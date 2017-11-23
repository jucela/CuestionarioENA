package pe.gob.inei.cuestionarioena;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import pe.gob.inei.cuestionarioena.fragments.C1P1Fragment;
import pe.gob.inei.cuestionarioena.fragments.C1P2Fragment;


public class Cuestionario1Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private C1P1Fragment c1P1Fragment;
    private C1P2Fragment c1P2Fragment;
    private Button btnAnterior;
    private Button btnSiguiente;
    private int fragmentActual = 0;
    private RadioButton r1,r2,r3,r4,r5;
    AtributosPreg a = new AtributosPreg();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario1);

        mostrarBarra("PRIMER CONTROL DE LECTURA", true);

        /*Spinner ms = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(Cuestionario1Activity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.cuestionario2_pregunta_2_opciones));
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ms.setAdapter(ad);*/


        btnAnterior = (Button) findViewById(R.id.btnAnterior_cuestionario1);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente_cuestionario1);
        c1P1Fragment = new C1P1Fragment();
        c1P2Fragment = new C1P2Fragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,c1P1Fragment);
        fragmentTransaction.commit();

        final DatabaseHandler ayudabd = new DatabaseHandler(getApplicationContext());
        c1P1Fragment.getear(a);

        SQLiteDatabase db = ayudabd.getReadableDatabase();
        String[] argsel = {DatabaseHandler.DatosTabla.COLUMNA_PREG};
        String[] projection = {DatabaseHandler.DatosTabla.COLUMNA_PREG, DatabaseHandler.DatosTabla.COLUMNA_RESP};
      //  Cursor c = db.query(DatabaseHandler.DatosTabla.NOMBRE_TABLA, projection, DatabaseHandler.DatosTabla.COLUMNA_PREG+"=?",argsel,null,null,null);

        //if (c.moveToFirst()) {
          //  //Recorremos el cursor hasta que no haya más registros
           // do {
          //      a.setC1_p1_1(c.getString(1));
           // } while(c.moveToNext());
//        }


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentActual){
                    /*case 0:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,c1P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnAnterior.setVisibility(View.VISIBLE);
                        break;*/
                    case 0:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,c1P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnAnterior.setVisibility(View.VISIBLE);
                        btnSiguiente.setText("FINALIZAR");

                        break;
                    case 1:
                        guardarYVolver();
                        break;
                }
                c1P1Fragment.setear(a);
            }
        });



        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentActual){
                    case 1:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,c1P1Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnAnterior.setVisibility(View.GONE);
                        btnSiguiente.setText("SIGUIENTE");
                        break;
                 /*   case 2:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,c1P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual--;
                        btnSiguiente.setText("SIGUIENTE");
                        break;*/
                }
            }
        });

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

        final DatabaseHandler ayudabd = new DatabaseHandler(getApplicationContext());

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragmentActual){

                    case 0:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,c1P2Fragment);
                        fragmentTransaction.commit();
                        fragmentActual++;
                        btnAnterior.setVisibility(View.VISIBLE);
                        btnSiguiente.setText("FINALIZAR");


                        SQLiteDatabase db = ayudabd.getWritableDatabase();
                        ContentValues valores = new ContentValues();
                        //valores.put(DatabaseHandler.DatosTabla.COLUMNA_ID,"1");
                        //valores.put(DatabaseHandler.DatosTabla.COLUMNA_PREG, view.findViewById(R.id.));
                        valores.put(DatabaseHandler.DatosTabla.COLUMNA_RESP,a.getC1_p1_1());

                        Long IdGuardado = db.insert(DatabaseHandler.DatosTabla.NOMBRE_TABLA, DatabaseHandler.DatosTabla.COLUMNA_RESP, valores);
                        Toast.makeText(getApplicationContext(), "Se guardo el dato: "+IdGuardado, Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });



        return view;


    }

    public void mostrarBarra(String titulo, boolean flecha){
        toolbar = (Toolbar) findViewById(R.id.toolbar_cuestionario1);
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
