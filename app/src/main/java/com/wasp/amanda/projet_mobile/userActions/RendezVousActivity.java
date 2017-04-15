package com.wasp.amanda.projet_mobile.userActions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TabHost;

import com.wasp.amanda.projet_mobile.R;

public class RendezVousActivity extends AppCompatActivity {

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
}
