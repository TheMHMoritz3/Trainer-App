package com.german_software_engineers.trainerapp.Controller;

import android.support.annotation.NonNull;

import com.german_software_engineers.trainerapp.ExerciseView.Activity.ExerciseViewActivity;
import com.german_software_engineers.trainerappmodel.Model.Model;

public class ExerciseListModelController {
    private ExerciseViewActivity ExerciseView;
    private Model ApplicationModel;

    public ExerciseListModelController(@NonNull ExerciseViewActivity activity,@NonNull Model applicationModel){
        ApplicationModel=applicationModel;
        ExerciseView=activity;
    }

    public void moveExerciseUp(int position){
        ApplicationModel.moveExerciseOfActiveScheduleUp(position);
        ExerciseView.updateView();
    }

    public void moveExerciseDown(int position){
        ApplicationModel.moveExerciseOfActiveScheduleDown(position);
        ExerciseView.updateView();
    }

    public void deleteExercise(int position){
        ApplicationModel.deleteExerciseOfActiveSchedule(position);
        ExerciseView.updateView();
    }

}
