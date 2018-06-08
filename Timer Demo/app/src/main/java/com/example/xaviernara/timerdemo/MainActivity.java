package com.example.xaviernara.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //this time countdown based on the amount of time you tell it to
        //new CountDownTimer(milli secs in future, countdown interval in milli secs)
        new CountDownTimer(10000,1000){

            //onTick will be called every time a time passes
            public void onTick(long millisecondsUntilDone){
                Log.i("Seconds Left",String.valueOf(millisecondsUntilDone/1000));
            }
            //onFinish will be called when the countdown ends
            public void onFinish(){
                Log.i("We're done","No more countdown");
            }
        }.start();

/////////////////////////////////////////////////////////////////////////////

        /*
        //Handler/runnable way to make a timer
        //this time counts how many seconds have passed

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("Runnable","1 Second has passed");

                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
        */
    }
}
