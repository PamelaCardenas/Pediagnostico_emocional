package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//Pantalla en donde el niño puede leer cuentos acerca de las emociones

public class cuentos extends AppCompatActivity {

    Intent inRegresarActividadesNino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentos);
    }

    //Método para pasar de la pantalla de los cuentos, a la pantalla de las actividades
    public void regresarActividadesNino(View view){
        inRegresarActividadesNino = new Intent(getApplicationContext(), Actividades_Nino.class);
        startActivityForResult(inRegresarActividadesNino,0);
        finish();
    }
}