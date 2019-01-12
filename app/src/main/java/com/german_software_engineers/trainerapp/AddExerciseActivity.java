package com.german_software_engineers.trainerapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.german_software_engineers.trainerapp.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class AddExerciseActivity extends AppCompatActivity implements ExcersizeListFragment.OnListFragmentInteractionListener {

    private RecyclerView ExerciseView;

    private List<DummyContent.DummyItem> items = new ArrayList<DummyContent.DummyItem>();
    private MyExcersizeRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_excersize_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DummyContent.DummyItem item = new DummyContent.DummyItem("test","test", "this is a test");
        items.add(item);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openExerciseDialog();
//            }
//        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new MyExcersizeRecyclerViewAdapter(items,this);
        ExerciseView = (RecyclerView)findViewById(R.id.list);
        ExerciseView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_exercise_menu, menu);
        return true;
    }

    public void openExerciseDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(R.layout.exersice_dialog)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        Dialog newFragment = builder.create();
        newFragment.show();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
