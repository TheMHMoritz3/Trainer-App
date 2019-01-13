package com.german_software_engineers.trainerapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.german_software_engineers.trainerapp.Model.Exercise;
import com.german_software_engineers.trainerapp.Model.Schedule;
import com.german_software_engineers.trainerapp.Model.ScheduleAvailableException;

public class AddExerciseActivity extends AppCompatActivity implements ExcersizeListFragment.OnListFragmentInteractionListener {

    String ScheduleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finished();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ScheduleName = intent.getStringExtra("scheduleName");
        ExcersizeListFragment fragment = ExcersizeListFragment.newInstance(1,ScheduleName);
        getSupportFragmentManager().beginTransaction().replace(R.id.excEdit, fragment ).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_exercise_menu, menu);
        return true;
    }

    public void openExerciseDialog(){
        ExerciseDialog dialog = new ExerciseDialog();
        dialog.show(getSupportFragmentManager(),"ExerciseDialog");
        Exercise exc = dialog.getExc();
        if(exc!=null) {
            try {
                ApplicationHandler.getModel().getSchedule(ScheduleName).addExercise(exc);
            } catch (ScheduleAvailableException e) {
                e.printStackTrace();
            }
        }else
        {
            Log.i("openExerciseDialog","Somethings Wrong");
        }
    }

    @Override
    public void onListFragmentInteraction(Exercise item) {

    }

    public void finished(){
        Intent intent = new Intent(this, TrainingScheduleEditor.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_addExercise:
                openExerciseDialog();
                return true;
            case R.id.action_settings:
                //showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
