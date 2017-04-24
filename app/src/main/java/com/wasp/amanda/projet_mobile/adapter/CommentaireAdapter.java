package com.wasp.amanda.projet_mobile.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wasp.amanda.projet_mobile.R;

import java.util.ArrayList;
import java.util.List;

import model.Commentaire;

/**
 * Created by amanda on 17/04/17.
 */

public class CommentaireAdapter extends BaseAdapter {

    private Context context;
    private List<Commentaire> listComentaire= new ArrayList<Commentaire>();

    public CommentaireAdapter(Context context, List<Commentaire> listComentaire) {
        this.context = context;
        this.listComentaire = listComentaire;
    }

    @Override
    public int getCount() {
        return listComentaire.size();
    }

    @Override
    public Object getItem(int position) {
        return listComentaire.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = parent.inflate(context, R.layout.layout_commentaire,null);

        TextView note= (TextView) convertView.findViewById(R.id.note);
        TextView commentaire= (TextView) convertView.findViewById(R.id.commentaire);

        note.setText(String.valueOf(listComentaire.get(position).getNote()));
        commentaire.setText(listComentaire.get(position).getContent());


        return convertView;
    }
}
