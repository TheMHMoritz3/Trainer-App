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

import com.german_software_engineers.trainerapp.Model.Intensities;
import com.german_software_engineers.trainerapp.Model.Schedule;
import com.german_software_engineers.trainerapp.Model.ScheduleAvailableException;
import com.german_software_engineers.trainerapp.Model.TrainingsTypes;

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
        if(addScheduleToModel()) {
            Intent intent = new Intent(this, AddExerciseActivity.class);
            intent.putExtra("scheduleName", ((EditText) findViewById(R.id.nameTextEdit)).getText().toString());
            startActivity(intent);
        }
    }

    private boolean addScheduleToModel(){
        if(((EditText)findViewById(R.id.nameTextEdit)).getText().toString().isEmpty())
        {
            ((EditText)findViewById(R.id.nameTextEdit)).setError("Please type a name in");
            return false;
        }

        if(((EditText)findViewById(R.id.excEdit)).getText().toString().isEmpty())
        {
            ((EditText)findViewById(R.id.excEdit)).setError("Please Type in a warmup Excercise");
            return false;
        }

        Integer reps = 0;
        if(!((EditText)findViewById(R.id.repEdit)).getText().toString().isEmpty())
            reps = Integer.valueOf(((EditText)findViewById(R.id.repEdit)).getText().toString());

        Integer pause = 0;
        if(!((EditText)findViewById(R.id.pauseEdit)).getText().toString().isEmpty())
            pause = Integer.valueOf((((EditText)findViewById(R.id.pauseEdit)).getText().toString()));

        Integer sets = 0;
        if(!((EditText)findViewById(R.id.setEdit)).getText().toString().isEmpty())
            sets = Integer.valueOf(((EditText)findViewById(R.id.setEdit)).getText().toString());

        Integer speed = 0;
        if(!((EditText)findViewById(R.id.speedEdit)).getText().toString().isEmpty())
            speed = Integer.valueOf(((EditText)findViewById(R.id.speedEdit)).getText().toString());

        Integer warmUpTime = 0;
        if(!((EditText)findViewById(R.id.timeEdit)).getText().toString().isEmpty())
            warmUpTime = Integer.valueOf(((EditText)findViewById(R.id.timeEdit)).getText().toString());

        Integer warmUpBPM = 0;
        if(!((EditText)findViewById(R.id.repEdit)).getText().toString().isEmpty())
            warmUpBPM = Integer.valueOf(((EditText)findViewById(R.id.bpmEdit)).getText().toString());


        Schedule schedule = new Schedule(((EditText)findViewById(R.id.nameTextEdit)).getText().toString(),
                TrainingsTypes.values()[(int)((Spinner)findViewById(R.id.trainSpinner)).getSelectedItemId()],
                reps.intValue(), pause.intValue(), sets.intValue(), speed.intValue(),
                ((EditText)findViewById(R.id.excEdit)).getText().toString(),
                warmUpTime.intValue(),
                Intensities.values()[(int)((Spinner)findViewById(R.id.intenSpinner)).getSelectedItemId()],
                warmUpBPM.intValue());
        try {
            ApplicationHandler.getModel().addSchedule(schedule);
        } catch (ScheduleAvailableException e) {
            e.printStackTrace();
        }
        return true;
    }
}
