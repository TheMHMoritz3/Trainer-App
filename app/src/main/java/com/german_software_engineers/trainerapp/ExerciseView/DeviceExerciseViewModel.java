package com.german_software_engineers.trainerapp.ExerciseView;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.german_software_engineers.trainerappmodel.Exercise.Exercise;

public class DeviceExerciseViewModel extends ViewModel {
    private Exercise ActiveExercise=null;

    private MutableLiveData<Boolean> IsSeatActivated = new MutableLiveData<>();
    private MutableLiveData<Boolean> IsDeviceActivated = new MutableLiveData<>();
    private MutableLiveData<Boolean> IsLegActivated = new MutableLiveData<>();
    private MutableLiveData<Boolean> IsFootActivates = new MutableLiveData<>();
    private MutableLiveData<Boolean> IsAngleActivated = new MutableLiveData<>();
    private MutableLiveData<Boolean> IsBackActivated = new MutableLiveData<>();
    private MutableLiveData<Boolean> IsWeightActivated = new MutableLiveData<>();
    private MutableLiveData<Boolean> IsAdditionalWeightActivated = new MutableLiveData<>();


    public DeviceExerciseViewModel(Exercise exercise){
        ActiveExercise = exercise;
    }

    public MutableLiveData<Boolean> getIsAdditionalWeightActivated() {
        return IsAdditionalWeightActivated;
    }

    public MutableLiveData<Boolean> getIsWeightActivated() {
        return IsWeightActivated;
    }

    public MutableLiveData<Boolean> getIsBackActivated() {
        return IsBackActivated;
    }

    public MutableLiveData<Boolean> getIsAngleActivated() {
        return IsAngleActivated;
    }

    public MutableLiveData<Boolean> getIsFootActivates() {
        return IsFootActivates;
    }

    public MutableLiveData<Boolean> getIsLegActivated() {
        return IsLegActivated;
    }

    public MutableLiveData<Boolean> getIsDeviceActivated() {
        return IsDeviceActivated;
    }

    public MutableLiveData<Boolean> getIsSeatActivated() {
        return IsSeatActivated;
    }
}
