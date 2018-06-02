package com.example.xaviernara.fadinganimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //boolean to tell if the 1st image is on the app screen or not
    //boolean imageOneIsShowing=true;
    boolean appIsOpen =false;

    /*
    public void imageFadeApp(View view){

        Log.i("Info","Image is clicked");

        //these lines of codes will fade out a image to the next image
        //1.create a imageview variable
        //2.use ImageView variable.animate().alpha(how faded the image will be).setDuration(milliseconds(time it takes to fade image));
        //to fade the image out
        ImageView tsunaImageView = (ImageView) findViewById(R.id.tsunaImageView);
        tsunaImageView.animate().alpha(0).setDuration(2000);

        ImageView flameImageView = (ImageView) findViewById(R.id.flameImageView);
        flameImageView.animate().alpha(1).setDuration(2000);

        //
        these lines below belong to the FADED IMAGE APP
        these lines of code below will fade the image back to the other image with ach click
        (i.e when the boolean above is false & vice versa)
        lines 48-60
        //
        */


        /*
        if (imageOneIsShowing){
            imageOneIsShowing=false;
            tsunaImageView.animate().alpha(0).setDuration(2000);
            flameImageView.animate().alpha(1).setDuration(2000);

        }
        else{
            imageOneIsShowing=true;
            tsunaImageView.animate().alpha(1).setDuration(2000);
            flameImageView.animate().alpha(0).setDuration(2000);
        }

        Log.i("Info","second Image is clicked");


    }*/


    public void translationsApp (View view){
        Log.i("Info","Image is clicked");

        ////////////////////////////////////////////////////////////////////////////
        ImageView tsunaImageView = (ImageView) findViewById(R.id.tsunaImageView);
        //tsunaImageView.animate().alpha(0).setDuration(2000);


        //Translations App code
        //this line of code will move the image along the x&y axis by a certain amount of DP's
        //and set the duration of how long the image will stay moved
        //tsunaImageView.animate().translationYBy(+/- DP's to be moved up/down).setDuration(time in milliseconds);
        //tsunaImageView.animate().translationXBy(+/- DP's to be moved left/right).setDuration(time in milliseconds);

        //this line of code will rotate the image and fade the image
        //tsunaImageView.animate().rotation(degrees).alpha(0).setDuration(time in milliseconds);

        //this line of code will scale (ie shrink) the image in the x&y axis
        //tsunaImageView.animate().scaleX(shrink the image by a % (i.e. float) in the x axis).scaleY(shrink the image by a % (i.e. float)in the y axis).setDuration(1000);
        //tsunaImageView.animate().alphaBy(1f);

        //challenge: the app starts with the image spinning in from the left
        /*
        if (appIsOpen=false){
            //tsunaImageView.animate().alpha(0);
            appIsOpen = true;

        }
        else if(appIsOpen = true){
            tsunaImageView.animate().rotation(1800).translationXBy(-2000).setDuration(6000);
        }
        */




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView tsunaImageView = (ImageView) findViewById(R.id.tsunaImageView);
        tsunaImageView.animate().translationXBy(-1000);
        //this line of code will move the image along the x-axis (0,-1000)
        //tsunaImageView.setX(-999);
        tsunaImageView.animate().rotation(3600).translationXBy(999).setDuration(3000);

    }
}
