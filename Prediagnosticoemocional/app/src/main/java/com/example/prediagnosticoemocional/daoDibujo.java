package com.example.prediagnosticoemocional;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

//Clase para declarar las sentencias de SQL, crear la base de datos y la tabla donde se van a almacenar los resultados de las actividades
public class daoDibujo {

    Context c;
    ResultadosDibujo rd;
    ArrayList<ResultadosDibujo> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tablaDel="drop table dibujoResult";
    String tabla="create table if not exists dibujoResult(id integer primary key autoincrement, nombreNino text, apellidoNino text, usuarioPadre text, dibujoImagenNino blog)";

    //Constructor
    public daoDibujo(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        rd=new ResultadosDibujo();
    }

    /*public boolean insertDibujo(ResultadosDibujo rd){
        //Si el nombre del niño no existe (es igual a 0, ya que se especifica eso en el metodo buscar),
        //se puede registrar el dibujo ya que no hay ninguno con ese nombre, en otro caso no registra nada
        if(buscar(rd.getNombreNino())==0){
            ContentValues cv = new ContentValues();
            cv.put("nombreNino",rd.getNombreNino());
            cv.put("apNino",rd.getApellidoNino());
            cv.put("usuarioPadre",rd.getUsuarioPadre());
            cv.put("dibujoImagenNino",rd.getDibujoImagenNino());
            return (sql.insert("dibujoResult", null, cv)>0);
        }else{
            return false;
        }
    }*/

}
