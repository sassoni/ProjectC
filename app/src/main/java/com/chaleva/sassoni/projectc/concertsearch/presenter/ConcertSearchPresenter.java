package com.chaleva.sassoni.projectc.concertsearch.presenter;

import android.content.Context;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.Concert;
import com.chaleva.sassoni.projectc.concertsearch.model.ConcertSearchProvider;
import com.chaleva.sassoni.projectc.concertsearch.model.songkick.SongkickConcertSearchProviderImpl;
import com.chaleva.sassoni.projectc.concertsearch.model.songkick.SongkickMockConcertProviderImpl;
import com.chaleva.sassoni.projectc.concertsearch.view.ConcertSearchView;

import java.util.List;

import rx.Observer;
import rx.Subscription;

/**
 * Created by sassa on 4/10/16.
 */
public class ConcertSearchPresenter implements Observer<List<Concert>> {

    private ConcertSearchView mView;
    private ConcertSearchProvider mProvider;
    private Subscription mSubscription;

    public ConcertSearchPresenter() {
//        mProvider = new SongkickConcertSearchProviderImpl();
    }

    public void attach(ConcertSearchView view) {
        mView = view;
        mProvider = new SongkickMockConcertProviderImpl((Context) mView);  // temp
    }

    public void detach() {
        mView = null;
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }

    public void search(Artist artist) {
        mSubscription = mProvider.getConcertsForArtist(artist).subscribe(this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(List<Concert> concerts) {
        if (mView != null) {
            mView.refreshConcertList(concerts);
        }
    }
}
