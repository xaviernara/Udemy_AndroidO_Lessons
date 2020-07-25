package com.example.xaviernara.newmindapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /*

        switch(position){

                    case 0 :
                        Intent intent = new Intent(getApplicationContext(),PastorBiography.class);
                        startActivity(intent);
                        break;

                    case 1 :
                        intent = new Intent(getApplicationContext(), PreviousMessages.class);
                        startActivity(intent);
                        break;

                    case 2 :
                        intent = new Intent(getApplicationContext(), SocialMedia.class);
                        startActivity(intent);
                        break;

                    case 3 :
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/17AShdI3lj8vwOfxkhBoLcv_YRCqf4KOTY03Wq2guQCE/viewform?edit_requested=true"));
                        startActivity(intent);
                        break;

                    case 4 :
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newmindkingdom.org"));
                        startActivity(intent);
                        break;

                    case 6 :
                        intent = new Intent(getApplicationContext(), GivingWays.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getApplicationContext(), CrestInfo.class);
                        startActivity(intent);
                        break;

                    case 9 :
                        intent = new Intent(getApplicationContext(), VisionStatement.class);
                        startActivity(intent);
                        break;

                    case 11 :
                        intent = new Intent(getApplicationContext(), SevenRConcept.class);
                        startActivity(intent);
                        break;


                }

    */

    public void aboutOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),AboutUs.class);
        startActivity(intent);
    }

    public void socialMediaOnClick(View view){
        Intent intent = new Intent(getApplicationContext(), SocialMedia.class);
        startActivity(intent);
    }


    public void websiteOnClick(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newmindkingdom.org"));
        startActivity(intent);
    }

    public void sevenROnClick(View view){
        Intent intent = new Intent(getApplicationContext(), SevenRConcept.class);
        startActivity(intent);
    }

    public void visionOnClick(View view){
        Intent intent = new Intent(getApplicationContext(), VisionStatement.class);
        startActivity(intent);
    }

    public void crestOnClick(View view){
        Intent intent = new Intent(getApplicationContext(), CrestInfo.class);
        startActivity(intent);
    }

    public void givingOnClick(View view){
        Intent intent = new Intent(getApplicationContext(), GivingWays.class);
        startActivity(intent);
    }

    public void signUpOnClick(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/17AShdI3lj8vwOfxkhBoLcv_YRCqf4KOTY03Wq2guQCE/viewform?edit_requested=true"));
        startActivity(intent);
    }

    public void pastorOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PastorBiography.class);
        startActivity(intent);
    }




}
