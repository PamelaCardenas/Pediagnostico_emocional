package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Clase para veificar el login del niño a traves de su nombre y apellido
public class log_Nino extends AppCompatActivity implements View.OnClickListener{

    //Se crean las variables de los objetos
    Intent inRegresarPrincipal, inActividadesNino;
    EditText nomNino, apNino;
    Button btnIngresar, btnRegresarMenuP;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__nino);

        //Declarar las variables vinculandolas al id de los objetos del layout
        nomNino=(EditText)findViewById(R.id.edTxtUserLogNino);
        apNino=(EditText)findViewById(R.id.edTxtApellidoNino);

        btnIngresar=(Button)findViewById(R.id.btnIngresoLogNino);
        btnRegresarMenuP=(Button)findViewById(R.id.btnRegresarMenuPrincipal);

        dao=new daoUsuario(this);

        //Declarar eventos onClick al presionar un boton
        btnIngresar.setOnClickListener(this);
        btnRegresarMenuP.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIngresoLogNino:
                //Metodo para entrar a la aplicacion
                //Se obtienen los datos ingresados en los EditText y se guardan en variables
                String nN = nomNino.getText().toString();
                String aN = apNino.getText().toString();
                //Si los campos estan vacios y se presiona el boton para ingresar lanzara un error
                if(nN.equals("")&&aN.equals("")){
                    Toast.makeText(this,"ERROR, Campos vacios", Toast.LENGTH_LONG).show();

                    //Si se encuentra un nombre de niño con esos datos ingresados, se podra entrar a la aplicacion
                }else if(dao.loginNino(nN,aN)==1){
                    //Se obtiene el usuario y se almacenan sus datos en una variable
                    Usuario ux = dao.getUsuarioNino(nN,aN);
                    //Se lanza mensaje
                    Toast.makeText(this,"Datos correctos", Toast.LENGTH_LONG).show();
                    //Se abre la nueva pantalla donde se veran las actividades que puede realizar el niño
                    inActividadesNino = new Intent(getApplicationContext(), Actividades_Nino.class);
                    //A la nueva activity se manda el id del usuario que ingreso para saber cual usuario es el que inicio sesion
                    inActividadesNino.putExtra("id", ux.getId());
                    startActivity(inActividadesNino);
                    finish();
                }
                break;
            //Botón para regresar a la pantalla anterior
            case R.id.btnRegresarMenuPrincipal:
                inRegresarPrincipal = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(inRegresarPrincipal);
                finish();
                break;
        }
    }
}