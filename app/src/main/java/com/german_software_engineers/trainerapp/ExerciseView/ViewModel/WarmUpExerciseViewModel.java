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

import android.arch.lifecycle.ViewModel;

import com.german_software_engineers.trainerappmodel.Enumerations.ExerciseType;
import com.german_software_engineers.trainerappmodel.Enumerations.Intensities;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;
import com.german_software_engineers.trainerappmodel.Exercise.WarmUpExercise;

public class WarmUpExerciseViewModel extends ViewModel {
    private Exercise Exercise = null;

    private boolean IsWarmUpTimeActivated = false;
    private int WamUpTime = 0;
    private boolean IsIntensityActivated = false;
    private Intensities Intensity = Intensities.invalid;
    private boolean IsSubIntensityActivated = false;
    private int SubIntensity = 0;
    private boolean IsHeartfrequencyActivated = false;
    private int Heartfrequency = 0;

    public WarmUpExerciseViewModel(Exercise exercise) {
        Exercise = exercise;
        setData();
    }

    private void setData() {
        if ((Exercise != null) && (Exercise.type() == ExerciseType.WarmUp)) {
            IsWarmUpTimeActivated = ((WarmUpExercise) Exercise).isExecutionTimeActivated();
            WamUpTime=((WarmUpExercise) Exercise).getExecutionTime();
            IsIntensityActivated = ((WarmUpExercise) Exercise).isIntensityActivated();
            Intensity = ((WarmUpExercise) Exercise).getIntenity();
            IsSubIntensityActivated = ((WarmUpExercise) Exercise).isSubintensityActivated();
            SubIntensity=((WarmUpExercise) Exercise).getSubIntensity();
            IsHeartfrequencyActivated = ((WarmUpExercise) Exercise).isBPMActivated();
            Heartfrequency = ((WarmUpExercise) Exercise).getBPM();
        }
    }

    public boolean isWarmUpTimeActivated() {
        return IsWarmUpTimeActivated;
    }

    public void setWarmUpTimeActivated(boolean warmUpTimeActivated) {
        IsWarmUpTimeActivated = warmUpTimeActivated;
    }

    public int getWamUpTime() {
        return WamUpTime;
    }

    public void setWamUpTime(int wamUpTime) {
        WamUpTime = wamUpTime;
    }

    public boolean isIntensityActivated() {
        return IsIntensityActivated;
    }

    public void setIntensityActivated(boolean intensityActivated) {
        IsIntensityActivated = intensityActivated;
    }

    public Intensities getIntensity() {
        return Intensity;
    }

    public void setIntensity(Intensities intensity) {
        Intensity = intensity;
    }

    public boolean isSubIntensityActivated() {
        return IsSubIntensityActivated;
    }

    public void setSubIntensityActivated(boolean subIntensityActivated) {
        IsSubIntensityActivated = subIntensityActivated;
    }

    public int getSubIntensity() {
        return SubIntensity;
    }

    public void setSubIntensity(int subIntensity) {
        SubIntensity = subIntensity;
    }

    public boolean isHeartfrequencyActivated() {
        return IsHeartfrequencyActivated;
    }

    public void setHeartfrequencyActivated(boolean heartfrequencyActivated) {
        IsHeartfrequencyActivated = heartfrequencyActivated;
    }

    public int getHeartfrequency() {
        return Heartfrequency;
    }

    public void setHeartfrequency(int heartfrequency) {
        Heartfrequency = heartfrequency;
    }
}
