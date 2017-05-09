package com.example.juan.adoptadogv16.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.juan.adoptadogv16.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class DbHelper extends SQLiteOpenHelper {

    public static final String NOMBRE_DB="AdoptaDog";
    public static final int VERSION_DB=1;
    InputStream perros;

    public DbHelper(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);

        perros  = context.getResources().openRawResource(R.raw.perros);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL(DbManager.CREAR_SITIOS);

        db.execSQL(DbManager.CREATE_PERROS);

        String documento  ;
        String[] filas, datos;


      documento   = leer(perros);
        filas   = documento.split("\r\n");

        for (int i = 0; i<filas.length; i++){

            ContentValues values    = new ContentValues();
            datos   = filas[i].split(";");

            values.put("Nombre",datos[0]);
            values.put("Edad",datos[1]);
            values.put("Tipo",datos[2]);
            values.put("Raza",datos[3]);
            values.put("Descripcion",datos[4]);
            values.put("Imagen",datos[5]);

            db.insertOrThrow("Perros",null,values);

        }



    }

    private String leer(InputStream entrada) {

        String salida;
        int i;
        ByteArrayOutputStream out   = new ByteArrayOutputStream();

        try {
            i= entrada.read();
            while (i!=-1){
               out.write(i);
                i= entrada.read();

            } entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        salida  = out.toString();
        return salida;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
