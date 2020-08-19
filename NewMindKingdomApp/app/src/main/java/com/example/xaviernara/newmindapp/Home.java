package com.example.xaviernara.newmindapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
//import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import androidx.core.app.ActivityCompat;

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

    public void aboutOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutUs.class);
        startActivity(intent);
        finish();
    }

    public void socialMediaOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SocialMedia.class);
        startActivity(intent);
        finish();
    }


    public void websiteOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newmindkingdom.org"));
        startActivity(intent);
        finish();
    }

    public void sevenROnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SevenRConcept.class);
        startActivity(intent);
        finish();
    }

    public void visionOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), VisionStatement.class);
        startActivity(intent);
        finish();
    }

    public void crestOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), CrestInfo.class);
        startActivity(intent);
        finish();
    }

    public void givingOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), GivingWays.class);
        startActivity(intent);
        finish();
    }

    /*
    Not needed because the SignUp class holds this with firebase

    public void signUpOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/17AShdI3lj8vwOfxkhBoLcv_YRCqf4KOTY03Wq2guQCE/viewform?edit_requested=true"));
        startActivity(intent);
        finish();
    }
    */

    public void pastorOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), PastorBiography.class);
        startActivity(intent);
        finish();
    }

    public void beliefsOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), BeliefsActivity.class);
        startActivity(intent);
        finish();
    }

    public void locationOnClick(View view){
        Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(intent);
        finish();
    }


    //https://www.tutorialspoint.com/android/android_phone_calls.htm
    public void phoneOnClick(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel: +2198032331"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }

    //if the users clicks the log out text view this will direct them to the login activity
    public void logOut(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();

    }




}
