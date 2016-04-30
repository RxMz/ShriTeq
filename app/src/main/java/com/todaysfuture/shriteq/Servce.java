package com.todaysfuture.shriteq;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by rishabh on 25/4/16.
 */
public class Servce extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        Parse.initialize(this, "Application ID", "Client ID");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
