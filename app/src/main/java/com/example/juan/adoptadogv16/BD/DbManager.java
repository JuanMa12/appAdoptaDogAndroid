package com.example.juan.adoptadogv16.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ADSI on 24/03/2015.
 */
public class DbManager {

    public static final String TABLA="Perros";
    public static final String ID="_id";
    public static final String NOMBRE="Nombre";
    public static final String EDAD="Edad";
    public static final String TIPO="Tipo";
    public static final String RAZA="Raza";
    public static final String DESCRIPCION="Descripcion";
    public static final String IMAGEN="Imagen";

   public static final String CREATE_PERROS="create table   "+TABLA+"   ("+
           ID+" integer primary key autoincrement,  "+
           NOMBRE+"   text not null,  "+
           EDAD+"    text not null,  "+
           TIPO+" text not null,  "+
           RAZA+"   text not null,  "+
           DESCRIPCION+"   text not null,  "+
           IMAGEN+"    text not null);";

    DbHelper helper;
    SQLiteDatabase db;

    public DbManager(Context context){
        helper  = new DbHelper(context);
        db  = helper.getWritableDatabase();

    }

    public Cursor cursorSitios(String id){
        String[] columnas= new String[]{ID,NOMBRE,EDAD,TIPO,RAZA,DESCRIPCION,IMAGEN};
        return db.query(TABLA,columnas,null,null,null,null,null);

    }

    public Cursor cursorIdSitios(String id){
        String[] columnas= new String[]{ID,NOMBRE,EDAD,TIPO,RAZA,DESCRIPCION,IMAGEN};
        return db.query(TABLA,columnas,ID+"=?",new String[]{id},null,null,null);

    }

}
