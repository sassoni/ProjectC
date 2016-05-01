package com.chaleva.sassoni.projectc.concertsearch.model.songkick;

import android.content.Context;
import android.content.res.AssetManager;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.Concert;
import com.chaleva.sassoni.projectc.artistsearch.model.songkick.SongkickArtistSearchResponse;
import com.chaleva.sassoni.projectc.concertsearch.model.ConcertSearchProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by sassa on 4/30/16.
 */
public class SongkickMockConcertProviderImpl implements ConcertSearchProvider {
    private Context mContext;

    public SongkickMockConcertProviderImpl(Context context) {
        mContext = context;
    }

    private List<Concert> bruceSpringsteen() {
        List<Concert> concerts = new ArrayList<>();
        AssetManager manager = mContext.getAssets();
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream stream = manager.open("bruce_springsteen_concerts_page_1.json");
            SongkickConcertSearchResponse response = mapper.readValue(stream, SongkickConcertSearchResponse.class);
            concerts = response.getConcertList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return concerts;
    }

    @Override
    public Observable<List<Concert>> getConcertsForArtist(Artist artist) {
        return Observable.just(bruceSpringsteen());
    }
}
