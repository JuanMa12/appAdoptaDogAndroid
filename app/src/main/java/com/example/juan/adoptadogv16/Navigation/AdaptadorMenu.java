package com.example.juan.adoptadogv16.Navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.adoptadogv16.R;

import java.util.ArrayList;

/**
 * Created by ADSI on 24/03/2015.
 */
public class AdaptadorMenu extends BaseAdapter {
    private Context context;
    private ArrayList<ItemMenu> itemMenus;


    public AdaptadorMenu(Context context, ArrayList<ItemMenu> itemMenus) {
        this.context    = context;
        this.itemMenus  = itemMenus;

    }

    @Override
    public int getCount() {
        return itemMenus.size();
    }

    @Override
    public Object getItem(int position) {
        return itemMenus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView==null){

            LayoutInflater layoutInflater   =   (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_menu,null);

        }

        TextView titulo = (TextView)convertView.findViewById(R.id.titulo);
        ImageView icono =(ImageView)convertView.findViewById(R.id.icono);

        titulo.setText(itemMenus.get(position).getTitulo());
        icono.setImageResource(itemMenus.get(position).getIcono());

        return convertView;
    }
}
