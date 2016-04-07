package com.chaleva.sassoni.projectc.artistsearch.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.R;
import com.chaleva.sassoni.projectc.artistsearch.presenter.ArtistSearchPresenter;

import java.util.List;

public class ArtistSearchActivity extends AppCompatActivity implements ArtistSearchView {

    private ArtistSearchPresenter mPresenter;

    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert_search);

        mEditText = (EditText) findViewById(R.id.edit_text);
        mButton = (Button) findViewById(R.id.search_btn);

        mPresenter = new ArtistSearchPresenter();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.search(mEditText.getText().toString());
            }
        });
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
    public void refreshArtistList(List<Artist> artistList) {
        Log.i("GGGG", "refreshing");
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.concert_list_menu, menu);
//
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//
//        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setIconifiedByDefault(true);
//        return true;
//    }

}
