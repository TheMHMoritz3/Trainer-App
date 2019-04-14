package com.german_software_engineers.trainerapp.SettingsView.ui.settings;

import android.arch.lifecycle.ViewModel;

import com.german_software_engineers.Presenter.Configuration.Configuration;
import com.german_software_engineers.trainerapp.Controller.ApplicationManager;

public class SettingsViewModel extends ViewModel {
    private int ArmColor = Integer.MAX_VALUE;
    private int BodyColor = Integer.MAX_VALUE;
    private int LegColor = Integer.MAX_VALUE;
    private Configuration Config = null;

    public SettingsViewModel() {
        initialize();
    }

    private void initialize() {
        Config = ApplicationManager.configuration();
        ArmColor = Config.getArmsExerciseColor();
        BodyColor = Config.getBodyExerciseColor();
        LegColor = Config.getLegsExerciseColor();
    }

    public int getArmColor() {
        return ArmColor;
    }

    public void setArmColor(int armColor) {
        ArmColor = armColor;
        Config.setArmsExerciseColor(armColor);
    }

    public int getBodyColor() {
        return BodyColor;
    }

    public void setBodyColor(int bodyColor) {
        BodyColor = bodyColor;
        Config.setBodyExerciseColor(bodyColor);
    }

    public int getLegColor() {
        return LegColor;
    }

    public void setLegColor(int legColor) {
        LegColor = legColor;
        Config.setLegsExerciseColor(legColor);
    }
}
