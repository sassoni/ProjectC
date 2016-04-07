package com.chaleva.sassoni.projectc.artistsearch.model.songkick;

import java.util.ArrayList;
import java.util.List;

import com.chaleva.sassoni.projectc.Artist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sassa on 4/5/16.
 */
public class SongkickArtistSearchResponse {

    @JsonProperty("resultsPage")
    private ResultsPage mResultsPage;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ResultsPage {
        @JsonProperty("status")
        private String mStatus;
        @JsonProperty("results")
        private Results mResults;
        @JsonProperty("perPage")
        private int mPerPage;
        @JsonProperty("page")
        private int mPage;
        @JsonProperty("totalEntries")
        private int mTotalEntries;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Results {
        @JsonProperty("artist")
        private List<ArtistInstance> mArtists;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ArtistInstance {
        @JsonProperty("id")
        private long mId;
        @JsonProperty("displayName")
        private String mDisplayName;
        @JsonProperty("uri")
        private String mUri;
        @JsonProperty("onTourUntil")
        private String mOnTourUntil;
    }

    public List<Artist> getArtistList() {
        List<Artist> artists = new ArrayList<>();
        if (mResultsPage.mResults.mArtists != null &&
                mResultsPage.mResults.mArtists.size() != 0) {
            for (ArtistInstance instance : mResultsPage.mResults.mArtists) {
                Artist artist = new Artist();
                artist.setDisplayName(instance.mDisplayName);
                artists.add(artist);
            }
        }
        return artists;
    }

}
