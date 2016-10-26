package com.bignerdranch.android.triplogger;

import android.support.v4.app.Fragment;

/**
 * Created by princess123 on 22/10/2016.
 */
public class TripListActivity extends SingleFragmentActivity {
    //@Override
    protected Fragment createFragment() {

        return new TripListFragment();
    }
}
