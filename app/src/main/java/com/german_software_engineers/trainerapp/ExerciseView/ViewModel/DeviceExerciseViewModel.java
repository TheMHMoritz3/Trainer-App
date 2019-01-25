package com.german_software_engineers.trainerapp.ExerciseView.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.german_software_engineers.trainerappmodel.Enumerations.ExerciseType;
import com.german_software_engineers.trainerappmodel.Exercise.DeviceExercise;
import com.german_software_engineers.trainerappmodel.Exercise.Exercise;

public class DeviceExerciseViewModel extends ViewModel {
    private Exercise ActiveExercise = null;

    private MutableLiveData<Boolean> IsSeatActivated = new MutableLiveData<>();
    private int SeatPosition = 0;
    private MutableLiveData<Boolean> IsDeviceActivated = new MutableLiveData<>();
    private int DevicePosition = 0;
    private MutableLiveData<Boolean> IsLegActivated = new MutableLiveData<>();
    private int LegPosition = 0;
    private MutableLiveData<Boolean> IsFootActivated = new MutableLiveData<>();
    private int FootPosition = 0;
    private MutableLiveData<Boolean> IsAngleActivated = new MutableLiveData<>();
    private int AnglePosition = 0;
    private MutableLiveData<Boolean> IsBackActivated = new MutableLiveData<>();
    private int BackPosition = 0;
    private MutableLiveData<Boolean> IsWeightActivated = new MutableLiveData<>();
    private double Weight=0;
    private MutableLiveData<Boolean> IsAdditionalWeightActivated = new MutableLiveData<>();
    private double AdditionalWeight=0;


    public DeviceExerciseViewModel(Exercise exercise) {
        ActiveExercise = exercise;
        applyData();
    }

    private void applyData(){
        if((ActiveExercise!=null)&&(ActiveExercise.type()== ExerciseType.Device)){
            IsSeatActivated.postValue(((DeviceExercise)ActiveExercise).isSeatActivated());
            SeatPosition=((DeviceExercise) ActiveExercise).getSeatPosition();
            IsDeviceActivated.postValue(((DeviceExercise) ActiveExercise).isDeviceNumberActivated());
            DevicePosition = ((DeviceExercise) ActiveExercise).getDeviceNumber();
            IsLegActivated.postValue(((DeviceExercise) ActiveExercise).isLegActivated());
            LegPosition = ((DeviceExercise) ActiveExercise).getLegPosition();
            IsFootActivated.postValue(((DeviceExercise) ActiveExercise).isFootActivated());
            FootPosition = ((DeviceExercise) ActiveExercise).getFootPosition();
            IsAngleActivated.postValue(((DeviceExercise) ActiveExercise).isAngleActivated());
            AnglePosition = ((DeviceExercise) ActiveExercise).getAnglePosition();
            IsBackActivated.postValue(((DeviceExercise) ActiveExercise).isBackActivated());
            BackPosition = ((DeviceExercise) ActiveExercise).getBackPosition();
            IsWeightActivated.postValue(((DeviceExercise) ActiveExercise).isWeightActivated());
            Weight=((DeviceExercise) ActiveExercise).getWeight();
            IsAdditionalWeightActivated.postValue(((DeviceExercise) ActiveExercise).isAdditionalWeightActivated());
            AdditionalWeight = ((DeviceExercise) ActiveExercise).getAdditionalWeight();
        }
    }

    public void setAdditionalWeightActivated(boolean activated){
        IsAdditionalWeightActivated.postValue(activated);
    }

    public boolean isAdditionalWeightActivated() {
        return IsAdditionalWeightActivated.getValue();
    }

    public void setWeightActivated(boolean activated){
        IsWeightActivated.postValue(activated);
    }

    public boolean isWeightActivated() {
        return IsWeightActivated.getValue();
    }

    public void setAngleActivated(boolean activated){
        IsAngleActivated.postValue(activated);
    }

    public boolean isAngleActivated() {
        return IsAngleActivated.getValue();
    }

    public void setFootActivated(boolean activated){
        IsFootActivated.postValue(activated);
    }

    public boolean isFootActivated() {
        return IsFootActivated.getValue();
    }

    public void setLegActivated(boolean activated){
        IsLegActivated.postValue(activated);
    }

    public boolean isLegActivated() {
        return IsLegActivated.getValue();
    }

    public void setDeviceActivated(boolean activated){
        IsDeviceActivated.postValue(activated);
    }

    public boolean isDeviceActivated() {
        return IsDeviceActivated.getValue();
    }

    public boolean isSeatActivated() {
        return IsSeatActivated.getValue();
    }

    public void setSeatActivated(boolean activated){
        IsSeatActivated.postValue(activated);
    }

    public boolean isBackActivated() {
        return IsBackActivated.getValue();
    }

    public void setBackActivated(boolean activated){
        IsBackActivated.postValue(activated);
    }

    public void setSeatPosition(int seatPosition) {
        SeatPosition = seatPosition;
    }

    public int getSeatPosition() {
        return SeatPosition;
    }

    public int getDevicePosition() {
        return DevicePosition;
    }

    public void setDevicePosition(int devicePosition) {
        DevicePosition = devicePosition;
    }

    public int getFootPosition() {
        return FootPosition;
    }

    public void setFootPosition(int footPosition) {
        FootPosition = footPosition;
    }

    public int getLegPosition() {
        return LegPosition;
    }

    public void setLegPosition(int legPosition) {
        LegPosition = legPosition;
    }

    public int getAnglePosition() {
        return AnglePosition;
    }

    public void setAnglePosition(int anglePosition) {
        AnglePosition = anglePosition;
    }

    public int getBackPosition() {
        return BackPosition;
    }

    public void setBackPosition(int backPosition) {
        BackPosition = backPosition;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public double getAdditionalWeight() {
        return AdditionalWeight;
    }

    public void setAdditionalWeight(double additionalWeight) {
        AdditionalWeight = additionalWeight;
    }
}
