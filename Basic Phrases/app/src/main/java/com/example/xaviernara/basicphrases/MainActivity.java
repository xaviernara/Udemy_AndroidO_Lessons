package com.example.xaviernara.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    //this app plays different audio depending on the button pressed

    //MediaPlayer mediaPlayer;

    public void frenchPhrases (View view){

        //button variable created to access the tags on the buttons so the media played is correct
        Button buttonPressed = (Button) view;
        Log.i("Button pressed",buttonPressed.getTag().toString());

        //how to use a sound file like a variable to play media based on the tag name 
        //MediaPlayer mPlayer = MediaPlayer.create(this, getResources().getIdentifier(nameOfFile, "raw", getPackageName()));
        //mPlayer.start();

        MediaPlayer mPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonPressed.getTag().toString(), "raw", getPackageName()));
        mPlayer.start();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //my way to do the app
        //for some reason  the if statements aren't being accessed
        /*String tagName = (String) view.getTag();
        //String idNames = String.valueOf(view.getId());


        if (tagName == "speakEnglish"){
        //if (idNames == "speakEnglishButton"){
            mediaPlayer= MediaPlayer.create(this,R.raw.doyouspeakenglish);
            mediaPlayer.start();
            Log.i("Button pushed", "speak english");
        }
        if (tagName == "goodEvening"){
            mediaPlayer= MediaPlayer.create(this,R.raw.goodevening);
            mediaPlayer.start();
            Log.i("Button pushed", "goodevening");
        }
        if (tagName == "hello"){
            mediaPlayer= MediaPlayer.create(this,R.raw.hello);
            mediaPlayer.start();
            Log.i("Button pushed", "hello");
        }

        if (tagName == "howAreYou"){
            mediaPlayer= MediaPlayer.create(this,R.raw.howareyou);
            mediaPlayer.start();
            Log.i("Button pushed", "how are you");
        }
        if (tagName == "iLiveIn"){
            mediaPlayer= MediaPlayer.create(this,R.raw.ilivein);
            mediaPlayer.start();
            Log.i("Button pushed", "i live in");
        }
        if (tagName == "myNameIs"){
            mediaPlayer= MediaPlayer.create(this,R.raw.mynameis);
            mediaPlayer.start();
            Log.i("Button pushed", "my name is");
        }
        if (tagName == "please"){
            mediaPlayer= MediaPlayer.create(this,R.raw.please);
            mediaPlayer.start();
            Log.i("Button pushed", "please");
        }
        if(tagName== "welcome"){
            mediaPlayer= MediaPlayer.create(this,R.raw.welcome);
            mediaPlayer.start();
            Log.i("Button pushed", "welcome");
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
