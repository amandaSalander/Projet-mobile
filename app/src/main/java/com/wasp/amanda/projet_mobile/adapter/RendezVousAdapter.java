package com.wasp.amanda.projet_mobile.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wasp.amanda.projet_mobile.R;

import java.util.ArrayList;
import java.util.List;

import model.RendezVous;

/**
 * Created by amanda on 14/04/17.
 */

public class RendezVousAdapter extends BaseAdapter {


    private Context context;
    private List<RendezVous> listRendezVous= new ArrayList<RendezVous>();

    public RendezVousAdapter(Context context, List<RendezVous> listRendezVous) {
        this.context = context;
        this.listRendezVous = listRendezVous;
    }


    @Override
    public int getCount() {
        return listRendezVous.size();
    }

    @Override
    public Object getItem(int position) {
        return listRendezVous.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = parent.inflate(context, R.layout.layout_rendez_vous,null);

        TextView RDVcouleur= (TextView) convertView.findViewById(R.id.RDVcouleur);
        TextView RDVnom= (TextView) convertView.findViewById(R.id.RDVnom);
        TextView RDVdate= (TextView) convertView.findViewById(R.id.RDVdate);
        TextView RDVetat= (TextView) convertView.findViewById(R.id.RDVetat);

        RDVnom.setText(listRendezVous.get(position).getRDVnom());
        RDVdate.setText(listRendezVous.get(position).getRDVdate().getTime().toString());
        RDVcouleur.setBackgroundColor(listRendezVous.get(position).getRDVcouleur().getColor());
        if (listRendezVous.get(position).getRDVetat()){
            RDVetat.setText("Done");
            RDVetat.setTextColor(Color.parseColor("#FFFFFF"));
            RDVetat.setBackgroundColor(Color.parseColor("#43A047"));
        }
        if(!listRendezVous.get(position).getRDVetat()) {
            RDVetat.setText("Annuler");
            RDVetat.setTextColor(Color.parseColor("#FFFFFF"));
            RDVetat.setBackgroundColor(Color.parseColor("#F44336"));
        }

        return convertView;
    }
}
