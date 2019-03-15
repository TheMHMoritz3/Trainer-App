package com.german_software_engineers.trainerapp.SettingsView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.german_software_engineers.trainerapp.R;
import com.german_software_engineers.trainerapp.SettingsView.ui.settings.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SettingsFragment.newInstance())
                    .commitNow();
        }
    }
}
