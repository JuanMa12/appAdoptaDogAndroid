package com.example.juan.adoptadogv16;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.adoptadogv16.Navigation.My;

import java.io.IOException;
import java.io.InputStream;

public class Perro extends My {
    private TextView nombre,edad,tipo,raza,des;
    private ImageView imagen;
    private InputStream imagenS;
    private CharSequence titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.lugar);

        //infla el layout opcion
        LayoutInflater layoutInflater   =   (LayoutInflater)this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View view;
        view = layoutInflater.inflate(R.layout.lugar,null,false);
        //agrega el menu deslizable a el layout opcion
        drawerLayout.addView(view,0);


        //define los textview identificandolo con su respectivo id nombre, ubicacion, horario y descripcion
        nombre  = (TextView)findViewById(R.id.nombre);
        edad   =   (TextView)findViewById(R.id.edad);
        tipo =   (TextView)findViewById(R.id.tipo);
        raza =   (TextView)findViewById(R.id.raza);
        des =(TextView)findViewById(R.id.desc);

        //define los ImageView identificandolo con su respectivo id imagen
        imagen  =   (ImageView)findViewById(R.id.imagen);


        //Coloca el texto al textview (nombre) que se obtiene del extra denominado "Nombre" del intent
        nombre.setText(getIntent().getStringExtra("Nombre"));

        //Coloca el texto al textview (edad) que se obtiene del extra denominado "Edad" del intent
        edad.setText("Edad: "+getIntent().getStringExtra("Edad"));

        //Coloca el texto al textview (tipo) que se obtiene del extra denominado "Tipo" del intent
        tipo.setText("Tipo: "+getIntent().getStringExtra("Tipo"));

        //Coloca el texto al textview (raza) que se obtiene del extra denominado "Raza" del intent
        raza.setText("Raza: "+getIntent().getStringExtra("Raza"));

        //Coloca el texto al textview (descripcion) que se obtiene del extra denominado "Descripcion" del intent
        des.setText("Descripcion: "+getIntent().getStringExtra("Descripcion"));

        //crea un string llamado picture que contiene el texto que se obtiene por medio de el intent, en el extra denominado "Imagen"
        String picture= getIntent().getStringExtra("Imagen");

        //Carga las imagenes
        cargar(picture);

        //Coloca el titulo con el nombre del lugar
        setTitle(getIntent().getStringExtra("Nombre"));

    }

    //metodo que carga las imagenes
    private void cargar(String picture) {

             imagen.setVisibility(View.VISIBLE);
            AssetManager asset = getAssets();
            try{
                imagenS = asset.open(picture+".jpg");
                Drawable d = Drawable.createFromStream(imagenS, null);
                imagen.setImageDrawable(d);


            } catch (IOException e) {
                e.printStackTrace();
            }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lugar, menu);
        return true;
    }

    @Override
    public void setTitle(CharSequence title) {
        titulo=title;
        getActionBar().setTitle(titulo);
    }

    @Override
    public void setTitle(int titleId) {

        switch (titleId) {
            case 1:
                titulo = "Perros";
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();finish();    }

    @Override
    protected void onStop() {
        super.onStop();


        finish();
    }
}
