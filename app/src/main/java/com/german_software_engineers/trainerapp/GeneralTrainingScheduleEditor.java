package com.german_software_engineers.trainerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class GeneralTrainingScheduleEditor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_training_schedule_editor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextActivity();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void openNextActivity(){
        Intent intent = new Intent(this, AddExerciseActivity.class);
        intent.putExtra("scheduleName", ((EditText)findViewById(R.id.nameTextEdit)).getText().toString());
        intent.putExtra("trainingsType", ((Spinner)findViewById(R.id.trainSpinner)).getId());
        intent.putExtra("repeations", ((EditText)findViewById(R.id.repEdit)).getText().toString());
        intent.putExtra("pause", ((EditText)findViewById(R.id.pauseEdit)).getText().toString());
        intent.putExtra("set", ((EditText)findViewById(R.id.setEdit)).getText().toString());
        intent.putExtra("speed", ((EditText)findViewById(R.id.speedEdit)).getText().toString());
        intent.putExtra("WarmUpExe", ((EditText)findViewById(R.id.excEdit)).getText().toString());
        intent.putExtra("WarmUpTime", ((EditText)findViewById(R.id.timeEdit)).getText().toString());
        intent.putExtra("WarmUpIntensity", ((Spinner)findViewById(R.id.intenSpinner)).getId());
        intent.putExtra("WarmUpBpm", ((EditText)findViewById(R.id.bpmEdit)).getText().toString());
        startActivity(intent);
    }

}
