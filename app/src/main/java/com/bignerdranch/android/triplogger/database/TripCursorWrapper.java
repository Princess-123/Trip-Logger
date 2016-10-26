package com.bignerdranch.android.triplogger.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.triplogger.Settings;
import com.bignerdranch.android.triplogger.Trip;
import com.bignerdranch.android.triplogger.database.TripDbSchema.TripTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by princess123 on 22/10/2016.
 */

public class TripCursorWrapper extends CursorWrapper {
    public TripCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Trip getTrip() {
        String uuidString = getString(getColumnIndex(TripTable.Cols.UUID));
        String title = getString(getColumnIndex(TripTable.Cols.TITLE));
        long date = getLong(getColumnIndex(TripTable.Cols.DATE));
        String destination = getString(getColumnIndex(TripTable.Cols.DESTINATION));
        String duration = getString(getColumnIndex(TripTable.Cols.DURATION));
        String comment = getString(getColumnIndex(TripTable.Cols.COMMENT));
        int triptype = getInt(getColumnIndex(TripTable.Cols.TRIPTYPE));

        Trip trip = new Trip(UUID.fromString(uuidString));
        trip.setTitle(title);
        trip.setDate(new Date(date));
        trip.setDestination(destination);
        trip.setDuration(duration);
        trip.setComment(comment);
        trip.setTripType(triptype);
        return trip;
    }

    public Settings getSettings() {
        String id = getString(getColumnIndex(TripDbSchema.SettingsTable.Cols.ID));
        String name = getString(getColumnIndex(TripDbSchema.SettingsTable.Cols.NAME));
        String email = getString(getColumnIndex(TripDbSchema.SettingsTable.Cols.EMAIL));
        String gender = getString(getColumnIndex(TripDbSchema.SettingsTable.Cols.GENDER));
        String comment = getString(getColumnIndex(TripDbSchema.SettingsTable.Cols.COMMENT));

        Settings settings = new Settings();
        settings.setmName(name);
        settings.setmId(id);
        settings.setmGender(gender);
        settings.setmEmail(email);
        settings.setmComment(comment);

        return settings;
    }
}
