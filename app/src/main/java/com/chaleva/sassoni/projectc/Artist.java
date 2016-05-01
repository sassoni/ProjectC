package com.chaleva.sassoni.projectc;

import java.io.Serializable;

/**
 * Created by sassa on 4/5/16.
 */
// TODO Parcelable instead
public class Artist implements Serializable {
    private String mDisplayName;
    private String mId;

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }
}
