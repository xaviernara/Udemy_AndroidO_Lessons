package com.example.xaviernara.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //these lines of code will add a video to a application with a media controller
        // 1.create VideoView variable like we do with buttons,images,etc... (line 23)
        // 2.set the video path to the raw folder and call the raw folder where the video is in (line 25)
        // 3. creates a MediaController variable that will be used to add things like pause/play,fast forward,etc..
        //to the video so the video just play without control (lines27-31)
        //WITHOUT THE MEDIACONTROLLER you wont be able to control the media
        // 4.telling the video to start when  the app is open (line 33)

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        videoView.setVideoPath("android.resource://"+getPackageName() + "/" + R.raw.naruto);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();
    }
}
