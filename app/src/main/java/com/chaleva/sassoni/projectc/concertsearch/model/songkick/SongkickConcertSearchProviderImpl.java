package com.chaleva.sassoni.projectc.concertsearch.model.songkick;

import com.chaleva.sassoni.projectc.Artist;
import com.chaleva.sassoni.projectc.Concert;
import com.chaleva.sassoni.projectc.RetrofitInstance;
import com.chaleva.sassoni.projectc.concertsearch.model.ConcertSearchProvider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by sassa on 4/30/16.
 */
public class SongkickConcertSearchProviderImpl implements ConcertSearchProvider {


    private static GitHubService sService = RetrofitInstance.INSTANCE.getRetrofit().create(GitHubService.class);

    public interface GitHubService {
        @GET("artists/{artist_id}/gigography.json")
        Observable<SongkickConcertSearchResponse> getConcerts(@Path("artist_id") String artistId,
                                                              @Query("apikey") String apiKey);
    }

    @Override
    public Observable<List<Concert>> getConcertsForArtist(Artist artist) {
        return sService.getConcerts(artist.getId(), API_KEY)
                .map(new Func1<SongkickConcertSearchResponse, List<Concert>>() {
                    @Override
                    public List<Concert> call(SongkickConcertSearchResponse songkickConcertSearchResponse) {
//                        return songkickConcertSearchResponse.getConcertList();
                        return new ArrayList<Concert>();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
