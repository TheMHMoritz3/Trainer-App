package com.german_software_engineers.trainerapp.Controller;

import com.german_software_engineers.trainerapp.TrainingsSchedule;
import com.german_software_engineers.trainerappmodel.Model.Model;

public class ScheduleListModelController {
    private TrainingsSchedule TrainignsScheduleActivity;
    private Model ApplicationModel;

    public ScheduleListModelController(TrainingsSchedule activity, Model model){
        TrainignsScheduleActivity = activity;
        ApplicationModel = model;
    }

    public void onDeleteClicked(String scheduleName){
        ApplicationModel.deleteSchedule(scheduleName);
        TrainignsScheduleActivity.refreshSchedulesList();
    }
}
