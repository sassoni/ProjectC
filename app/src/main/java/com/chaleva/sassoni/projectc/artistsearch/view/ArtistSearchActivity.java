package com.chaleva.sassoni.projectc.artistsearch.view;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.R;
import com.chaleva.sassoni.projectc.artistsearch.presenter.ArtistSearchPresenter;

import java.util.ArrayList;
import java.util.List;

public class ArtistSearchActivity extends AppCompatActivity implements ArtistSearchView {

    private ArtistSearchPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArtistSearchRecyclerViewAdapter mAdapter;

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_search);

        mEditText = (EditText) findViewById(R.id.edit_text);

        setupToolbar();
        setupRecyclerView();

        mPresenter = new ArtistSearchPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.attach(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.detach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.artist_search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                mPresenter.search(mEditText.getText().toString());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void refreshArtistList(List<Artist> artistList) {
        mAdapter.updateData(artistList);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_search_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.artist_search_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ArtistSearchRecyclerViewAdapter(new ArrayList<Artist>());
        mRecyclerView.setAdapter(mAdapter);
    }
}
