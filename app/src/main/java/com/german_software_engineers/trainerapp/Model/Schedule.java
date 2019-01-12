package com.german_software_engineers.trainerapp.Model;


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
    }
}