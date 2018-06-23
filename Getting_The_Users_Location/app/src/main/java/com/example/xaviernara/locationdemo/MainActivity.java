package com.example.xaviernara.locationdemo;

import android.Manifest;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener locationListener;

    //this method basically lets you know if the user said yes/no on granting permission to allow us to use their location
    @Override
    public void  onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]grantResults){

        super.onRequestPermissionsResult(requestCode,permissions,grantResults);

            //this tells if the user gave permission or not
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //this if statement basically checks to see if the user allows us to use their location and then we start tracking their location
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                //this tells us when the location is changed by the user and how long we will track it (amount of minutes and distance)
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
      locationListener = new LocationListener() {

            //THIS method lets us write code when the location of the GPS has changed
            @Override
            public void onLocationChanged(Location location) {
                Log.i("Location",location.toString());

            }

            //THIS method notifies us when the user changes the status of permission for GPS to track the user's location
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        //this if statement basically checks to see if the user denies us to use their location and then asks them to give permission
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1 );
        }
        //this else statement basically says the user gave us permission to use their location and then we start tracking their location
        else{
            //this tells us when the location is changed by the user and how long we will track it (amount of minutes and distance)
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }
}
