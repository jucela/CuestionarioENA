package pe.gob.inei.cuestionarioena;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dni=(EditText)findViewById(R.id.dni);
        SharedPreferences prefe=getSharedPreferences("dni", Context.MODE_PRIVATE);
        dni.setText(prefe.getString("id",""));
    }

    public void ejecutar(View v) {
        SharedPreferences preferencias=getSharedPreferences("dni",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("id", dni.getText().toString());
        editor.commit();
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }

}
