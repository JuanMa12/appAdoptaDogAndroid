package com.example.juan.adoptadogv16.Items;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.juan.adoptadogv16.Navigation.My;
import com.example.juan.adoptadogv16.R;

/**
 * Created by juan on 15/09/2015.
 */
public class Comparte extends My {

    final static int con = 0;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater   =   (LayoutInflater)this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View view;
        view = layoutInflater.inflate(R.layout.lay_comparte,null,false);
        drawerLayout.addView(view, 0);

    }

    public void mapa(View view) {
        Intent mapa = new Intent(this,MapsActivity.class);
        startActivity(mapa);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

}
