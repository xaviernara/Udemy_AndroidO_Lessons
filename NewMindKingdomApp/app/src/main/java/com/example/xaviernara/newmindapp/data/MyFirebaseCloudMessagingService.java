package com.example.xaviernara.newmindapp.data;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseCloudMessagingService extends FirebaseMessagingService {






    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);

        Log.d("FCM TAG","FCM TOKEN REFRSHED:"+token);


    }
}
