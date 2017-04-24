package com.wasp.amanda.projet_mobile.userActions;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.roomorama.caldroid.CaldroidFragment;
import com.wasp.amanda.projet_mobile.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.RendezVous;

public class GetRendezVousActivity extends AppCompatActivity {

    public List<RendezVous> listeRendezVous= new ArrayList<RendezVous>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_rendez_vous);

        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);


        /* init Map that contains Date , Drawable for coloring purpose*/
        final Map<Date, Drawable> backgroundForDateMap = new HashMap<>();

        /* fill the Map with user values */
        for(int i=0;i<listeRendezVous.size();i++){
            backgroundForDateMap.put(
                    listeRendezVous.get(i).getRDVdate().getTime(),
                    listeRendezVous.get(i).getRDVcouleur()
            );
        }

        /* set the Map to the fragment*/
        caldroidFragment.setBackgroundDrawableForDates(backgroundForDateMap);


        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.CalendarContainer, caldroidFragment);
        t.commit();
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
}