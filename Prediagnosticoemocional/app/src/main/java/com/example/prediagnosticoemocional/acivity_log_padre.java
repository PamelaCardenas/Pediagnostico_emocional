package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Clase para que el papá pueda realizar login para ingresar a ver los resultados del niño

public class acivity_log_padre extends AppCompatActivity implements View.OnClickListener{

    //Se crean las variables de los objetos
    Intent inRegresarPrincipal, inResultadosPadre;
    EditText usrPadre, passPadre;
    Button btnIngresar, btnRegLoginPadre;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_log_padre);

        //Declarar las variables vinculandolas al id de los objetos del layout

        usrPadre=(EditText)findViewById(R.id.edTxtUserLogPadre);
        passPadre=(EditText)findViewById(R.id.edTxtContraLogPadre);

        btnIngresar=(Button)findViewById(R.id.btnIngresoLogPadre);
        btnRegLoginPadre=(Button)findViewById(R.id.btnRegresarLoginPadre);

        //Objeto de la clase dao usuario
        dao=new daoUsuario(this);

        //Declarar eventos onClick al presionar un boton
        btnIngresar.setOnClickListener(this);
        btnRegLoginPadre.setOnClickListener(this);
    }

    //Método para realizar el login o regresar de la pantalla de login del padre, al menú principal

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIngresoLogPadre:
                //Metodo para entrar a la aplicacion con Login
                String u = usrPadre.getText().toString();
                String p = passPadre.getText().toString();
                //Comparativa si los campos estan vacios no deja entrar, manda error
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this,"ERROR, Campos vacios", Toast.LENGTH_LONG).show();
                //Si se encuentra un usuario y contraseña con esos datos ingresados, se podra entrar a la aplicacion
                }else if(dao.login(u,p)==1){
                    //Se guardan los datos
                    Usuario ux = dao.getUsuario(u,p);
                    //Se lanza mensaje
                    Toast.makeText(this,"Datos correctos", Toast.LENGTH_LONG).show();
                    //Se abre la nueva pantalla donde se veran los resultados del padre
                    inResultadosPadre = new Intent(getApplicationContext(), resultadosPadre.class);
                    //A la nueva activity se manda el id del usuario que ingreso para saber cual usuario es el que inicio sesion
                    inResultadosPadre.putExtra("id", ux.getId());
                    startActivity(inResultadosPadre);
                    finish();
                }
                break;
            case R.id.btnRegresarLoginPadre:
                //Botón para regresar a la pantalla anterior
                inRegresarPrincipal = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(inRegresarPrincipal);
                finish();
                break;
        }
    }
}