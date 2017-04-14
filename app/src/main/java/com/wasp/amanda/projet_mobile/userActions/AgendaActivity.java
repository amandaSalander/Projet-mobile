package com.wasp.amanda.projet_mobile.userActions;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.roomorama.caldroid.CaldroidFragment;
import com.wasp.amanda.projet_mobile.R;
import com.wasp.amanda.projet_mobile.adapter.RendezVousAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.RendezVous;

public class AgendaActivity extends AppCompatActivity {

    public List<RendezVous> listeRendezVous= new ArrayList<RendezVous>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);



        ListView listView= (ListView) findViewById(R.id.listeRendezVous);

        this.prepareRendezVous();

        RendezVousAdapter rendezVousAdapter = new RendezVousAdapter(this, listeRendezVous);

        listView.setAdapter(rendezVousAdapter);

        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,3,4);
        Date date =  calendar.getTime();

        caldroidFragment.setSelectedDate(date);

        calendar.set(2017,3,12);
        date =  calendar.getTime();
        caldroidFragment.setSelectedDate(date);                                                               
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendarView, caldroidFragment);
        t.commit();


    }

    public void prepareRendezVous(){

        listeRendezVous.add(new RendezVous("Sylia Baraka", new Date(), true));
        listeRendezVous.add(new RendezVous("Sylia Baraka", new Date(), true));
        listeRendezVous.add(new RendezVous("Sylia Baraka", new Date(), true));
        listeRendezVous.add(new RendezVous("Sylia Baraka", new Date(), true));
    }

}
