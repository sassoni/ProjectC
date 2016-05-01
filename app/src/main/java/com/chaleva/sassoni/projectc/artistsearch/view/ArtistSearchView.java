package com.chaleva.sassoni.projectc.artistsearch.view;

import com.chaleva.sassoni.projectc.Artist;

import java.util.List;

/**
 * Created by sassa on 4/6/16.
 */
public interface ArtistSearchView {

    void refreshArtistList(List<Artist> artistList);

    void openConcertSearchScreen(Artist artist);
}
