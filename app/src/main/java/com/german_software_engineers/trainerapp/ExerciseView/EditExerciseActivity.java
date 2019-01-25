package com.german_software_engineers.trainerapp.ExerciseView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.german_software_engineers.trainerapp.Controller.ApplicationManager;
import com.german_software_engineers.trainerapp.R;
import com.german_software_engineers.trainerappmodel.Exceptions.ScheduleAvailableException;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;
import com.german_software_engineers.trainerappmodel.Model.Schedule;

import java.io.FileOutputStream;

public class EditExerciseActivity extends AppCompatActivity implements DeviceExerciseFragment.OnFragmentInteractionListener {
    ExerciseViewModel ViewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateExc();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        getNessearyData(intent.getStringExtra("scheduleName"),intent.getStringExtra("excName"));
    }

    private void getNessearyData(String scheduleName, String excName) {
        Schedule sched=null;
        try {
            sched= ((ApplicationManager)getApplicationContext()).getApplicationModel().getSchedule(scheduleName);
        } catch (ScheduleAvailableException e) {
            e.printStackTrace();
        }
        Exercise exercise=null;
        if(!excName.isEmpty()) {
            if (sched != null) {
                for (Exercise exc : sched.exercises()) {
                    if (exc.getName().equals(excName)) {
                        exercise = exc;
                        updateGui();
                        return;
                    }
                }
            }
        }
        ViewModel=new ExerciseViewModel(sched,exercise);
        ViewModel.getExerciseTypeLiveData().observe(this, observer -> {
            updateGui();
        });

        DeviceExerciseFragment deviceExerciseFragment = DeviceExerciseFragment.newInstance("test","test");
        getSupportFragmentManager().beginTransaction().replace(R.id.ExerciseFragment, deviceExerciseFragment ).commit();
    }

    private void updateGui(){
        switch (ViewModel.getExerciseType()){
            case WarmUp:

                break;
                default:
            case Device:

                break;
            case BodyWeight:

                break;
        }
    }

    private void updateExc(){

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
