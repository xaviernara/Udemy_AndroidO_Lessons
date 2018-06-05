package com.example.xaviernara.sounddemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //remember to create a raw folder in tbe res folder to import the sound into AS


    //creates a MediaPlayer variable outside the methods so it wont constantly be created again and its made in the methods
    //then the app would crash becuz you'd be trying to
    MediaPlayer mediaPlayer;

    //creates a AudioManger variable that allows us to control the audio
    AudioManager audioManager;

    //this method lets the user play the sound when a button is pushed
    public void play(View view){

        //MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.blue_bird);

        mediaPlayer.start();
    }
   //this method lets the user pause the sound when a button is pushed
    public void pause(View view){

        //MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.blue_bird);

        mediaPlayer.pause();
    }

    //by adding mediaplayer variable to the onCreate method the media can be controlled from opening the app instead of pushing the buttons
    //(ie not crashing the app by constantly having to create a mediaplayer variable in the different methods)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        //these 2 lines of code get the maxVolume of the device the user is using and currentVolume of the audio playing
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        ////////////////////////////////////////////////////////////////////////////////////////



         mediaPlayer = MediaPlayer.create(this,R.raw.blue_bird);
        //mediaPlayer.start();
        /////////////////////////////////////////////////////////////
        //this code is for controlling the volume with a seek bar
        SeekBar volumeControl =(SeekBar) findViewById(R.id.volumeSeekBar);

        //these lines of code will allow the seekbar to set the max volume of the audio
        //and once the app opens the seekbar will match the volume of the audio playing and can be changed once the seekbar is moved
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);


        ///////////////////////////////////////////////////////////////////////////

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("SeekBar changed", Integer.toString(progress));

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////
        //a scrub is the same as the progress bar that tracks the progress of the audio
        //and its for rewinding and forwarding the audio

        //these lines of code track to see when the seekbar has been changed,started, and stopped
        final SeekBar scrubSeekBar = (SeekBar) findViewById(R.id.scrubSeekBar);

        scrubSeekBar.setMax(mediaPlayer.getDuration());

        scrubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("Scrub Seekbar moved", Integer.toString(progress));

                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                mediaPlayer.start();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                mediaPlayer.pause();
            }
        });


        //these lines of code will track the progress of the audio playing
        //also it tells the track the delay and how many seconds in whc the audio by
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                scrubSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,300);

    }
}
