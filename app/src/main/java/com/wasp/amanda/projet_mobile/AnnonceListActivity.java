package com.wasp.amanda.projet_mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.wasp.amanda.projet_mobile.annonces_dummy.Annonces;

import java.util.List;

/**
 * An activity representing a list of Annonces. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link AnnonceDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class AnnonceListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonce_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());



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
            public Annonces.AnnoncesItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mPriceView = (TextView) view.findViewById(R.id.price);
                mContentView = (TextView) view.findViewById(R.id.content);
                mStarsView = (TextView) view.findViewById(R.id.nombre_etoile);
                mViewsView = (TextView) view.findViewById(R.id.nombre_vue);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
