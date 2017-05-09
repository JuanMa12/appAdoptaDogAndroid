package com.example.juan.adoptadogv16.BD;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.adoptadogv16.R;

import java.io.IOException;
import java.io.InputStream;


public class AdaptadorCursor extends CursorAdapter {

    private Context context;
    private Cursor cursor;
    private LayoutInflater inflater;
    private int layoutId= R.layout.item_opc;
    private DbManager manager;


    public AdaptadorCursor(Context context, Cursor cursor) {
        super(context, cursor);
        cursor  = cursor;
        context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view   = inflater.inflate(layoutId,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        manager = new DbManager(context);
        TextView nombre =(TextView)view.findViewById(R.id.nombre_perro);
        TextView edad  =   (TextView)view.findViewById(R.id.edad_perro);
        TextView tipo    = (TextView)view.findViewById(R.id.tipo_perro);
        TextView raza    = (TextView)view.findViewById(R.id.raza_perro);

        ImageView imagen  = (ImageView)view.findViewById(R.id.imagen_perro);


        nombre.setText("Nombre:  "+cursor.getString(cursor.getColumnIndex(manager.NOMBRE)));
        edad.setText("Edad:  "+cursor.getString(cursor.getColumnIndex(manager.EDAD)));
        tipo.setText("Tipo:   "+cursor.getString(cursor.getColumnIndex(manager.TIPO)));
        raza.setText("Raza:  "+cursor.getString(cursor.getColumnIndex(manager.RAZA)));


        String pic = cursor.getString(cursor.getColumnIndex(manager.IMAGEN));
        AssetManager asset = context.getResources().getAssets();
        InputStream temporal=null;
        try{
            temporal   = asset.open(pic+".jpg");

        } catch (IOException e) {
            return;
        }

        BitmapFactory.Options opciones= new BitmapFactory.Options();
        opciones.inSampleSize= 4;

        Bitmap bitmap   = BitmapFactory.decodeStream(temporal, Rect.unflattenFromString("2dp"), opciones);
        BitmapDrawable picture  = new BitmapDrawable(context.getResources(),bitmap);

        imagen.setImageDrawable(picture);
        imagen.setVisibility(ImageView.VISIBLE);





    }
}
