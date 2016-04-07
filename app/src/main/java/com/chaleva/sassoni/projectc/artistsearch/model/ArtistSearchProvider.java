package com.chaleva.sassoni.projectc.artistsearch.model;

import com.chaleva.sassoni.projectc.Artist;

import java.util.List;

import rx.Observable;

/**
 * Created by sassa on 4/5/16.
 */
public interface ArtistSearchProvider {

    Observable<List<Artist>> getArtistsForSearchTerm(String searchTerm);
}
