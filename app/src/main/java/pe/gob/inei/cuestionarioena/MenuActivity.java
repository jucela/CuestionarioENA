package pe.gob.inei.cuestionarioena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button btnControlN1;
    private Button btnControlN2;
    private Button btnControlN3;
    private Button btnControlE1;
    private Button btnControlE2;
    private Button btnControlE3;
    private Button btnControlE4;
    private Button btnControlE5;
    private Button btnControlE6;
    private Button btnControlE7;
    private Button btnControlN4;
    private Button btnControlN5;
    private Button btnControlN6;
    private Button btnControlN7;
    private Button btnControlEFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnControlN1 = (Button) findViewById(R.id.btnControln1);
        btnControlN2 = (Button) findViewById(R.id.btnControln2);
        btnControlN3 = (Button) findViewById(R.id.btnControln3);
        btnControlN4 = (Button) findViewById(R.id.btnControln4);
        btnControlN5 = (Button) findViewById(R.id.btnControln5);
        btnControlE1 = (Button) findViewById(R.id.btnControle1);
        btnControlE2 = (Button) findViewById(R.id.btnControle2);
        btnControlE3 = (Button) findViewById(R.id.btnControle3);
        btnControlE4 = (Button) findViewById(R.id.btnControle4);
        btnControlE5 = (Button) findViewById(R.id.btnControle5);
        btnControlE6 = (Button) findViewById(R.id.btnControle6);
        btnControlE7 = (Button) findViewById(R.id.btnControle7);
        btnControlN6 = (Button) findViewById(R.id.btnControln6);
        btnControlN7 = (Button) findViewById(R.id.btnControln7);
        btnControlEFinal = (Button) findViewById(R.id.btnControleFinal);

        btnControlN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cuestionario1Activity.class);
                startActivity(intent);
            }
        });

        btnControlN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cuestionario2Activity.class);
                startActivity(intent);
            }
        });

        btnControlN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Cuestionario3Activity.class);
                startActivity(intent);
            }
        });

        btnControlN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Cuestionario4Activity.class);
                startActivity(intent);
            }
        });

        btnControlE1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eval1Activity.class);
                startActivity(intent);
            }
        });

        btnControlE2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eval2Activity.class);
                startActivity(intent);
            }
        });

        btnControlN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Cuestionario5Activity.class);
                startActivity(intent);
            }
        });

        btnControlN6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Cuestionario6Activity.class);
                startActivity(intent);
            }
        });

        btnControlN7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Cuestionario7Activity.class);
                startActivity(intent);
            }
        });

        btnControlE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eval3Activity.class);
                startActivity(intent);
            }
        });

        btnControlE4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eval4Activity.class);
                startActivity(intent);
            }
        });

        btnControlE5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eval5Activity.class);
                startActivity(intent);
            }
        });

        btnControlE6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eval6Activity.class);
                startActivity(intent);
            }
        });

        btnControlE7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Eval7Activity.class);
                startActivity(intent);
            }
        });

        btnControlEFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),EvalFinalActivity.class);
                startActivity(intent);
            }
        });
    }
}
