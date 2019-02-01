package com.german_software_engineers.trainerapp.Controller;

import com.german_software_engineers.trainerapp.TrainingsSchedule;
import com.german_software_engineers.trainerappmodel.Model.Model;
import com.german_software_engineers.trainerappmodel.Schedule.Schedule;

public class ScheduleListModelController {
    private TrainingsSchedule TrainignsScheduleActivity;
    private Model ApplicationModel;

    /**
     * Constructor
     * @param activity Activity to invalidate
     * @param model Model to perform Actions
     */
    public ScheduleListModelController(TrainingsSchedule activity, Model model){
        TrainignsScheduleActivity = activity;
        ApplicationModel = model;
    }

    /**
     * Deletes the Schedule with the given Name
     * @param scheduleName Name of the Schedule
     */
    public void onDeleteClicked(String scheduleName){
        ApplicationModel.deleteSchedule(scheduleName);
        TrainignsScheduleActivity.refreshSchedulesList();
    }

    /**
     * Opens the Edit dialog and Activates the given Schedule
     * @param activeSchedule Schedule to edit
     */
    public void onEditScheduleClicked(Schedule activeSchedule){
        ApplicationModel.setActiveSchedule(activeSchedule);
        TrainignsScheduleActivity.editTrainingsSchedule();
    }
}
