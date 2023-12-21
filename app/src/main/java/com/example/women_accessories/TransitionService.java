package com.example.women_accessories;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TransitionService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Handle the activity transition
        Intent transitionIntent = new Intent(this, SuccessActivity.class);
        transitionIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(transitionIntent);

        // Stop the service after the transition
        stopSelf();

        // Return the service behavior, e.g., START_STICKY
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}