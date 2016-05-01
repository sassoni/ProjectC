package com.chaleva.sassoni.projectc.artistsearch.model.songkick;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.RetrofitInstance;
import com.chaleva.sassoni.projectc.artistsearch.model.ArtistSearchProvider;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by sassa on 4/5/16.
 */
public class SongkickArtistSearchProviderImpl implements ArtistSearchProvider {

    private static GitHubService sService = RetrofitInstance.INSTANCE.getRetrofit().create(GitHubService.class);

    public interface GitHubService {
        @GET("search/artists.json")
        Observable<SongkickArtistSearchResponse> getArtists(@Query("query") String searchTerm,
                                                            @Query("apikey") String apiKey);
    }

    @Override
    public Observable<List<Artist>> getArtistsForSearchTerm(String searchTerm) {
        return sService.getArtists(searchTerm, API_KEY)
                .map(new Func1<SongkickArtistSearchResponse, List<Artist>>() {
                    @Override
                    public List<Artist> call(SongkickArtistSearchResponse songkickArtistSearchResponse) {
                        return songkickArtistSearchResponse.getArtistList();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}