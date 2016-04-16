package com.example.youssef.pcddroidfinalfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Youssef on 11/04/2016.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list =new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }


    static class LayoutHandler
    {
        TextView NOM,PRENOM,ADRESSE;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutHandler layoutHandler;
        if (row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row =layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.NOM=(TextView)row.findViewById(R.id.textnom);
            layoutHandler.PRENOM=(TextView)row.findViewById(R.id.textprenom);
            layoutHandler.ADRESSE=(TextView)row.findViewById(R.id.textadresse);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler=(LayoutHandler)row.getTag();

        }
        DataProvider dataProvider= (DataProvider)this.getItem(position);
        layoutHandler.NOM.setText(dataProvider.getNom());
        layoutHandler.PRENOM.setText(dataProvider.getPrenom());
        layoutHandler.ADRESSE.setText(dataProvider.getAdresse());

        return row;
    }
}
