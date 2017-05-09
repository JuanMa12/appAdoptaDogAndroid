package com.example.juan.adoptadogv16.Items;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.juan.adoptadogv16.Navigation.My;
import com.example.juan.adoptadogv16.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends My {


    private static final LatLng SENA = new LatLng(4.594948 , -74.112353);
    private static final LatLng CAMPIN = new LatLng(4.645979 , -74.077463);
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view;
        view = inflater.inflate(R.layout.activity_maps,null,false);
        drawerLayout.addView(view,0);

        map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
        Marker davao = map.addMarker(new MarkerOptions().position(SENA).title("Sena").snippet("CEET"));
        Marker davao1 = map.addMarker(new MarkerOptions().position(CAMPIN).title("Campin").snippet("Futbol"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SENA, 15));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(CAMPIN, 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(15), 200, null);
    }
}
