package adapter.userActions;

import android.os.StrictMode;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.wasp.amanda.projet_mobile.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AgendaActivity extends AppCompatActivity {

    public List<String> list= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);


        list.add("rendez vous 1");
        list.add("rendez vous 2");
        list.add("rendez vous 3");
        list.add("rendez vous 4");
        list.add("rendez vous 5");
        list.add("rendez vous 6");
        list.add("rendez vous 7");
        list.add("rendez vous 8");
        list.add("rendez vous 9");
        list.add("rendez vous 10");


        ListView listView= (ListView) findViewById(R.id.listeRendezVous);

        ArrayAdapter arrayAdapter= new ArrayAdapter(AgendaActivity.this,android.R.layout.simple_list_item_1,list);

        listView.setAdapter(arrayAdapter);

        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,3,4);
//        calendar.setTime(new Date(2017,4,4));
        Date date =  calendar.getTime();

        caldroidFragment.setSelectedDate(date);

        calendar.set(2017,3,12);
        date =  calendar.getTime();
        caldroidFragment.setSelectedDate(date);                                                               
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendarView, caldroidFragment);
        t.commit();

//        CalendarView caldroidFragment= (CalendarView) findViewById(R.id.calendrier);

//        Toast.makeText(AgendaActivity.this, String.valueOf(caldroidFragment.getFirstDayOfWeek()), Toast.LENGTH_SHORT ).show();

    }
    public void clicked(View v){
//        CalendarView calendarView= (CalendarView) findViewById(R.id.calendarView);
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month,
//                                            int dayOfMonth) {
//                int d = dayOfMonth;
//
//                Toast.makeText(AgendaActivity.this, String.valueOf(d), Toast.LENGTH_SHORT ).show();
//
//            }
//        });
    }
}
