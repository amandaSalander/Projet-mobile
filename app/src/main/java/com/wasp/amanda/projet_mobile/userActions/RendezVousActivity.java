package com.wasp.amanda.projet_mobile.userActions;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TabHost;

import com.wasp.amanda.projet_mobile.R;
import com.wasp.amanda.projet_mobile.adapter.RendezVousUserAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.RendezVous;

public class RendezVousActivity extends AppCompatActivity {

    public List<RendezVous> listeRendezVous= new ArrayList<RendezVous>();
    public List<RendezVous> listeRendezVousNesrine= new ArrayList<RendezVous>();
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        prepareRendezVousNesrine();
        prepareRendezVous();


        ListView listView= (ListView) findViewById(R.id.rdv_recieved);
        ListView listView1= (ListView) findViewById(R.id.rdv_sent);

        RendezVousUserAdapter rendezVousUserAdapter= new RendezVousUserAdapter(this,listeRendezVous);

        RendezVousUserAdapter rendezVousUserAdapterNesrine= new RendezVousUserAdapter(this,listeRendezVousNesrine);


        listView.setAdapter(rendezVousUserAdapter);
        listView1.setAdapter(rendezVousUserAdapterNesrine);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();


        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("RDV demanded");
        spec.setContent(R.id.tab1);
        spec.setIndicator("RDV demanded");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("RDV recieved");
        spec.setContent(R.id.tab2);
        spec.setIndicator("RDV recieved");
        host.addTab(spec);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, RendezVousActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void prepareRendezVous(){
        Calendar calendar= Calendar.getInstance();
        Calendar calendar1= Calendar.getInstance();
        Calendar calendar2= Calendar.getInstance();
        Calendar calendar3= Calendar.getInstance();
        Calendar calendar4= Calendar.getInstance();
        Calendar calendar5= Calendar.getInstance();
        Calendar calendar6= Calendar.getInstance();

        calendar.set(2017,3,8);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar, false, new ColorDrawable(Color.parseColor("#43A047"))));
        calendar1.set(2017,3,12);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar1, true, new ColorDrawable(Color.parseColor("#EF6C00"))));
        calendar2.set(2017,3,1);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar2, false, new ColorDrawable(Color.parseColor("#37474F"))));
        calendar3.set(2017,3,15);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar3, true, new ColorDrawable(Color.parseColor("#03A9F4"))));
        calendar4.set(2017,3,22);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar4, true, new ColorDrawable(Color.parseColor("#009688"))));
        calendar5.set(2017,3,4);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar5, false, new ColorDrawable(Color.parseColor("#673AB7"))));
        calendar6.set(2017,3,11);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar6, true, new ColorDrawable(Color.parseColor("#F50057"))));
    }


    public void prepareRendezVousNesrine(){
        Calendar calendar= Calendar.getInstance();
        Calendar calendar1= Calendar.getInstance();
        Calendar calendar2= Calendar.getInstance();
        Calendar calendar3= Calendar.getInstance();
        Calendar calendar4= Calendar.getInstance();
        Calendar calendar5= Calendar.getInstance();
        Calendar calendar6= Calendar.getInstance();

        calendar.set(2017,3,8);
        listeRendezVousNesrine.add(new RendezVous("Nesrine Zibani",calendar, true, new ColorDrawable(Color.parseColor("#43A047"))));
        calendar1.set(2017,3,12);
        listeRendezVousNesrine.add(new RendezVous("Nesrine Zibani",calendar1, true, new ColorDrawable(Color.parseColor("#EF6C00"))));
        calendar2.set(2017,3,1);
        listeRendezVousNesrine.add(new RendezVous("Nesrine Zibani",calendar2, false, new ColorDrawable(Color.parseColor("#37474F"))));
        calendar3.set(2017,3,15);
        listeRendezVousNesrine.add(new RendezVous("Nesrine Zibani",calendar3, true, new ColorDrawable(Color.parseColor("#03A9F4"))));
        calendar4.set(2017,3,22);
        listeRendezVousNesrine.add(new RendezVous("Nesrine Zibani",calendar4, true, new ColorDrawable(Color.parseColor("#009688"))));
        calendar5.set(2017,3,4);
        listeRendezVousNesrine.add(new RendezVous("Nesrine Zibani",calendar5, true, new ColorDrawable(Color.parseColor("#673AB7"))));
        calendar6.set(2017,3,11);
        listeRendezVousNesrine.add(new RendezVous("Nesrine Zibani",calendar6, true, new ColorDrawable(Color.parseColor("#F50057"))));
    }

}
