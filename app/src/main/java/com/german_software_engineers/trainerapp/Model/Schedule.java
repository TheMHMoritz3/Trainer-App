package com.german_software_engineers.trainerapp.Model;


import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String Name;
    private TrainingsTypes TrainingsType;
    private Intensities WarmUpIntensity;
    private int Repeations;
    private int PauseTime;
    private int Sets;
    private int Speed;
    private String WarmUpExcersize;
    private int WarmUpTime;
    private int BPM;
    private List<Exercise> Exercises;

    public Schedule(String name, TrainingsTypes trainingsType, int repeations, int pauseTime, int sets, int speed, String warmUpEx, int warmUpTime, Intensities intensity, int bpm){
        Name = name;
        WarmUpIntensity = intensity;
        TrainingsType = trainingsType;
        Repeations = repeations;
        PauseTime = pauseTime;
        Sets = sets;
        Speed = speed;
        WarmUpExcersize = warmUpEx;
        WarmUpTime = warmUpTime;
        BPM = bpm;
        Exercises = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public TrainingsTypes getTrainingsType() {
        return TrainingsType;
    }

    public Intensities getWarmUpIntensity() {
        return WarmUpIntensity;
    }

    public int getRepeations() {
        return Repeations;
    }

    public int getPauseTime() {
        return PauseTime;
    }

    public int getSets() {
        return Sets;
    }

    public int getSpeed() {
        return Speed;
    }

    public String getWarmUpExcersize() {
        return WarmUpExcersize;
    }

    public int getWarmUpTime() {
        return WarmUpTime;
    }

    public int getBPM() {
        return BPM;
    }

    public void addExercise(Exercise exercise){
        Exercises.add(exercise);
    }

    public List<Exercise> exercises(){
        return Exercises;
    }
}