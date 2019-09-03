package com.german_software_engineers.trainerapp.ExerciseView.ViewModel;

import android.arch.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Exercise.Exercise;

public class CircleExerciseViewModel extends ViewModel {

    public List<Exercise> getExercises(){
        return new ArrayList<Exercise>();
    }
}
