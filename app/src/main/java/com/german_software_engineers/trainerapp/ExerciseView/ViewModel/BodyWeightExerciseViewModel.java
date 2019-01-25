package com.german_software_engineers.trainerapp.ExerciseView.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.german_software_engineers.trainerappmodel.Enumerations.ExerciseType;
import com.german_software_engineers.trainerappmodel.Exercise.BodyWeightExercise;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;

public class BodyWeightExerciseViewModel extends ViewModel {
    private Exercise ActiveExercise = null;

    private MutableLiveData<Boolean> IsAdditionalInformationActivated = new MutableLiveData<>();
    private String AdditionalInformation = "";

    public BodyWeightExerciseViewModel(Exercise exercise){
        ActiveExercise=exercise;
        applyData();
    }

    private void applyData(){
        if((ActiveExercise!=null)&&(ActiveExercise.type()== ExerciseType.BodyWeight))
        {
            IsAdditionalInformationActivated.postValue(((BodyWeightExercise)ActiveExercise).isAdditionalInformationActivated());
            AdditionalInformation = ((BodyWeightExercise) ActiveExercise).getAdditionalInformation();
        }
    }

    public String getAdditionalInformation() {
        return AdditionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        AdditionalInformation = additionalInformation;
    }

    public void setAdditionalInformationActivated(boolean activated){
        IsAdditionalInformationActivated.postValue(activated);
    }

    public boolean isAdditionalInformationActivated(){
        return IsAdditionalInformationActivated.getValue();
    }
}
