package com.wasp.amanda.projet_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import com.wasp.amanda.projet_mobile.adapter.SpinnerListAdapter;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {

    public static List<String> list= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        list.add("Boumerdes");
        list.add("Alger");
        list.add("Blida");
        list.add("Tizi ouzou");
        list.add("Adrar");
        list.add("Tipaza");
        list.add("Sidi Bel Abbes");
        list.add("Bejaia");
        list.add("Ghardaia");


        Spinner filterRegion = (Spinner) findViewById(R.id.filterRegion);

        SpinnerListAdapter spinnerListAdapter= new SpinnerListAdapter(this,list);

        filterRegion.setAdapter(spinnerListAdapter);




    }
}
