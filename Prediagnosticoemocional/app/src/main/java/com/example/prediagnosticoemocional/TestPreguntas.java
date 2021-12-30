package com.example.prediagnosticoemocional;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class TestPreguntas extends AppCompatActivity {

    Intent inPreguntasSig;
    TextView txtVwApeNinoAct, txtVwNomNinoAct;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_preguntas);

        //Declarar las variables vinculandolas al id de los objetos del layout
        txtVwNomNinoAct = (TextView)findViewById(R.id.txtVwNomNinoActividades);
        txtVwApeNinoAct = (TextView)findViewById(R.id.txtVwApeNinoActividades);

        Button btnSig = findViewById(R.id.btnSiguiente);
        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });

        //Obtener y guardar el id del usuario que ingreso con el login, para mostrar el nombre y apellido del niño
        Bundle b = getIntent().getExtras();
        id= b.getInt("id");
        dao= new daoUsuario(this);
        u=dao.getUsuarioById(id);

        //Se muestra el nombre del niño y el apellido en la pantalla
        txtVwNomNinoAct.setText(u.getNombreNino());
        txtVwApeNinoAct.setText(u.getApellidoNino());
    }

    public void startQuiz(){

        //Se guardan en variables los datos almacenados del niño
        String nN = txtVwNomNinoAct.getText().toString();
        String aN = txtVwApeNinoAct.getText().toString();
        Usuario ux = dao.getUsuarioNino(nN, aN);

        //Se llama un intento para abrir la nueva activity de las preguntas y se pasa el id del usuario que inicio sesion
        inPreguntasSig = new Intent(TestPreguntas.this, PreguntasActivity.class);
        inPreguntasSig.putExtra("id", ux.getId());
        startActivity(inPreguntasSig);
        finish();
    }

}