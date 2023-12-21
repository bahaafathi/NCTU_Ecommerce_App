package com.example.women_accessories;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TransitionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Bahaa");
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.ACTION_ACTIVITY_TRANSITION")) {
            // Handle the activity transition here
            // You can start a new activity, show a notification, or perform any other action
            Intent transitionIntent = new Intent(context, SuccessActivity.class);
            context.startActivity(transitionIntent);
        }
    }
}