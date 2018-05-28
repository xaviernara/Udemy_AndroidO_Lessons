package com.example.xaviernara.imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void imageSwitcher(View view){
        Log.i("Info","Button pressed");

        //Remember to make a id for both you buttons and pictures before doing this in activity.main.xml
        /*
        THis lines of code will switch the image on the app with another image that's in the drawable folder (ie mineta1)
        when the button is pressed
        */
        ImageView image = (ImageView) findViewById(R.id.EmmaImageView);
        image.setImageResource(R.drawable.mineta1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
