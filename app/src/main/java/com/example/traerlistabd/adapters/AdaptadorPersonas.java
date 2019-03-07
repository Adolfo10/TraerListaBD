package com.example.traerlistabd.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.traerlistabd.R;
import com.example.traerlistabd.models.Persona;


import java.util.List;

public class AdaptadorPersonas extends BaseAdapter
{
    private List<Persona> listPersonas;
    private Context context;

    public AdaptadorPersonas(Context context, List<Persona> listPersonas){
        this.listPersonas = listPersonas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listPersonas.size();
    }

    @Override
    public Object getItem(int position) {
        return listPersonas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listPersonas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row, null)
        }*/

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.row, null);

        Persona persona = listPersonas.get(position);

        TextView age = convertView.findViewById(R.id.age);
        age.setText(persona.getId().toString());

        TextView nom = convertView.findViewById(R.id.apeLabel);
        nom.setText(persona.getNombre());

        return convertView;
    }


}
