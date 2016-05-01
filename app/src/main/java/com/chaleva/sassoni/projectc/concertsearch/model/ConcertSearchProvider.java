package com.chaleva.sassoni.projectc.concertsearch.model;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.Concert;

import java.util.List;

import rx.Observable;

/**
 * Created by sassa on 4/10/16.
 */
public interface ConcertSearchProvider {

    Observable<List<Concert>> getConcertsForArtist(Artist artist);
}
