package com.example.xaviernara.newmindapp;

import android.app.IntentService;
import android.app.Notification;
//import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import androidx.annotation.Nullable;
//import android.support.v4.app.NotificationManagerCompat;
import android.view.WindowManager;

import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends Activity {


    //After completion of 3000 ms, the next activity will get started.
    private static int SPLASH_SCREEN_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Make sure this is before calling super.onCreate
        //setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);


        //This method is used so that your splash activity
        //can cover the entire screen.
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.custom_dialog.activity_main);
        //this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent is used to switch from one activity to another.
                Intent i=new Intent(MainActivity.this,
                        Login.class);

                //invoke the SecondActivity.
                startActivity(i);

                //the current activity will get finished.
                finish();

            }
        }, SPLASH_SCREEN_TIME_OUT);*/



    }

}


//link to notification code: https://stackoverflow.com/questions/34517520/how-to-give-notifications-on-android-on-specific-time
class MyReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        Intent notifyIntent = new Intent(context, MyNewIntentService.class);
        context.startService(notifyIntent);
    }
}


class MyNewIntentService extends IntentService {

    private static int NOTIFICATION_ID = 1;

    public MyNewIntentService(String name) {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Tuesday Morning Prayer");
        builder.setContentText("Come join us as we usher in the day with prayer!");
        builder.setSmallIcon(R.drawable.crest);

        Intent notifyIntent = new Intent(this,MainActivity.class);

        //to be able to launch the app from the notification
        PendingIntent pendingIntent = PendingIntent.getActivity(this,2,notifyIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notificationCompat = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);


    }

}
