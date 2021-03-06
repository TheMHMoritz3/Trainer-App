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

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import Enumerations.BodyRegion;
import Enumerations.ExerciseType;
import Exercise.BodyWeightExercise;
import Exercise.Exercise;

public class BodyWeightExerciseViewModel extends ViewModel {
    private Exercise ActiveExercise = null;

    private boolean IsAdditionalInformationActivated;
    private String AdditionalInformation = "";
    private BodyRegion region = BodyRegion.INVALID;

    public BodyWeightExerciseViewModel(Exercise exercise){
        ActiveExercise=exercise;
        applyData();
    }

    private void applyData(){
        if((ActiveExercise!=null)&&(ActiveExercise.type()== ExerciseType.BodyWeight))
        {
            IsAdditionalInformationActivated = ((BodyWeightExercise)ActiveExercise).isAdditionalInformationActivated();
            AdditionalInformation = ((BodyWeightExercise) ActiveExercise).getAdditionalInformation();

            region = ActiveExercise.getStimulatedBodyRegion();
        }
    }

    public String getAdditionalInformation() {
        return AdditionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        AdditionalInformation = additionalInformation;
    }

    public void setAdditionalInformationActivated(boolean activated){
        IsAdditionalInformationActivated = activated;
    }

    public void setStimulatedBodyRegion(int index) {
        region = BodyRegion.values()[index];
    }

    public BodyRegion getStimulatedBodyRegion() {
        return region;
    }

    public boolean isAdditionalInformationActivated(){
        return IsAdditionalInformationActivated;
    }
}
