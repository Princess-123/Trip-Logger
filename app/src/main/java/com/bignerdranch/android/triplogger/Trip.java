package com.bignerdranch.android.triplogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;
import java.util.UUID;

/**
 * Created by princess123 on 22/10/2016.
 */
public class Trip {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private String mDestination;
    private String mDuration;
    private String mComment;
    private int mTripType;

    public Trip() {
        this(UUID.randomUUID());
    }
    public Trip(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date)
    {
        mDate = date;
    }

    public String getDestination() {
        return mDestination;
    }

    public void setDestination(String mDestination) {
        this.mDestination = mDestination;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String mDuration) {
        this.mDuration = mDuration;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String mComment) {
        this.mComment = mComment;
    }

    public int getTripType() {
        return mTripType;
    }

    public void setTripType(int mTripType) {
        this.mTripType = mTripType;
    }

    public String getPhotoFilename() {        return "IMG_" + getId().toString() + ".jpg";    }
}
