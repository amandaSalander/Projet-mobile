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

public class RendezVousUserAdapter extends BaseAdapter {


    private Context context;
    private List<RendezVous> listRendezVous= new ArrayList<RendezVous>();

    public RendezVousUserAdapter(Context context, List<RendezVous> listRendezVous) {
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

        convertView = parent.inflate(context, R.layout.layout_rdv,null);


        TextView RDVetat= (TextView) convertView.findViewById(R.id.rdvUserEtat);


        if (listRendezVous.get(position).getRDVetat()){
            RDVetat.setText("Done");
            RDVetat.setTextColor(Color.parseColor("#43A047"));

        }
        if(!listRendezVous.get(position).getRDVetat()) {
            RDVetat.setText("Annuler");
            RDVetat.setTextColor(Color.parseColor("#F44336"));
        }

        return convertView;
    }
}
