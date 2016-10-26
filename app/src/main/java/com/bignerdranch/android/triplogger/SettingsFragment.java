package com.bignerdranch.android.triplogger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by princess123 on 25/10/2016.
 */

public class SettingsFragment extends Fragment {
    private Settings mSettings;
    private EditText mNameField;
    private EditText mIdField;
    private EditText mGenderField;
    private EditText mEmailField;
    private EditText mCommentField;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        mSettings = TripController.get(getActivity()).getSettings(0);

        if (mSettings == null) {
            mSettings = new Settings();
            TripController.get(getActivity()).addSettings(mSettings);
        }

        mNameField = (EditText) v.findViewById(R.id.settings_name_field);
        mNameField.setText(mSettings.getmName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSettings.setmName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mIdField = (EditText) v.findViewById(R.id.settings_id_field);
        mIdField.setText(mSettings.getmId());
        mIdField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSettings.setmId(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mGenderField = (EditText) v.findViewById(R.id.settings_gender_field);
        mGenderField.setText(mSettings.getmGender());
        mGenderField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSettings.setmGender(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEmailField = (EditText) v.findViewById(R.id.settings_email_field);
        mEmailField.setText(mSettings.getmEmail());
        mEmailField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSettings.setmEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCommentField = (EditText) v.findViewById(R.id.settings_comment_field);
        mCommentField.setText(mSettings.getmComment());
        mCommentField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSettings.setmComment(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        TripController.get(getActivity()).updateSettings(mSettings);
    }
}
