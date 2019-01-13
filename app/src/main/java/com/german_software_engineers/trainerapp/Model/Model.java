package com.german_software_engineers.trainerapp.Model;


import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Model {
    private Map<String,Schedule> Schedules;

    public Model(){
        Schedules=new HashMap<>();
    }

    public void addSchedule(Schedule schedule) throws ScheduleAvailableException{
        if(Schedules.containsKey(schedule.getName()))
            throw new ScheduleAvailableException();
        Schedules.put(schedule.getName(),schedule);
    }

    public Schedule getSchedule(String name) throws ScheduleAvailableException{
        if(Schedules.containsKey(name)){
            return Schedules.get(name);
        }
        throw new ScheduleAvailableException();
    }

    public void saveFile(OutputStream fileStream){
        String[] gsons = new String[Schedules.size()];
        int i = 0;
        for (Schedule schedule:Schedules.values()) {
            gsons[i]=schedule.toGson();
            i++;
        }
        Gson gson = new Gson();
        try {
            fileStream.write(gson.toJson(gsons).getBytes());
            fileStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(InputStream fileStream){

    }
}
