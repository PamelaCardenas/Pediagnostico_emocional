package com.example.prediagnosticoemocional;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

//Clase para crear la tabla de los usuarios registrados

public class daoUsuario {

    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tablaDel="drop table usuario";
    String tabla="create table if not exists usuario(id integer primary key autoincrement, nombreNino text, apNino text, edadNino text, nombrePadre text, apPadre text, usuario text, pass text)";

    public daoUsuario(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u=new Usuario();
    }

    //Metodo para insertar usuarios
    public boolean insertUsuario(Usuario u){
        //Si el nombre del usuario no existe (es igual a 0, ya que se especifica eso en el metodo buscar),
        //se puede registrar el usuario ya que no hay ninguno con ese nombre, en otro caso no registra nada
        if(buscar(u.getUsuarioPadre())==0){
            ContentValues cv = new ContentValues();
            cv.put("nombreNino",u.getNombreNino());
            cv.put("apNino",u.getApellidoNino());
            cv.put("edadNino",u.getEdadNino());
            cv.put("nombrePadre",u.getNombrePadre());
            cv.put("apPadre",u.getApellidoPadre());
            cv.put("usuario",u.getUsuarioPadre());
            cv.put("pass",u.getPasswordPadre());
            return (sql.insert("usuario", null, cv)>0);
        }else{
            return false;
        }
    }

    //Metodo para buscar usuarios
    public int buscar(String u){
        int x=0;
        lista = selectUsuarios();
        //Comprobar que no existen dos usuarios registrados con el mismo usuario
        for (Usuario us:lista) {
            if(us.getUsuarioPadre().equals(u)){
                x++;
            }
        }
        return x;
    }

    //Metodo para mostrar todos los usuarios que se encuentran en la tabla
    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setNombreNino(cr.getString(1));
                u.setApellidoNino(cr.getString(2));
                u.setEdadNino(cr.getString(3));
                u.setNombrePadre(cr.getString(4));
                u.setApellidoPadre(cr.getString(5));
                u.setUsuarioPadre(cr.getString(6));
                u.setPasswordPadre(cr.getString(7));

                lista.add(u);
            }while(cr.moveToNext());
        }
        return lista;
    }

    //Metodo login para verificar el usuario que se quiere ingresar para entrar a la aplicacion
    public int login(String u, String p){
        int a=0;
        Cursor cr=sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                if(cr.getString(6).equals(u)&&cr.getString(7).equals(p)){
                    a++;
                }
            }while(cr.moveToNext());
        }
        return a;
    }

    public Usuario getUsuario(String u, String p){
        lista=selectUsuarios();
        for (Usuario us:lista) {
            if(us.getUsuarioPadre().equals(u)&&us.getPasswordPadre().equals(p)){
                return us;
            }
        }
        return null;
    }

    public Usuario getUsuarioById(int id){
        lista=selectUsuarios();
        for (Usuario us:lista) {
            if(us.getId()==id){
                return us;
            }
        }
        return null;
    }

}
