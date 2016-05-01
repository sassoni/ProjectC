package com.chaleva.sassoni.projectc;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by cchaleva on 3/30/16.
 */
public class Concert {
//    private String mId;
//    private String mType;
    private String mDisplayName;
//    private String mDate;

//    private static class Venue {
//        private long mDisplayName;
//        private String mLat;
//        private String mLon;
//        private String mUri;
//        private long mId;
//        private long mMetroArea;
//    }
    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String name) {
        mDisplayName = name;
    }

}

