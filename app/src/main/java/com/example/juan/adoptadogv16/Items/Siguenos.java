package com.example.juan.adoptadogv16.Items;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.adoptadogv16.Navigation.My;
import com.example.juan.adoptadogv16.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by juan on 15/09/2015.
 */
public class Siguenos extends My {

        final static int cons = 0;
        ImageView foto , camera , facebook, twiter;
        TextView one, two,three;
        Bitmap bmp;
        String  name="";

    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater   =   (LayoutInflater)this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View view;
        view = layoutInflater.inflate(R.layout.lay_siguenos,null,false);
        drawerLayout.addView(view, 0);

        foto= (ImageView)findViewById(R.id.foto);
        camera = (ImageView)findViewById(R.id.camera);
        facebook = (ImageView)findViewById(R.id.face);
        twiter = (ImageView)findViewById(R.id.twit);
        one = (TextView)findViewById(R.id.one);
        two = (TextView)findViewById(R.id.two);
        three = (TextView)findViewById(R.id.three);
   }

    public void tomar(View view) {
        Intent i = new Intent();
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, cons);
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode , Intent data){
                super.onActivityResult(requestCode, resultCode, data);
                if(resultCode == Activity.RESULT_OK){

                    Bundle bundle = data.getExtras();
                    bmp = (Bitmap)bundle.get("data");
                    foto.setImageBitmap(bmp);
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("image/jpeg");
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.JPEG,100,bytes);
                    File f = new File(Environment.getExternalStorageDirectory()+File.separator+"temporary_file.jpg");
                    try{
                        f.createNewFile();
                        FileOutputStream fo = new FileOutputStream(f);
                        fo.write(bytes.toByteArray());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    share.putExtra(Intent.EXTRA_STREAM,Uri.parse("file:///sdcard/temporary_file.jpg"));
                    share.putExtra(Intent.EXTRA_TEXT, "AdoptaDog");
                    startActivity(Intent.createChooser(share,"Compartir Imagen"));
                     }
         }


        public void redFacebook(View view) {
            Uri imagen = Uri.parse("android.resource://com.example.juan.adoptadogv16/"+R.drawable.adopta_dog);
            Intent i = new Intent();
            i.setAction(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_TEXT, "AdoptaDog");
            i.putExtra(Intent.EXTRA_STREAM, imagen);
            i.setType("text/plain");
            i.setType("image/jpeg");
            startActivity(i);
        }


        public void redTwitter(View view) {
            Uri imagen = Uri.parse("android.resource://com.example.juan.adoptadogv16/"+R.drawable.adopta_dog);
            Intent i = new Intent();
            i.setAction(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_TEXT, "AdoptaDog");
            i.putExtra(Intent.EXTRA_STREAM, imagen);
            i.setType("text/plain");
            i.setType("image/jpeg");
            startActivity(i);
        }
}
