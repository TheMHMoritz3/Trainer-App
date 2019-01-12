package com.german_software_engineers.trainerapp.Model;

public class Exercise {
    private String Name;

    private boolean IsSeatActivated;
    private int SeatPosition;
    private boolean IsLegActivated;
    private int LegPosition;
    private boolean IsFootActivated;
    private int FootPosition;
    private boolean IsAngleActivated;
    private int AnglePosition;
    private boolean IsWeightActivated;
    private int Weight;

    private Exercise(){}

    public Exercise(String name,boolean isSeatActivated, boolean isLegActivated, boolean isFootActivated, boolean isAngleActivated, boolean isWeightActivated ){
        Name = name;
        IsSeatActivated = isSeatActivated;
        IsLegActivated = isLegActivated;
        IsFootActivated = isFootActivated;
        IsAngleActivated = isAngleActivated;
        IsWeightActivated = isWeightActivated;
    }

    public void setSeatPosition(int pos){
        if(IsSeatActivated)
            SeatPosition = pos;
    }


    public int getSeatPosition() {
        if(IsSeatActivated)
            return SeatPosition;
        else
            return -1;
    }

    public int getLegPosition() {
        if(IsLegActivated)
            return LegPosition;
        else
            return -1;
    }

    public void setLegPosition(int legPosition) {
        if(IsLegActivated)
            LegPosition = legPosition;
    }

    public int getFootPosition() {
        if(IsFootActivated)
            return FootPosition;
        else
            return -1;
    }

    public void setFootPosition(int footPosition) {
        if(IsFootActivated)
            FootPosition = footPosition;
    }

    public int getAnglePosition() {
        if(IsAngleActivated)
            return AnglePosition;
        else
            return -1;
    }

    public void setAnglePosition(int anglePosition) {
        if(IsAngleActivated)
            AnglePosition = anglePosition;
    }

    public int getWeight() {
        if(IsWeightActivated)
            return Weight;
        else
            return -1;
    }

    public void setWeight(int weight) {
        if(IsWeightActivated)
            Weight = weight;
    }
}
