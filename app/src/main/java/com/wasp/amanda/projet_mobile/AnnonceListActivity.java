package com.wasp.amanda.projet_mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.wasp.amanda.projet_mobile.annonces_dummy.Annonces;
import com.wasp.amanda.projet_mobile.services.AnnonceService;
import com.wasp.amanda.projet_mobile.userActions.AgendaActivity;
import com.wasp.amanda.projet_mobile.userActions.PublishAnnoncesActivity;
import com.wasp.amanda.projet_mobile.userActions.RendezVousActivity;

import java.util.List;

/**
 * An activity representing a list of Annonces. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link AnnonceDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class AnnonceListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Object a= AnnonceService.myRef;



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonce_list);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("RDV demanded");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Location");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Location");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Vente");
        host.addTab(spec);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(AnnonceListActivity.this, FilterActivity.class);
                startActivity(intent);
                Toast.makeText(AnnonceListActivity.this, "FILTRE !!!! XD",
                        Toast.LENGTH_SHORT).show();
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);


        View recyclerView = findViewById(R.id.annonce_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.annonce_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        Toast.makeText(this,"this is my ref "+a.toString(),Toast.LENGTH_SHORT).show();

        TextView textView= (TextView) findViewById(R.id.nomUser);


    }


    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.annoncement_connected, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sign_out) {
            MainActivity.mAuth.signOut();
            this.finish();
            return true;
        }
        else if (id==R.id.agenda){

            Intent intent = new Intent(AnnonceListActivity.this, AgendaActivity.class);
            startActivity(intent);
            Toast.makeText(AnnonceListActivity.this, "connected hourraaaaa",
                    Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.mesAnnonces){
            Intent intent = new Intent(AnnonceListActivity.this, PublishAnnoncesActivity.class);
            startActivity(intent);
            Toast.makeText(AnnonceListActivity.this, "mes annonces ! X)...sans blague",
                    Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.mesRendezVous){
            Intent intent = new Intent(AnnonceListActivity.this, RendezVousActivity.class);
            startActivity(intent);
            Toast.makeText(AnnonceListActivity.this, "mes rendez vous ! X)...sans blague",
                    Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(Annonces.ANNONCES));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Annonces.AnnoncesItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<Annonces.AnnoncesItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.annonce_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {


            holder.mItem = mValues.get(position);
            holder.mPriceView.setText(String.valueOf(mValues.get(position).price));
            holder.mContentView.setText(mValues.get(position).detail);
            holder.mViewsView.setText(String.valueOf(mValues.get(position).views));
            holder.mStarsView.setText(String.valueOf(mValues.get(position).stars));
            holder.imageView.setImageResource(R.drawable.annonces_1);


            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(AnnonceDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        AnnonceDetailFragment fragment = new AnnonceDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.annonce_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, AnnonceDetailActivity.class);
                        intent.putExtra(AnnonceDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mPriceView;
            public final TextView mStarsView;
            public final TextView mViewsView;
            public final TextView mContentView;
            public final ImageView  imageView;
            public Annonces.AnnoncesItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mPriceView = (TextView) view.findViewById(R.id.price);
                mContentView = (TextView) view.findViewById(R.id.content);
                mStarsView = (TextView) view.findViewById(R.id.nombre_etoile);
                mViewsView = (TextView) view.findViewById(R.id.nombre_vue);
                imageView= (ImageView) view.findViewById(R.id.firstImageAnnonce);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }


}
