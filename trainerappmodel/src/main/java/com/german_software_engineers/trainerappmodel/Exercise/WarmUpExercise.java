package com.german_software_engineers.trainerappmodel.Exercise;

import com.german_software_engineers.trainerappmodel.Enumerations.ExerciseType;
import com.german_software_engineers.trainerappmodel.Enumerations.Intensities;

public class WarmUpExercise extends Exercise {
    private ExerciseType Type;
    private boolean IsExecutionTimeActivated = false;
    private int ExecutionTime=0;
    private boolean IsIntensityActivated = false;
    private Intensities Intenity=Intensities.soft;
    private boolean IsSubintensityActivated;
    private int SubIntensity=0;
    private boolean IsBPMActivated = false;
    private int BPM=0;

    public WarmUpExercise(String name){
        super(name);
        Type = ExerciseType.WarmUp;
    }

    public ExerciseType type(){
        return Type;
    }


    public int getExecutionTime() {
        if(IsExecutionTimeActivated)
            return ExecutionTime;
        return -1;
    }

    public void setExecutionTime(int executionTime) {
        if(IsExecutionTimeActivated)
            ExecutionTime = executionTime;
    }

    public Intensities getIntenity() {
        if(IsIntensityActivated)
            return Intenity;
        return Intensities.hard;
    }

    public void setIntenity(Intensities intenity) {
        if(IsIntensityActivated)
            Intenity = intenity;
    }

    public void setSubIntensity(int subIntensity){
        if(IsSubintensityActivated)
            SubIntensity=subIntensity;
    }

    public int getSubIntensity() {
        if(IsSubintensityActivated)
            return SubIntensity;
        return -1;
    }

    public int getBPM() {
        if(IsBPMActivated)
            return BPM;
        return -1;
    }

    public void setBPM(int BPM) {
        if(IsBPMActivated)
            this.BPM = BPM;
    }

    public boolean isExecutionTimeActivated() {
        return IsExecutionTimeActivated;
    }

    public void setExecutionTimeActivated(boolean executionTimeActivated) {
        IsExecutionTimeActivated = executionTimeActivated;
    }

    public boolean isIntensityActivated() {
        return IsIntensityActivated;
    }

    public void setIntensityActivated(boolean intensityActivated) {
        IsIntensityActivated = intensityActivated;
    }

    public boolean isSubintensityActivated() {
        return IsSubintensityActivated;
    }

    public void setSubintensityActivated(boolean subintensityActivated) {
        IsSubintensityActivated = subintensityActivated;
    }

    public boolean isBPMActivated() {
        return IsBPMActivated;
    }

    public void setBPMActivated(boolean BPMActivated) {
        IsBPMActivated = BPMActivated;
    }
}
