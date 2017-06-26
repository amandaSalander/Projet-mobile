package com.wasp.amanda.projet_mobile.userActions;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;
import com.wasp.amanda.projet_mobile.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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



        final CaldroidListener listener = new CaldroidListener() {

            Formatter formatter= new Formatter();
            @Override
            public void onSelectDate(Date date, View view) {
//                Toast.makeText(getApplicationContext(), date.toString(),
//                        Toast.LENGTH_SHORT).show();
                if (compare(listeRendezVous,date)){
                    TextView dateChoosen= (TextView) findViewById(R.id.dateChoosen);
                    dateChoosen.setText(date.toString());
                }
            }



            @Override
            public void onChangeMonth(int month, int year) {
//                String text = "month: " + month + " year: " + year;
//                Toast.makeText(getApplicationContext(), text,
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickDate(Date date, View view) {
//                Toast.makeText(getApplicationContext(),
//                        "Long click " + date.toString(),
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCaldroidViewCreated() {
//                Toast.makeText(getApplicationContext(),
//                        "Caldroid view is created",
//                        Toast.LENGTH_SHORT).show();
            }

        };

        caldroidFragment.setCaldroidListener(listener);




        caldroidFragment.setArguments(args);

        this.prepareRendezVous();

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
        Calendar calendar5= Calendar.getInstance();
        Calendar calendar6= Calendar.getInstance();

        calendar.set(2017,3,8);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar, false, new ColorDrawable(Color.parseColor("#43A047"))));
        calendar5.set(2017,3,20);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar5, false, new ColorDrawable(Color.parseColor("#43A047"))));
        calendar6.set(2017,3,21);
        listeRendezVous.add(new RendezVous("Sylia Baraka",calendar6, true, new ColorDrawable(Color.parseColor("#43A047"))));
    }

    public Boolean compare(List<RendezVous> listeRendezVous, Date date) {

        int jour = date.getDay();
        int mois = date.getMonth();
        int year = date.getYear();
        Boolean exist=false;

        for (int i = 0; i < listeRendezVous.size(); i++) {
            if (listeRendezVous.get(i).getRDVdate().getTime().getDay() == jour
                    && listeRendezVous.get(i).getRDVdate().getTime().getMonth() == mois
                    && listeRendezVous.get(i).getRDVdate().getTime().getYear() == year)
            {exist=true;}
        }

        return exist;
    }

}
