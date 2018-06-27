package com.example.xaviernara.hikerwatch;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener locationListener;
    TextView latitudeTextView;
    TextView longitudeTextView;
    TextView addressTextView;
    TextView altitudeTextView;
    TextView accuracyTextView;

    /*
    this app does not utilize the map and it will start updating textViews as soon as the app is opened
    This app updates the textViews that pertain to the longitude/latitude, altitude, accuracy, and address based on the users location
    also when the user manually changes their location
    */




    //this method basically lets you know if the user said yes/no on granting permission to allow us to use their location
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {

            //this tells if the user gave permission or not
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //this method asks for permission from the user to use their location
                startListening();
            }
        }

    }

    public void startListening(){
        //this if statement basically checks to see if the user allows us to use their location and then we start tracking their location
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            //this tells us when the location is changed by the user and how long we will track it (amount of minutes and distance)
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView = findViewById(R.id.longitdueTextView);
        addressTextView = findViewById(R.id.addressTextView);
        altitudeTextView = findViewById(R.id.altitudeTextView);
        accuracyTextView = findViewById(R.id.accuracyTextView);


        //Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {

            //THIS method lets us write code when the location of the GPS has changed (ie moving the marker to the specific location on the map
            //based on the latitude & longitude of the user)
            @Override
            public void onLocationChanged(Location location) {

                updateLocationInfo(location);

            }

            //THIS method notifies us when the user changes the status of permission for GPS to track the user's location
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            //this tell us if the permission is granted from the user and they have a internet connection and lets us do something if it is
            @Override
            public void onProviderEnabled(String provider) {

            }


            //this tell us if the permission isn't granted from the user and lets us do something if it is
            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        //this if statement checks to see if the user has version 23 of Android and then asks for their location
        if (Build.VERSION.SDK_INT < 23) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } else {


            //REMEMBER TO ACCESS THE DETAILS OF LOCATION(altittude,latty,longitude,etc... you need to ask permission first)
            //this if statement basically checks to see if the user denies us to use their location and then asks them to give permission
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }

            //this else statement basically says the user gave us permission to use their location and then we start tracking their location
            else {

                //this tells us when the location is changed by the user and how long we will track it (amount of minutes and distance)
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                //this tells us the last Known Location from the users GPS
                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if(lastKnownLocation != null){
                    updateLocationInfo(lastKnownLocation);
                }
            }


        }
    }


    //this method takes in the lastKnownLocation after permission is given to use it to update h textViews that pertain to
    //to the longitude/latitude, altitude, accuracy, and address based on the users location
    public void updateLocationInfo(Location location){
       //Log.i("Location",location.toString()) ;
        latitudeTextView.setText("Latittude: " + Double.toString(location.getLatitude()));
        longitudeTextView.setText("Latittude: " + Double.toString(location.getLongitude()));
        altitudeTextView.setText("Altitude: "+ Double.toString(location.getAltitude()));
        accuracyTextView.setText("Accuracy: "+ Double.toString(location.getAccuracy()));


        String address = "Could not find address :(";
        //this will get the default Locale of the user's location(address) no matter if they where in Canada,Africa, etc...
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        //this list of address is equal to the max(best) result Latitude/longitude from the user's location
        try {
            List<Address> listAddress = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

            if (listAddress != null && listAddress.size() > 0) {
                address = "Address:\n";

                //this checks to see if the listAddress list's full address info from user's location isn't null
                //and adds that to the address string
                //address = city,state,postal code and street name
                if (listAddress.get(0).getAddressLine(0) != null) {
                    address += listAddress.get(0).getAddressLine(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        //the address textView is updated with the address information from the getAddressLine method
        addressTextView.setText(address);
    }
}

