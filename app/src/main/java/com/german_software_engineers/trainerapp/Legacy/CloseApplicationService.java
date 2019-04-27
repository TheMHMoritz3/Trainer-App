package com.german_software_engineers.trainerapp.Legacy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.german_software_engineers.trainerapp.Controller.ApplicationManager;

public class CloseApplicationService extends Service {
    ApplicationManager applicationManager;

    public CloseApplicationService() {
        applicationManager = (ApplicationManager) getApplication();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        applicationManager.onApplicationClose();
        stopSelf();
    }
}
