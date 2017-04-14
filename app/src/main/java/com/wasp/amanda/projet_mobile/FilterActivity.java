package com.wasp.amanda.projet_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import adapter.SpinnerListAdapter;

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
//        SpinnerAdapter spinnerAdapter= new SpinnerAdapter(this, R.layout.support_simple_spinner_dropdown_item, list) {
//        };

//        filterRegion.setAdapter(spinnerAdapter);




    }
}
