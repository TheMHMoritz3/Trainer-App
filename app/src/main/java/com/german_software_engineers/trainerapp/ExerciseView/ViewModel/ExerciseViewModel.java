package com.german_software_engineers.trainerapp.ExerciseView.ViewModel;

/**
 *     Copyright (C) 2019  Moritz Herzog
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import Enumerations.ExerciseType;
import Exercise.BodyWeightExercise;
import Exercise.DeviceExercise;
import Exercise.Exercise;
import Exercise.WarmUpExercise;
import Exercise.CircleExercise;
import Schedule.Schedule;

public class ExerciseViewModel extends ViewModel {
    private Exercise ActiveExcercise;
    private Schedule ActiveSchedule;
    private MutableLiveData<ExerciseType> ActiveExerciseType = new MutableLiveData<>();
    public MutableLiveData<String> ExerciseName = new MutableLiveData<>();

    private DeviceExerciseViewModel DeviceExerciseViewModel = null;
    private BodyWeightExerciseViewModel BodyWeightExerciseViewModel = null;
    private WarmUpExerciseViewModel WarmUpExerciseViewModel = null;
    private CircleExerciseViewModel CircleExerViewMode = null;

    public ExerciseViewModel(Schedule schedule, Exercise exercise){
        ActiveSchedule = schedule;
        ActiveExcercise = exercise;
        DeviceExerciseViewModel = new DeviceExerciseViewModel(exercise);
        BodyWeightExerciseViewModel = new BodyWeightExerciseViewModel(exercise);
        WarmUpExerciseViewModel = new WarmUpExerciseViewModel(exercise);
        CircleExerViewMode = new CircleExerciseViewModel();
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
        Exercise exercise;
        switch (ActiveExerciseType.getValue()){
            case Device:
                default:
                    exercise = new DeviceExercise(ExerciseName.getValue());
                    ((DeviceExercise) exercise).setSeatActivated(DeviceExerciseViewModel.isSeatActivated());
                    ((DeviceExercise) exercise).setSeatPosition(DeviceExerciseViewModel.getSeatPosition());
                    ((DeviceExercise) exercise).setLegActivated(DeviceExerciseViewModel.isLegActivated());
                    ((DeviceExercise) exercise).setLegPosition(DeviceExerciseViewModel.getLegPosition());
                    ((DeviceExercise) exercise).setFootActivated(DeviceExerciseViewModel.isFootActivated());
                    ((DeviceExercise) exercise).setFootPosition(DeviceExerciseViewModel.getFootPosition());
                    ((DeviceExercise) exercise).setAngleActivated(DeviceExerciseViewModel.isAngleActivated());
                    ((DeviceExercise) exercise).setAnglePosition(DeviceExerciseViewModel.getAnglePosition());
                    ((DeviceExercise) exercise).setWeightActivated(DeviceExerciseViewModel.isWeightActivated());
                    ((DeviceExercise) exercise).setBackActivated(DeviceExerciseViewModel.isBackActivated());
                    ((DeviceExercise) exercise).setBackPosition(DeviceExerciseViewModel.getBackPosition());
                    ((DeviceExercise) exercise).setWeight(DeviceExerciseViewModel.getWeight());
                    ((DeviceExercise) exercise).setAdditionalWeightActivated(DeviceExerciseViewModel.isAdditionalWeightActivated());
                    ((DeviceExercise) exercise).setAdditionalWeight(DeviceExerciseViewModel.getAdditionalWeight());
                    ((DeviceExercise) exercise).setDeviceNumberActivated(DeviceExerciseViewModel.isDeviceActivated());
                    ((DeviceExercise) exercise).setDeviceNumber(DeviceExerciseViewModel.getDevicePosition());
                    exercise.setStimulatedBodyRegion(DeviceExerciseViewModel.getStimulatedBodyRegion());

                break;
            case BodyWeight:
                exercise = new BodyWeightExercise(ExerciseName.getValue());
                ((BodyWeightExercise) exercise).setAdditionalInformationActivated(BodyWeightExerciseViewModel.isAdditionalInformationActivated());
                ((BodyWeightExercise) exercise).setAdditionalInformation(BodyWeightExerciseViewModel.getAdditionalInformation());
                exercise.setStimulatedBodyRegion(BodyWeightExerciseViewModel.getStimulatedBodyRegion());
                break;
            case WarmUp:
                exercise = new WarmUpExercise(ExerciseName.getValue());
                ((WarmUpExercise) exercise).setExecutionTimeActivated(WarmUpExerciseViewModel.isWarmUpTimeActivated());
                ((WarmUpExercise) exercise).setExecutionTime(WarmUpExerciseViewModel.getWamUpTime());
                ((WarmUpExercise) exercise).setIntensityActivated(WarmUpExerciseViewModel.isIntensityActivated());
                ((WarmUpExercise) exercise).setIntenity(WarmUpExerciseViewModel.getIntensity());
                ((WarmUpExercise) exercise).setSubintensityActivated(WarmUpExerciseViewModel.isSubIntensityActivated());
                ((WarmUpExercise) exercise).setSubIntensity(WarmUpExerciseViewModel.getSubIntensity());
                ((WarmUpExercise) exercise).setBPMActivated(WarmUpExerciseViewModel.isHeartfrequencyActivated());
                ((WarmUpExercise) exercise).setBPM(WarmUpExerciseViewModel.getHeartfrequency());
                break;
            case Circle:
                exercise = new CircleExercise(ExerciseName.getValue());
                ((CircleExercise)exercise)
                break;
        }

        if(ActiveExcercise!=null) {
            exercise.setPosition(ActiveExcercise.getPosition());
            ActiveSchedule.exercises().remove(ActiveExcercise);
        }

        ActiveSchedule.addExercise(exercise);
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
