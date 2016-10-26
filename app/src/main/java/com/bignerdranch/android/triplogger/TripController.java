package com.bignerdranch.android.triplogger;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.bignerdranch.android.triplogger.database.TripBaseHelper;
import com.bignerdranch.android.triplogger.database.TripCursorWrapper;
import com.bignerdranch.android.triplogger.database.TripDbSchema;
import com.bignerdranch.android.triplogger.database.TripDbSchema.SettingsTable;
import com.bignerdranch.android.triplogger.database.TripDbSchema.TripTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by princess123 on 22/10/2016.
 */
public class TripController {
    private static TripController sTripController;

    private Context mContext;
    private SQLiteDatabase mDatabase;
    public static TripController get(Context context) {
        if (sTripController == null) {
            sTripController = new TripController(context);
        }
        return sTripController;
    }

    private TripController(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new TripBaseHelper(mContext)
                .getWritableDatabase();

    }

    public void addTrip(Trip c) {
        ContentValues values = getContentValues(c);

        mDatabase.insert(TripTable.NAME, null, values);
    }

    public List<Trip> getTrips() {
        {
            List<Trip> trips = new ArrayList<>();
            TripCursorWrapper cursor = queryTrips(null, null);
            try {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    trips.add(cursor.getTrip());
                    cursor.moveToNext();
                }
            } finally {
                cursor.close();
            }

            return trips;
        }
    }

    public Trip getTrip(UUID id) {
        TripCursorWrapper cursor = queryTrips(
                TripTable.Cols.UUID + " = ?",
                new String[] { id.toString() }

        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getTrip();
        } finally {
            cursor.close();
        }

    }
    public File getPhotoFile(Trip trip) {
        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null)
        {            return null;        }
        return new File(externalFilesDir, trip.getPhotoFilename());    }


    public void updateTrip(Trip trip) {
        String uuidString = trip.getId().toString();
        ContentValues values = getContentValues(trip);

        mDatabase.update(TripTable.NAME, values,
                TripTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    public void deleteTrip(Trip trip) {
        String uuidString = trip.getId().toString();
        mDatabase.delete(TripTable.NAME, TripTable.Cols.UUID + " = ?", new String[]{uuidString});
    }

    private static ContentValues getContentValues(Trip trip) {
        ContentValues values = new ContentValues();
        values.put(TripTable.Cols.UUID, trip.getId().toString());
        values.put(TripTable.Cols.TITLE, trip.getTitle());
        values.put(TripTable.Cols.DATE, trip.getDate().getTime());
        values.put(TripTable.Cols.DESTINATION, trip.getDestination());
        values.put(TripTable.Cols.DURATION, trip.getDuration());
        values.put(TripTable.Cols.COMMENT, trip.getComment());

        return values;
    }


    private TripCursorWrapper queryTrips(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                TripTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );

        return new TripCursorWrapper(cursor);
    }

    public void addSettings(Settings c) {
        ContentValues values = getSettingsContentValues(c);

        mDatabase.insert(SettingsTable.NAME, null, values);
    }

    private static ContentValues getSettingsContentValues(Settings settings) {
        ContentValues values = new ContentValues();
        values.put(SettingsTable.Cols.UUID, settings.getmUUID());
        values.put(SettingsTable.Cols.NAME, settings.getmName());
        values.put(SettingsTable.Cols.ID, settings.getmId());
        values.put(SettingsTable.Cols.GENDER, settings.getmGender());
        values.put(SettingsTable.Cols.EMAIL, settings.getmEmail());
        values.put(SettingsTable.Cols.COMMENT, settings.getmComment());

        return values;
    }

    public void updateSettings(Settings settings) {
        int uuidString = settings.getmUUID();
        ContentValues values = getSettingsContentValues(settings);

        mDatabase.update(SettingsTable.NAME, values,
                SettingsTable.Cols.UUID + " = ?",
                new String[]{String.valueOf(uuidString)});
    }
    private TripCursorWrapper querySettings(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                SettingsTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new TripCursorWrapper(cursor);
    }
    public Settings
    getSettings(int uuid) {
        TripCursorWrapper cursor = querySettings(
                SettingsTable.Cols.UUID + " = ?",
                new String[] { String.valueOf(uuid) }
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getSettings();
        } finally {
            cursor.close();
        }
    }
}