package com.tagirahmad.service;

import android.content.Intent;
import android.util.Log;

import androidx.core.app.JobIntentService;

public class ServicesExample extends JobIntentService {
    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Service", "Service is created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Service", "Service is started");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service", "Service is stopped");
    }

    @Override
    protected void onHandleWork(Intent intent) {
        Log.d("Service", "onHandleWork worked!");
        Log.d("Service", intent.toString());
    }
}
