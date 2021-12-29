package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//Manejo de la pantalla principal

public class MainActivity extends AppCompatActivity {

    Intent inIngresoPadre, loginNino, inRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método para ir del menú principal a el login del padre
    public void ingresoPadre(View view){
        inIngresoPadre = new Intent(getApplicationContext(), acivity_log_padre.class);
        startActivity(inIngresoPadre);
        finish();
    }

    //Método para ir del menú principal a las actividades del niño
    public void loginNino(View view){
        loginNino = new Intent(getApplicationContext(), log_Nino.class);
        startActivity(loginNino);
        finish();
    }

    //Método para ir del menú principal a la pantalla de registro
    public void registro(View view){
        inRegistro = new Intent(getApplicationContext(), Registro.class);
        startActivity(inRegistro);
        finish();
    }
}