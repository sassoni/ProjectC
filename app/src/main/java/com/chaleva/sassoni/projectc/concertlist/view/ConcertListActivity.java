package com.chaleva.sassoni.projectc.concertlist.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.chaleva.sassoni.projectc.Concert;
import com.chaleva.sassoni.projectc.R;
import com.chaleva.sassoni.projectc.concertlist.presenter.ConcertListPresenter;
import com.chaleva.sassoni.projectc.artistsearch.view.ArtistSearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchaleva on 3/30/16.
 */
public class ConcertListActivity extends AppCompatActivity implements ConcertListView {

    private ConcertListPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ConcertListRecyclerViewAdapter mAdapter;

    private Button mTempButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert_list);

        mTempButton = (Button) findViewById(R.id.temp_btn);
        mTempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConcertListActivity.this, ArtistSearchActivity.class);
                startActivity(intent);
            }
        });

        setupToolbar();
        setupRecyclerView();

        mPresenter = new ConcertListPresenter();
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
    public void refreshConcertList(List<Concert> concerts) {
        mAdapter.updateData(concerts);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.concert_list_toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.concert_list_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ConcertListRecyclerViewAdapter(new ArrayList<Concert>());
        mRecyclerView.setAdapter(mAdapter);
    }

}
