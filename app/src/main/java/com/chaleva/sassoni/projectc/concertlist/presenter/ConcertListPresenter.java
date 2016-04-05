package com.chaleva.sassoni.projectc.concertlist.presenter;

import com.chaleva.sassoni.projectc.Concert;
import com.chaleva.sassoni.projectc.concertlist.model.ConcertListProvider;
import com.chaleva.sassoni.projectc.concertlist.model.ConcertListProviderImpl;
import com.chaleva.sassoni.projectc.concertlist.view.ConcertListView;

import java.util.List;

/**
 * Created by cchaleva on 3/30/16.
 */
public class ConcertListPresenter {

    private ConcertListView mView;
    private ConcertListProvider mProvider;

    public ConcertListPresenter() {
        mProvider = new ConcertListProviderImpl();
    }

    public void attach(ConcertListView view) {
        mView = view;
        mView.refreshConcertList(loadConcerts());
    }

    public void detach() {
        mView = null;
    }

    private List<Concert> loadConcerts() {
        return mProvider.loadConcerts();
    }
}
