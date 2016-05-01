package com.chaleva.sassoni.projectc.artistsearch.model.songkick;

import android.content.Context;
import android.content.res.AssetManager;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.artistsearch.model.ArtistSearchProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Temp class
 * Created by sassa on 4/6/16.
 */
public class SongkickMockArtistSearchProviderImpl implements ArtistSearchProvider {

    private Context mContext;

    public SongkickMockArtistSearchProviderImpl(Context context) {
        mContext = context;
    }

    @Override
    public Observable<List<Artist>> getArtistsForSearchTerm(String searchTerm) {
        return Observable.just(bruceSpringsteen());
    }

    private List<Artist> bruceSpringsteen() {
        List<Artist> artists = new ArrayList<>();
        AssetManager manager = mContext.getAssets();
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream stream = manager.open("bruce_springsteen.json");
            SongkickArtistSearchResponse response = mapper.readValue(stream, SongkickArtistSearchResponse.class);
            artists = response.getArtistList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return artists;
    }
}
