package com.chaleva.sassoni.projectc.concertsearch.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.Concert;
import com.chaleva.sassoni.projectc.R;
import com.chaleva.sassoni.projectc.concertsearch.presenter.ConcertSearchPresenter;

import java.util.ArrayList;
import java.util.List;

public class ConcertSearchActivity extends AppCompatActivity implements ConcertSearchView {

    private static final String INTENT_EXTRA_ARTIST = "intent_extra_artist";

    private ConcertSearchPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private ConcertSearchRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Artist mArtist;

    public static Intent createIntent(Context context, Artist artist) {
        Intent intent = new Intent(context, ConcertSearchActivity.class);
        intent.putExtra(INTENT_EXTRA_ARTIST, artist);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert_search);

        mArtist = (Artist) getIntent().getSerializableExtra(INTENT_EXTRA_ARTIST);

        setupToolbar();
        setupRecyclerView();

        mPresenter = new ConcertSearchPresenter();

        Toast.makeText(this, mArtist.getDisplayName(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.attach(this);
        mPresenter.search(mArtist);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.detach();
    }

    @Override
    public void refreshConcertList(List<Concert> concertList) {
        mAdapter.updateData(concertList);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.concert_search_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.concert_search_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ConcertSearchRecyclerViewAdapter(new ArrayList<Concert>());
        mRecyclerView.setAdapter(mAdapter);
    }
}