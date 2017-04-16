package com.wasp.amanda.projet_mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wasp.amanda.projet_mobile.annonces_dummy.Annonces;

/**
 * A fragment representing a single Annonce detail screen.
 * This fragment is either contained in a {@link AnnonceListActivity}
 * in two-pane mode (on tablets) or a {@link AnnonceDetailActivity}
 * on handsets.
 */
public class AnnonceDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Annonces.AnnoncesItem mItem;
    private Annonces.AnnoncesItem item;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AnnonceDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Annonces.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

//            Intent intent= getI
            Activity activity = this.getActivity();
            Intent intent= activity.getIntent();

            item = (Annonces.AnnoncesItem) intent.getSerializableExtra("itemDetail");

            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(item.propretaire);
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.annonce_detail, container, false);



        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.detail_annonce_view)).setText(item.detail);
            ((TextView) rootView.findViewById(R.id.prixEdit)).setText(String.valueOf(item.price));
            ((TextView) rootView.findViewById(R.id.note)).setText(String.valueOf(item.stars));
            ((TextView) rootView.findViewById(R.id.superficieEdit)).setText(String.valueOf(item.superficie));
            ((TextView) rootView.findViewById(R.id.vueEdit)).setText(String.valueOf(item.views));
            ((TextView) rootView.findViewById(R.id.detail_annonce_view)).setText(String.valueOf(item.detail));
            ((TextView) rootView.findViewById(R.id.adresseEdit)).setText(String.valueOf(item.address));
        }


        return rootView;
    }
}
