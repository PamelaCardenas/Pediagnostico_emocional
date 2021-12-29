package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//Pantalla en donde el niño puede leer cuentos acerca de las emociones

public class cuentos extends AppCompatActivity {

    //Se crean las variables de los objetos
    Intent inRegresarActividadesNino;
    TextView txtVwApeNino, txtVwNomNino;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentos);

        //Declarar las variables vinculandolas al id de los objetos del layout
        txtVwNomNino = (TextView)findViewById(R.id.txtVwNomNinoCuentos);
        txtVwApeNino = (TextView)findViewById(R.id.txtVwApeNinoCuentos);

        dao=new daoUsuario(this);

        //Obtener y guardar el id del usuario que ingreso con el login, para mostrar el nombre y apellido del niño
        Bundle b = getIntent().getExtras();
        id= b.getInt("id");
        u=dao.getUsuarioById(id);

        //Se muestra el nombre del niño y el apellido en la pantalla
        txtVwNomNino.setText(u.getNombreNino());
        txtVwApeNino.setText(u.getApellidoPadre());
    }

    //Método para pasar de la pantalla de los cuentos, a la pantalla de las actividades
    public void regresarActividadesNino(View view){

        //Se guardan en variables los datos almacenados del niño
        String nN = txtVwNomNino.getText().toString();
        String aN = txtVwApeNino.getText().toString();
        Usuario ux = dao.getUsuarioNino(nN,aN);

        //Se llama un intento para regresar al activity de las actividades y se pasa el id del usuario que inicio sesion
        inRegresarActividadesNino = new Intent(getApplicationContext(), Actividades_Nino.class);
        inRegresarActividadesNino.putExtra("id", ux.getId());
        startActivity(inRegresarActividadesNino);
        finish();
    }
}