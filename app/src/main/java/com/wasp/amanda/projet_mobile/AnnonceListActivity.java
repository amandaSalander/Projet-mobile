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

import com.google.firebase.auth.FirebaseAuth;
import com.wasp.amanda.projet_mobile.annonces_dummy.Annonces;
import com.wasp.amanda.projet_mobile.services.AnnonceService;
import com.wasp.amanda.projet_mobile.userActions.AgendaActivity;
import com.wasp.amanda.projet_mobile.userActions.PublishAnnoncesActivity;
import com.wasp.amanda.projet_mobile.userActions.RendezVousActivity;
import com.wasp.amanda.projet_mobile.userInformation.ProfilActivity;

import java.util.ArrayList;
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


        Toolbar  toolbar = (Toolbar) findViewById(R.id.toolbar);
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
            FirebaseAuth.getInstance().signOut();
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
        else if(id==R.id.profilUser){
            Intent intent = new Intent(AnnonceListActivity.this, ProfilActivity.class);
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

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        if (id == R.id.nav_camera) {
            // Handle the camera action

            toolbar.setTitle("les logements");

            View recyclerView = findViewById(R.id.annonce_list);
            assert recyclerView != null;
            List<Annonces.AnnoncesItem> list= Annonces.ANNONCES;
            ((RecyclerView) recyclerView).setAdapter(new SimpleItemRecyclerViewAdapter(list));

        } else if (id == R.id.nav_gallery) {
            toolbar.setTitle("les villas");

            View recyclerView = findViewById(R.id.annonce_list);
            assert recyclerView != null;
            List<Annonces.AnnoncesItem> list= new ArrayList<Annonces.AnnoncesItem>();
            Annonces.AnnoncesItem itemTry= new Annonces.AnnoncesItem(
                    "6",
                    4,
                    28,
                    500000,
                    "Annaba",
                    "Villa",
                    "rue Kouba, Annaba, Annaba",
                    "Mechri Maria",
                    "Une grande villa avec un jardin et 3 locaux commerciaux, bien situes dans un endroit tres securises" +
                            "a cote du Messe Militaire a 100 de la plage Sait-Cloud, ayant une belle terasse avec une vue" +
                            "sur la plage Saint Cloud, un jardin menu d'une fontaine, un Hammam et 2 entrees principale" +
                            "et une entrees secondaire, les locaux sont spatiaux",
                    null,
                    "Location",
                    500
            );

            list.add(itemTry);

            itemTry= new Annonces.AnnoncesItem(
                    "7",
                    3,
                    12,
                    950000,
                    "Alger",
                    "Villa",
                    "Poirsson, El Biar, Alger",
                    "Yassine Hani",
                    "Villa meubles, terrain, 850m2 surface habitable 500m2, R+1, garage jardin piscine, toutes" +
                            "commoditees",
                    null,
                    "Location",
                    850
            );
            list.add(itemTry);

            itemTry= new Annonces.AnnoncesItem(
                    "8",
                    5,
                    999,
                    40000,
                    "Tizi ouzou",
                    "Villa",
                    "Sidi Khaled, Tigzirt, Tizi ouzou",
                    "Baraka Sylia",
                    "Location vacance pour l'ete 2017, Villa R+1 et sous-sol, grande terasse, bien equipes" +
                            "a Sidi Khaled, endroit calme a 5 minutes de Tigizirt toutes commodites avec eau h24" +
                            ".",
                    null,
                    "Location",
                    160
            );

            list.add(itemTry);


            itemTry= new Annonces.AnnoncesItem(
                    "9",
                    1,
                    17,
                    100000,
                    "Tlemcen",
                    "Villa",
                    "Ghazaouet, Tlemcen",
                    "Meraoui Mourad Bouyouf",
                    "Mon equipe et moi meme seront tres heureux de vous accueuillir dans cette villa equipes" +
                            "de tout confort, une piscine, salle de sport, Ville cotiere plage tres proche, commerce" +
                            "de proximite, avec prise en charge lors du sejour" ,
                    null,
                    "Location",
                    180
            );

            list.add(itemTry);


            itemTry= new Annonces.AnnoncesItem(
                    "10",
                    4,
                    25,
                    120000,
                    "Oran",
                    "Villa",
                    "Bel, air, Oran",
                    "Jugurtha Ben Smail",
                    "Villa en plein cente d'oran affaire residentiel, tres bien placer a bel air, ente la" +
                            "wilaya et centre Ville Gambette, et l'hypdrome dispose d'un grand jardin et un local " +
                            "apart de 40m2 commercial" ,
                    null,
                    "Location",
                    500
            );

            list.add(itemTry);

            ((RecyclerView) recyclerView).setAdapter(new SimpleItemRecyclerViewAdapter(list));

        } else if (id == R.id.nav_slideshow) {
            toolbar.setTitle("les studios");

            View recyclerView = findViewById(R.id.annonce_list);
            assert recyclerView != null;
            List<Annonces.AnnoncesItem> list= new ArrayList<Annonces.AnnoncesItem>();
            Annonces.AnnoncesItem itemTry= new Annonces.AnnoncesItem(
                    "11",
                    3,
                    116,
                    120000,
                    "Annaba",
                    "Studio",
                    "Zaafrania, residence Naoures",
                    "Adel Meflous",
                    "Location Studio F1, meubles et equipes situes a residence naoures 50m2 en souplex bien" +
                            "amenages dans un endroit calme cite clotures garder avec acte pour 40000DZD" +
                            "par mois" ,
                    null,
                    "Location",
                    50
            );

            list.add(itemTry);

            itemTry= new Annonces.AnnoncesItem(
                    "12",
                    3,
                    684,
                    3500,
                    "Alger",
                    "Studio",
                    "Beni Messous 49, 1er Mai, Alger",
                    "Amina Sebaia",
                    "cygnes appart Hotel vous propose la location par jour ou par semaine des studios luxueux" +
                            "avec balcons, salons spacieux tout confort, television ecran plat, climatisation" +
                            "internet...etc." ,
                    null,
                    "Location",
                    40
            );

            list.add(itemTry);

            itemTry= new Annonces.AnnoncesItem(
                    "13",
                    4,
                    1856,
                    30000,
                    "Tizi ouzou",
                    "Studio",
                    "Centre Ville,ancienne Ville, Tizi ouzou",
                    "Nabali Mazari",
                    "Tres beau studio bien fini et bien equiper dans une belle residance securisee au centre ville" ,
                    null,
                    "Location",
                    30
            );

            list.add(itemTry);


            itemTry= new Annonces.AnnoncesItem(
                    "14",
                    4,
                    1063,
                    4000,
                    "Tlemcen",
                    "Studio",
                    "Marsa Ben Mhedi,Centre Ville, Tlemcen",
                    "Hassen Elaacher",
                    "propmotion pour l'ete 2017 bien meubles et cuisine equipees, et venait visiter je suis tres accueillant" ,
                    null,
                    "Location",
                    30
            );

            list.add(itemTry);


            itemTry= new Annonces.AnnoncesItem(
                    "15",
                    4,
                    36,
                    25000,
                    "Oran",
                    "Studio",
                    "Boulevard Marssou",
                    "Riad Bechket",
                    "je mets en location studio meubles, chambre a coucher avec un petit salon equipes (chauffage, chauffe bain, wifi" +
                            "une annee gratuite" ,
                    null,
                    "Location",
                    55
            );

            list.add(itemTry);

            ((RecyclerView) recyclerView).setAdapter(new SimpleItemRecyclerViewAdapter(list));



        } else if (id == R.id.nav_manage) {
            toolbar.setTitle("les appartements");

            View recyclerView = findViewById(R.id.annonce_list);
            assert recyclerView != null;
            List<Annonces.AnnoncesItem> list= new ArrayList<Annonces.AnnoncesItem>();
            Annonces.AnnoncesItem itemTry= new Annonces.AnnoncesItem(
                    "1",
                    4,
                    1024,
                    40000,
                    "Annaba",
                    "Appartement",
                    "Cite 08 Mars, Annaba, Annaba",
                    "Fethi Berrah",
                    "Annonces immobiliere Carthage offre pour locaion un F3 a cite 08 Mars residence" +
                            "Fatma d'une superficie de 95 m2 au 4eme etage avec ascenseur, bien amenager" +
                            "pres de tout les commerces",
                    null,
                    "Location",
                    95
            );

            list.add(itemTry);

            itemTry= new Annonces.AnnoncesItem(
                    "2",
                    5,
                    758,
                    300000,
                    "Alger",
                    "Appartement",
                    "Presidence Ben Aknoun, Alger",
                    "Nesrine Zibani",
                    "Appartement de 120m2 avec cuisine equipee en open-space meubles composee" +
                            "de 3 chambres situes dans un quartier calme et securise, acces autoroute" +
                            "imediat",
                    null,
                    "Location",
                    120
            );

            list.add(itemTry);

            itemTry= new Annonces.AnnoncesItem(
                    "3",
                    4,
                    75,
                    25000,
                    "Tizi ouzou",
                    "Appartement",
                    "Boulevard Krim Belkacem, Tizi ouzou",
                    "Tassaadit Nait Belkacem",
                    "Cabinet de gestion immobiliere met en location un F4 situe au 2eme etage" +
                            "en toutes commodites.Sis au Boulevard Krim BelKacem, Tizi ouzou",
                    null,
                    "Location",
                    101
            );


            list.add(itemTry);


            itemTry= new Annonces.AnnoncesItem(
                    "4",
                    2,
                    8,
                    120000,
                    "Tlemcen",
                    "Appartement",
                    "Kiffan, Tlemcen",
                    "Kader Tlemceni",
                    "J'ai un appartement 160 m, usage habitation avec + un garage 160 usage" +
                            "commercial bien amenager, plein centre ville de Tlemcen",
                    null,
                    "Location",
                    160
            );
            list.add(itemTry);


            itemTry= new Annonces.AnnoncesItem(
                    "5",
                    3,
                    81,
                    35000,
                    "Oran",
                    "Appartement",
                    "Bie el Adjir Akid Lotfi, Oran",
                    "Badro GTI",
                    "je suis Badro, je mets en location mon 3eme appartement,F4 situe dans quartier" +
                            "Akid Lotfi, bien amenage, au 5eme etage avec ascenseur , contacter moi s'il vous plait",
                    null,
                    "Location",
                    80
            );

            list.add(itemTry);

            ((RecyclerView) recyclerView).setAdapter(new SimpleItemRecyclerViewAdapter(list));
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
            holder.mAdresseView.setText(mValues.get(position).address);
            holder.mViewsView.setText(String.valueOf(mValues.get(position).views));
            holder.mStarsView.setText(String.valueOf(mValues.get(position).stars));
            holder.mSuperficieView.setText(String.valueOf(mValues.get(position).superficie));
            holder.imageView.setImageResource(R.drawable.annonces_1);


            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(AnnonceDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        arguments.putSerializable("itemDetail", holder.mItem);
                        arguments.putBoolean("TwoPane",true);
//                        arguments.put


                        AnnonceDetailFragment fragment = new AnnonceDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.annonce_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, AnnonceDetailActivity.class);


                        intent.putExtra("itemDetail", holder.mItem);

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
            public final TextView mAdresseView;
            public final TextView mSuperficieView;
            public final ImageView  imageView;
            public Annonces.AnnoncesItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mPriceView = (TextView) view.findViewById(R.id.price);
                mAdresseView= (TextView) view.findViewById(R.id.content);
                mStarsView = (TextView) view.findViewById(R.id.nombre_etoile);
                mViewsView = (TextView) view.findViewById(R.id.nombre_vue);
                mSuperficieView= (TextView) view.findViewById(R.id.superficie);
                imageView= (ImageView) view.findViewById(R.id.firstImageAnnonce);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mAdresseView.getText() + "'";
            }
        }
    }


}
