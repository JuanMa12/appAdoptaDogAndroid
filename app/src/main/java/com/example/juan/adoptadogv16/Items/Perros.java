package com.example.juan.adoptadogv16.Items;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.juan.adoptadogv16.BD.AdaptadorCursor;
import com.example.juan.adoptadogv16.BD.DbManager;
import com.example.juan.adoptadogv16.Perro;
import com.example.juan.adoptadogv16.Navigation.My;
import com.example.juan.adoptadogv16.R;


/**
 * Created by juan on 15/09/2015.
 */
public class Perros extends My {

    private ListView listaOpc;
    private Cursor cursor;
    private AdaptadorCursor adaptadorCursor;
    private DbManager manager;
    private int inicio;
    private CharSequence titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            //infla el layout opcion
            LayoutInflater layoutInflater   =   (LayoutInflater)this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
            View view;
            view = layoutInflater.inflate(R.layout.opcion,null,false);
            //agrega el menu deslizable a el layout opcion
            drawerLayout.addView(view,0);

            listaOpc    =   (ListView)findViewById(R.id.lista_opc);
            manager = new DbManager(this);

            //captura los extras del intent
            Bundle extras = getIntent().getExtras();

            inicio  = extras.getInt("inicio");
            String opcion = Integer.toString(inicio);

            setTitle(inicio);

            cargar(opcion);

            listaOpc.setOnItemClickListener(new ItemClick());



        }

    private void cargar(String opcion) {


        //    Toast.makeText(this,"opcion "+opcion,Toast.LENGTH_LONG).show();

        cursor = manager.cursorSitios(opcion);
        cursor.moveToFirst();

        adaptadorCursor = new AdaptadorCursor(this,cursor);

        listaOpc.setAdapter(adaptadorCursor);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.opcion, menu);
        return true;
    }


    private class ItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String id1=Long.toString(id);

            cursor  = manager.cursorIdSitios(id1);
            cursor.moveToFirst();

            Intent lugar    =   new Intent(Perros.this,Perro.class);
            lugar.putExtra("Nombre",cursor.getString(1));
            lugar.putExtra("Edad",cursor.getString(2));
            lugar.putExtra("Tipo",cursor.getString(3));
            lugar.putExtra("Raza",cursor.getString(4));
            lugar.putExtra("Descripcion",cursor.getString(5));
            lugar.putExtra("Imagen",cursor.getString(6));

            startActivity(lugar);

        }
    }

    @Override
    public void setTitle(int titleId) {

        switch (titleId){
            case 1:
                titulo= "Perros";
                break;

        }

        getActionBar().setTitle(titulo);

    }
}



