package com.german_software_engineers.trainerapp.Controller;

import Model.Model;
import Model.XMLParser;
import android.app.Application;
import android.content.Intent;
import com.german_software_engineers.Presenter.Configuration.Configuration;
import com.german_software_engineers.Presenter.Configuration.ConfigurationParser;
import com.german_software_engineers.trainerapp.R;

import java.io.File;

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

public class ApplicationManager extends Application {
    private Model ApplicationModel = null;
    private static Configuration Configuration = new Configuration();

    @Override
    public void onCreate() {
        startService(new Intent(getBaseContext(), CloseApplicationService.class));
        super.onCreate();
        createModelAndLoadFiles();
    }

    private void createModelAndLoadFiles() {
        ApplicationModel = new Model();


        Configuration.setArmsExerciseColor(getResources().getColor(R.color.DefaultArmsColor));
        Configuration.setLegsExerciseColor(getResources().getColor(R.color.DefaultBodyColor));
        Configuration.setBodyExerciseColor(getResources().getColor(R.color.DefualtLegsColor));

        XMLParser xmlParser = new XMLParser(ApplicationModel);
        File DataFile = new File(getFilesDir() + "/" + getString(R.string.DataFile));
        xmlParser.parseFile(DataFile);

        ConfigurationParser conofigParser = new ConfigurationParser(Configuration, getFilesDir() + "/");
        conofigParser.parseXML();
    }

    public Model getApplicationModel(){
        return ApplicationModel;
    }

    public void saveFile(){
        XMLParser xmlParser = new XMLParser(ApplicationModel);
        File DataFile = new File(getFilesDir() + "/" + getString(R.string.DataFile));
        xmlParser.writeFile(DataFile);

        ConfigurationParser configParser = new ConfigurationParser(Configuration, getFilesDir() + "/");
        configParser.writeXML();
    }


    @Override
    public void onTerminate(){
        onApplicationClose();
        super.onTerminate();
    }

    public void onApplicationClose() {
        saveFile();
    }

    public static Configuration configuration() {
        return Configuration;
    }
}
