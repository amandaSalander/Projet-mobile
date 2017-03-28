package com.wasp.amanda.projet_mobile.fragment_package;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wasp.amanda.projet_mobile.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailAnnonce extends Fragment {


    public DetailAnnonce() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_annonce, container, false);
    }

}
