package com.example.xaviernara.newmindapp;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;


public class SettingsPreference extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.root_preferences);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){




        }

        return super.onOptionsItemSelected(item);
    }
}
