package com.german_software_engineers.trainerapp.ExerciseView;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.german_software_engineers.trainerappmodel.Enumerations.ExerciseType;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;
import com.german_software_engineers.trainerappmodel.Model.Schedule;

public class ExerciseViewModel extends ViewModel {
    private Exercise ActiveExcercise;
    private Schedule ActiveSchedule;
    private MutableLiveData<ExerciseType> ActiveExerciseType = new MutableLiveData<>();

    public ExerciseViewModel(Schedule schedule, Exercise exercise){
        ActiveSchedule = schedule;
        ActiveExcercise = exercise;
    }

    void typeChanged(int chosenType){
        ActiveExerciseType.postValue(ExerciseType.values()[chosenType]);
    }

    public LiveData<ExerciseType> getExerciseTypeLiveData(){
        return ActiveExerciseType;
    }

    public ExerciseType getExerciseType(){
        return ActiveExerciseType.getValue();
    }
}
