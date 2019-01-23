package com.german_software_engineers.trainerapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.german_software_engineers.trainerapp.ExerciseView.EditExerciseActivity;
import com.german_software_engineers.trainerapp.ExerciseView.ExerciseDialog;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;
import com.german_software_engineers.trainerappmodel.Model.Schedule;
import com.german_software_engineers.trainerappmodel.Exceptions.ScheduleAvailableException;

import java.io.FileOutputStream;

public class ExerciseViewActivity extends ExerciseListActivity  {

    String ScheduleName;
    ExcersizeListFragment fragment;
    Schedule ActiveSchedule;
    Dialog scheduleDialog;
    Dialog exceriseDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExcersize();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ScheduleName = intent.getStringExtra("scheduleName");

        //TODO Application Context
//        try {
//            ActiveSchedule = ApplicationHandler.getModel().getSchedule(ScheduleName);
//        } catch (ScheduleAvailableException e) {
//            e.printStackTrace();
//        }

        setTitle(ActiveSchedule.getName());

    }


    @Override
    protected void onStart()
    {
        fragment = ExcersizeListFragment.newInstance(1,ScheduleName);
        getSupportFragmentManager().beginTransaction().replace(R.id.execView, fragment ).commit();

        TextView ScheduleInfo = (TextView)findViewById(R.id.ScheduleInfo);
        ScheduleInfo.setText(getResources().getString(R.string.ScheduleInfo,ActiveSchedule.getRepetitions(),ActiveSchedule.getPauseTime(),ActiveSchedule.getSets(),ActiveSchedule.getSpeed()));

        super.onStart();
    }


    public void addExcersize(){
        ExerciseDialog dialog = new ExerciseDialog();
//        try {
//            dialog.setSchedule(ApplicationHandler.getModel().getSchedule(ScheduleName));
//        } catch (ScheduleAvailableException e) {
//            e.printStackTrace();
//        }
//        dialog.show(getSupportFragmentManager(),"ExerciseDialog");
    }

    public void startEditOfSchedule(){
//        ApplicationHandler.getModel().deleteSchedule(ActiveSchedule.getName());
        //TODO Application Context saving File
//        try {
//            FileOutputStream outputStream = openFileOutput(ApplicationHandler.FileName, MODE_PRIVATE);
//            String  value = ApplicationHandler.getModel().getGson();
//            outputStream.write(value.getBytes());
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        finish();

    }

    @Override
    public void onListFragmentInteraction(Exercise item) {
        Intent intent = new Intent(this, EditExerciseActivity.class);
        intent.putExtra("scheduleName", ActiveSchedule.getName());
        intent.putExtra("excName", item.getName());
        startActivity(intent);
    }

    public void updateSchedule(){

    }
}
