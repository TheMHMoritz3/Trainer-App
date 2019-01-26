package com.german_software_engineers.trainerapp.ExerciseView.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.german_software_engineers.trainerappmodel.Enumerations.ExerciseType;
import com.german_software_engineers.trainerappmodel.Exercise.BodyWeightExercise;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;
import com.german_software_engineers.trainerappmodel.Model.Schedule;

public class ExerciseViewModel extends ViewModel {
    private Exercise ActiveExcercise;
    private Schedule ActiveSchedule;
    private MutableLiveData<ExerciseType> ActiveExerciseType = new MutableLiveData<>();
    public MutableLiveData<String> ExerciseName = new MutableLiveData<>();

    private DeviceExerciseViewModel DeviceExerciseViewModel = null;
    private BodyWeightExerciseViewModel BodyWeightExerciseViewModel = null;
    private WarmUpExerciseViewModel WarmUpExerciseViewModel = null;

    public ExerciseViewModel(Schedule schedule, Exercise exercise){
        ActiveSchedule = schedule;
        ActiveExcercise = exercise;
        DeviceExerciseViewModel = new DeviceExerciseViewModel(exercise);
        BodyWeightExerciseViewModel = new BodyWeightExerciseViewModel(exercise);
        WarmUpExerciseViewModel = new WarmUpExerciseViewModel(exercise);
        setRequiredValues();
    }

    private void setRequiredValues(){
        if(ActiveExcercise==null){
            ExerciseName.postValue("");
        }else{
            ExerciseName.postValue(ActiveExcercise.getName());
        }
    }

    public void typeChanged(int chosenType){
        ActiveExerciseType.postValue(ExerciseType.values()[chosenType]);
    }

    public LiveData<ExerciseType> getExerciseTypeLiveData(){
        return ActiveExerciseType;
    }

    public ExerciseType getExerciseType(){
        return ActiveExerciseType.getValue();
    }

    public void addExercise(){

    }


    public DeviceExerciseViewModel getDeviceExerciseViewModel() {
        return DeviceExerciseViewModel;
    }

    public BodyWeightExerciseViewModel getBodyWeightExerciseViewModel(){
        return BodyWeightExerciseViewModel;
    }

    public WarmUpExerciseViewModel getWarmUpExerciseViewModel(){
        return WarmUpExerciseViewModel;
    }
}
