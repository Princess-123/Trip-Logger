package com.bignerdranch.android.triplogger;

import java.util.Date;
import java.util.UUID;

/**
 * Created by princess123 on 25/10/2016.
 */

public class Settings {
    private int mUUID = 0;
    private String mName = "Pragati";
    private String mId = "1074889";
    private String mEmail = "something@example.com";
    private String mGender = "female";
    private String mComment = "comment";

    public int getmUUID() {
        return mUUID;
    }

    public void setmUUID(int mUUID) {
        this.mUUID = mUUID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComment(String mComment) {
        this.mComment = mComment;
    }
}
