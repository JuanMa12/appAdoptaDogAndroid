package com.example.juan.adoptadogv16.Navigation;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.juan.adoptadogv16.Items.Comparte;
import com.example.juan.adoptadogv16.Items.Contactame;
import com.example.juan.adoptadogv16.Items.Inicio;
import com.example.juan.adoptadogv16.Items.MapsActivity;
import com.example.juan.adoptadogv16.Items.Perros;
import com.example.juan.adoptadogv16.Items.Siguenos;
import com.example.juan.adoptadogv16.R;

import java.util.ArrayList;


public class My extends Activity {

    protected DrawerLayout drawerLayout = null;
    private ActionBarDrawerToggle toggle;
    private ListView listamenu;
    private String[] titulo;
    private TypedArray icono;
    private ArrayList<ItemMenu> itemMenus;
    private AdaptadorMenu adaptadorMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);

        drawerLayout =  (DrawerLayout)findViewById(R.id.menu);
        listamenu   =   (ListView)findViewById(R.id.lista_menu);
        titulo  =   getResources().getStringArray(R.array.titulos);
        icono   =   getResources().obtainTypedArray(R.array.iconos);

        //inicializa el arreglo de  items del menu
        itemMenus   = new ArrayList<ItemMenu>();

        //agrega los elementos de titulos e iconos al menu
        //inicio
        itemMenus.add(new ItemMenu(titulo[0],icono.getResourceId(0,-1)));
        //perros
        itemMenus.add(new ItemMenu(titulo[1],icono.getResourceId(1,-1)));
        //comparte
        itemMenus.add(new ItemMenu(titulo[2],icono.getResourceId(2,-1)));
        //mapa
        itemMenus.add(new ItemMenu(titulo[3],icono.getResourceId(3,-1)));
        //siguenos
        itemMenus.add(new ItemMenu(titulo[4],icono.getResourceId(4,-1)));
        //contactanos
        itemMenus.add(new ItemMenu(titulo[5],icono.getResourceId(5,-1)));

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        toggle  = new ActionBarDrawerToggle(this
        ,drawerLayout,
                R.drawable.drawer,
                R.string.app_name,
                R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        adaptadorMenu   = new AdaptadorMenu(getApplicationContext(),itemMenus);
        listamenu.setAdapter(adaptadorMenu);


        listamenu.setOnItemClickListener(new itemClick());
        drawerLayout.setDrawerListener(toggle);

    }


    private class itemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            ir(position);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }
//metodo de seleccionar los items del menu
    private void ir(int position) {


        switch(position){

            case 0:
                //lleva a la actividad de inicio
                Intent inicio   = new Intent(My.this,Inicio.class);
                startActivity(inicio);
                break;

            //muestra el listview de hoteles
            case 1:
                Intent perros    =   new Intent(My.this, Perros.class);
                perros.putExtra("inicio",1);
                startActivity(perros);
                break;
            //muestra el listview de restaurantes
            case 2:
                Intent comparte    =   new Intent(My.this, Comparte.class);
                startActivity(comparte);
                break;
            //muestra el listview de rumba nocturna
            case 3:
                Intent mapa    =   new Intent(My.this, MapsActivity.class);
                startActivity(mapa);
                break;
            case 4:
                Intent siguenos   = new Intent(My.this,Siguenos.class);
                startActivity(siguenos);
                break;
            case 5:
                Intent contactame   = new Intent(My.this,Contactame.class);
                startActivity(contactame);
                break;

            default:
                Intent defecto   = new Intent(My.this,Inicio.class);
                startActivity(defecto);
                break;

        }
        listamenu.setItemChecked(position,true);
        listamenu.setSelection(position);
        drawerLayout.closeDrawer(listamenu);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
