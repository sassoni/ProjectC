package com.chaleva.sassoni.projectc.concertsearch.model.songkick;

import com.chaleva.sassoni.projectc.Concert;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sassa on 4/30/16.
 */
public class SongkickConcertSearchResponse {

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
        @JsonProperty("event")
        private List<Event> mEvents;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Event {
        @JsonProperty("type")
        private String mType;
        @JsonProperty("displayName")
        private String mDisplayName;
        @JsonProperty("start")
        private Start start;
        @JsonProperty("location")
        private Location location;
        @JsonProperty("performance")
        private List<Performance> mPerformances;
        @JsonProperty("venue")
        private Venue mVenue;
        @JsonProperty("uri")
        private String mUri;
        @JsonProperty("id")
        private long mId;
        @JsonProperty("popularity")
        private float mPopularity;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Start {
        @JsonProperty("datetime")
        private String mDatetime;
        @JsonProperty("time")
        private String mTime;
        @JsonProperty("date")
        private String mDate;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Location {
        @JsonProperty("city")
        private String mCity;
        @JsonProperty("lat")
        private String mLat;
        @JsonProperty("lng")
        private String mLon;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Performance {
        @JsonProperty("artist")
        private Artist mArtist;
        @JsonProperty("displayName")
        private String mDisplayName;
        @JsonProperty("id")
        private String mId;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Artist {
        @JsonProperty("id")
        private long mId;
        @JsonProperty("displayName")
        private String mDisplayName;
        @JsonProperty("uri")
        private String mUri;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Venue {
        @JsonProperty("displayName")
        private String mDisplayName;
        @JsonProperty("lat")
        private String mLat;
        @JsonProperty("lng")
        private String mLon;
        @JsonProperty("uri")
        private String mUri;
        @JsonProperty("id")
        private long mId;
        @JsonProperty("metroArea")
        private MetroArea mMetroArea;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class MetroArea {
        @JsonProperty("displayName")
        private String mDisplayName;
        @JsonProperty("uri")
        private String mUri;
        @JsonProperty("id")
        private long mId;
        @JsonProperty("state")
        private State mState;
        @JsonProperty("country")
        private Country mCountry;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class State {
        @JsonProperty("displayName")
        private String mDisplayName;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Country {
        @JsonProperty("displayName")
        private String mDisplayName;
    }

    public List<Concert> getConcertList() {
        List<Concert> concerts = new ArrayList<>();
        if (mResultsPage.mResults.mEvents != null &&
                mResultsPage.mResults.mEvents.size() != 0) {
            for (Event event : mResultsPage.mResults.mEvents) {
                Concert concert = new Concert();
                concert.setDisplayName(event.mDisplayName);
                concerts.add(concert);
            }
        }
        return concerts;
    }
}
