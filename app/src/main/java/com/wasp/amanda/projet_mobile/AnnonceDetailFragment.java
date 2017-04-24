package com.wasp.amanda.projet_mobile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.wasp.amanda.projet_mobile.adapter.CommentaireAdapter;
import com.wasp.amanda.projet_mobile.annonces_dummy.Annonces;
import com.wasp.amanda.projet_mobile.userActions.GetRendezVousActivity;

import java.util.ArrayList;
import java.util.List;

import model.Commentaire;

/**
 * A fragment representing a single Annonce detail screen.
 * This fragment is either contained in a {@link AnnonceListActivity}
 * in two-pane mode (on tablets) or a {@link AnnonceDetailActivity}
 * on handsets.
 */
public class AnnonceDetailFragment extends Fragment implements View.OnClickListener {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private final int MAX_BUTTONS = 2;

    /**
     * The dummy content this fragment is presenting.
     */
    private Annonces.AnnoncesItem mItem;
    private Annonces.AnnoncesItem item;
    private Boolean connecter;

    private List<Commentaire> listeCommentaire= new ArrayList<Commentaire>();

    private ViewGroup localiserContainer;
    private ViewGroup userActionsLayout;
    private Button activeButton=null;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AnnonceDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



            if( getArguments().getBoolean("TwoPane") && getArguments().containsKey("itemDetail")){
                item = (Annonces.AnnoncesItem) getArguments().getSerializable("itemDetail");
                connecter= getArguments().getBoolean("connecter");

            }
            else{
                Intent intent=getActivity().getIntent();
                item= (Annonces.AnnoncesItem) intent.getSerializableExtra("itemDetail");
                connecter= intent.getBooleanExtra("connecter",true);
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.annonce_detail, container, false);



        // Show the dummy content as text in a TextView.
        if (item != null) {
            ((TextView) rootView.findViewById(R.id.detail_annonce_view)).setText(item.detail);
            ((TextView) rootView.findViewById(R.id.prixEdit)).setText(String.valueOf(item.price));
            ((TextView) rootView.findViewById(R.id.note)).setText(String.valueOf(item.stars));
            ((TextView) rootView.findViewById(R.id.superficieEdit)).setText(String.valueOf(item.superficie));
            ((TextView) rootView.findViewById(R.id.vueEdit)).setText(String.valueOf(item.views));
            ((TextView) rootView.findViewById(R.id.detail_annonce_view)).setText(String.valueOf(item.detail));
            ((TextView) rootView.findViewById(R.id.adresseEdit)).setText(String.valueOf(item.address));



            //fill localiserContainer with custom Button
            this.localiserContainer = (ViewGroup) rootView.findViewById(R.id.localiserContainers);

            //
            this.userActionsLayout =(ViewGroup) rootView.findViewById(R.id.actionUserLayout);

            Button button = (Button) inflater.inflate(R.layout.rectangle_button_layout, localiserContainer, false);
            button.setText("Localiser");

            button.setOnClickListener(this);
            localiserContainer.addView(button);

            Button buttone;





                        if (!connecter) {
                            buttone = (Button) inflater.inflate(R.layout.rectangle_button_layout, userActionsLayout, false);
                            buttone.setText("Commenter");

                            buttone.setOnClickListener(this);
                            userActionsLayout.addView(buttone);


                        }
                        else{
                            buttone = (Button) inflater.inflate(R.layout.rectangle_button_layout, userActionsLayout, false);
                            buttone.setText("Commenter");

                            buttone.setOnClickListener(this);
                            userActionsLayout.addView(buttone);

                            buttone = (Button) inflater.inflate(R.layout.rectangle_button_sign_in, userActionsLayout, false);
                            buttone.setText("Rendez-vous !");
                            buttone.setOnClickListener(this);
                            userActionsLayout.addView(buttone);
                        }





                ListView listeCommentaires= (ListView) rootView.findViewById(R.id.listeCommentaires);

                preparerCommentaire();

                CommentaireAdapter commentaireAdapter= new CommentaireAdapter(getContext(),listeCommentaire);
                listeCommentaires.setAdapter(commentaireAdapter);





        }


        return rootView;
    }

    public void preparerCommentaire(){
//        listeCommentaire.add(new Commentaire("Je trouve cette maison belle mais cituer dans un quartier de mafia, du coup je vous deconseille de prendre rendez vous chez lui, croyait moi, c'est l'experience",1));
        listeCommentaire.add(new Commentaire("Super :D !",3));
        listeCommentaire.add(new Commentaire("Je trouve cette maison belle mais cituer dans un quartier de mafia, du coup je vous deconseille de prendre rendez vous chez lui, croyait moi, c'est l'experience",1));
        listeCommentaire.add(new Commentaire("Super :D !",3));
    }


    private void selectButton(Button button) {
        if (activeButton != null) {
            activeButton.setSelected(false);
            activeButton = null;
        }

        activeButton = button;
        button.setSelected(true);
    }

    @Override
    public void onClick(View v) {
        selectButton( (Button)v);
        Button b= (Button) v;

        if (b.getText().toString().equals("Localiser")){
            this.localiser(v);
        }
        else if (b.getText().toString().equals("Rendez-vous !")){
            Intent intent= new Intent(getActivity(), GetRendezVousActivity.class);
            startActivity(intent);
        }


    }

    /* TODO : change View v to string so that you can change easily the uri*/
    public void localiser(View v){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
