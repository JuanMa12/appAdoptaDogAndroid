package com.example.juan.adoptadogv16.Items;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.juan.adoptadogv16.Navigation.My;
import com.example.juan.adoptadogv16.R;

/**
 * Created by juan on 15/09/2015.
 */
public class Contactame  extends My {

    EditText nombre , apellido , correo;
    RadioGroup botones;
    RadioButton boton1 , boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater   =   (LayoutInflater)this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View view;
        view = layoutInflater.inflate(R.layout.lay_contactame,null,false);
        drawerLayout.addView(view, 0);
    }

    public void correo(View view) {

        nombre = (EditText)findViewById(R.id.nombre);
        apellido = (EditText)findViewById(R.id.apellido);
        correo = (EditText)findViewById(R.id.correo);
        botones = (RadioGroup)findViewById(R.id.butonns);
        boton1 = (RadioButton)findViewById(R.id.button1);
        boton2 = (RadioButton)findViewById(R.id.button2);

        boton1.setText("Adoptar");
        boton2.setText("Apradinar");

        String tipo = null;
        if(R.id.button1 == botones.getCheckedRadioButtonId()){tipo = getResources().getString(R.string.borton1).toString();
        }else{tipo = getResources().getString(R.string.borton2).toString();}

        String nombrestr = nombre.getText().toString();
        String apellidostr = apellido.getText().toString();
        String correostr = correo.getText().toString();
        String tipostr = boton1.getText().toString();

        if(nombrestr.equals("")){
            Toast.makeText(this,"El campo NOMBRE esta vacio",Toast.LENGTH_LONG).show();
        }else{
                if(apellidostr.equals("")){
                         Toast.makeText(this,"El campo APELLIDO esta vacio",Toast.LENGTH_LONG).show();
                     }else{
                         if(correostr.equals("")){
                             Toast.makeText(this,"El campo CORREO esta vacio",Toast.LENGTH_LONG).show();
                             }else{
                                   if(tipostr.equals("")){
                                     Toast.makeText(this,"El campo TIPO esta vacio",Toast.LENGTH_LONG).show();
                                      }else {

                                            Intent inte = new Intent(android.content.Intent.ACTION_SEND);
                                            inte.setType("plain/text");
                                            inte.putExtra(Intent.EXTRA_EMAIL, new String[]{"juan.ma.r@misena.edu.co"});
                                            inte.putExtra(Intent.EXTRA_SUBJECT,
                                                    "Nombre: " + nombre.getText().toString() + '\n' +
                                                            "      Apellido: " + apellido.getText().toString() + '\n' +
                                                            "      Correo: " + correo.getText().toString() + '\n' +
                                                            "      Tipo: " + tipo);
                                            startActivity(inte);
                                            }
                                }
                       }
              }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }



}
