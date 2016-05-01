package com.chaleva.sassoni.projectc.concertsearch.view;

import com.chaleva.sassoni.projectc.Concert;

import java.util.List;

/**
 * Created by sassa on 4/10/16.
 */
public interface ConcertSearchView {

    void refreshConcertList(List<Concert> concertList);
}
