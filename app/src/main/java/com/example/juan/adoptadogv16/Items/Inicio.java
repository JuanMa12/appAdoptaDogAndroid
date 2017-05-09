package com.example.juan.adoptadogv16.Items;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.juan.adoptadogv16.Navigation.My;
import com.example.juan.adoptadogv16.R;

/**
 * Created by juan on 15/09/2015.
 */
public class Inicio extends My {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater   =   (LayoutInflater)this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View view;
        view = layoutInflater.inflate(R.layout.lay_inicio,null,false);
        drawerLayout.addView(view, 0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Gracias por pertenecer y aportar un granito de arena", Toast.LENGTH_LONG).show();
        finish();
    }
}
