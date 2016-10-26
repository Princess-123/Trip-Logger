package com.bignerdranch.android.triplogger;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by princess123 on 22/10/2016.
 */
import java.util.UUID;

/**
 * Created by princess123 on 22/10/2016.
 */
public class TripActivity extends SingleFragmentActivity {

    private static final String EXTRA_TRIP_ID =
            "com.bignerdranch.android.triplogger.trip_id";

    public static Intent newIntent(Context packageContext, UUID tripId) {
        Intent intent = new Intent(packageContext, TripActivity.class);
        intent.putExtra(EXTRA_TRIP_ID, tripId);
        return intent;

    }
    @Override
    protected Fragment createFragment() {
        UUID tripId = (UUID) getIntent().getSerializableExtra(EXTRA_TRIP_ID);

        return TripFragment.newInstance(tripId);    }
}
