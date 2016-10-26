package com.bignerdranch.android.triplogger;

import android.support.v4.app.Fragment;

/**
 * Created by princess123 on 25/10/2016.
 */

public class SettingsActivity extends SingleFragmentActivity {
    protected Fragment createFragment() {

        return new SettingsFragment();
    }
}
