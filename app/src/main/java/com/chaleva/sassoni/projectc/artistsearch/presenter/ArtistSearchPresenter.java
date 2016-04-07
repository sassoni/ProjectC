package com.chaleva.sassoni.projectc.artistsearch.presenter;

import android.content.Context;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.artistsearch.model.ArtistSearchProvider;
import com.chaleva.sassoni.projectc.artistsearch.model.songkick.SongkickArtistSearchProviderImpl;
import com.chaleva.sassoni.projectc.artistsearch.model.songkick.SongkickMockArtistSearchProviderImpl;
import com.chaleva.sassoni.projectc.artistsearch.view.ArtistSearchView;

import java.util.List;

import rx.Observer;
import rx.Subscription;

/**
 * Created by sassa on 4/6/16.
 */
public class ArtistSearchPresenter implements Observer<List<Artist>> {

    private ArtistSearchView mView;
    private ArtistSearchProvider mProvider;
    private Subscription mSubscription;

    public ArtistSearchPresenter() {
//        mProvider = new SongkickArtistSearchProviderImpl();
    }

    public void attach(ArtistSearchView view) {
        mView = view;
        mProvider = new SongkickMockArtistSearchProviderImpl((Context) mView);  // temp
    }

    public void detach() {
        mView = null;
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }

    public void search(String searchTerm) {
        mSubscription = mProvider.getArtistsForSearchTerm(searchTerm).subscribe(this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(List<Artist> artists) {
        if (mView != null) {
            mView.refreshArtistList(artists);
        }
    }
}
