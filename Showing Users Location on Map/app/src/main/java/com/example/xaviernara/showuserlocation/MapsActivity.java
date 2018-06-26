package com.example.xaviernara.showuserlocation;

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
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //DON'T FORGET TO INCLUDE  <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    //IN THE Android Manifest to access the exact location of the user instead of the general area

    //this app asks the user for permission to use their location (longitude and latitude) and then logs the exact address they are at and displays it as a toast
    //also if the user changes their location then the app will update the address accordingly (ie placing a marker on that specific location on the map)

    private GoogleMap mMap;

    LocationManager locationManager;
    LocationListener locationListener;

    //this method basically lets you know if the user said yes/no on granting permission to allow us to use their location
    @Override
    public void  onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]grantResults){

        super.onRequestPermissionsResult(requestCode,permissions,grantResults);


        if(requestCode==1){

            //this tells if the user gave permission or not
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //this if statement basically checks to see if the user allows us to use their location and then we start tracking their location
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    //this tells us when the location is changed by the user and how long we will track it (amount of minutes and distance)
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                }
            }
        }


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); =changes the way the map looks when the app is run
        //MAP_TYPE_HYBRID = hybrid of satellite and terrain map view
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {

            //THIS method lets us write code when the location of the GPS has changed (ie moving the marker to the specific location on the map
            //based on the latitude & longitude of the user)
            @Override
            public void onLocationChanged(Location location) {

                //mMap.clear(); = clears the map on the screen
                mMap.clear();
                //LatLng means latitude and longitude
                //LatLng locationName = new LatLng(latitude, longitude);
                LatLng userLocation = new LatLng(location.getLatitude(),location.getLongitude());

                //mMap.addMarker(new MarkerOptions().position(tokyo).title("name of location")); adds a marker to the latitude and longitude
                //defined above (ie location)

                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)) makes the marker the shows up green or whatever color you want
                //can also be customized to have bitmap images (ex: Lift car icons on map)
                mMap.addMarker(new MarkerOptions().position(userLocation).title("User Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


                //mMap.moveCamera(CameraUpdateFactory.newLatLng(tokyo)) allows the camera to move and zoom into a
                //location on the map based on the latitude and longitude above
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(latitude, longitude)); = basic camera for the map over the location defined above

                //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latitude,longitude,cameraZoom)); = gives the ability to zoom in
                // 1<cameraZoom<20 1=normal camera(ie regular zoom), 20=most zoomed in
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,10));

                //Log.i("Location",location.toString());
                //Toast.makeText(MapsActivity.this,location.toString(),Toast.LENGTH_SHORT).show();


                //this will get the default Locale of the user's location(address) no matter if they where in Canada,Africa, etc...
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());


                try {
                    //this list is equal to the max(best) result Latitude/longitude from the user's location
                   List<Address> listAddress = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);

                   //this if statement checks to see if we got any location info (address) from the user in the list then logs it
                   if(listAddress !=null && listAddress.size()>0){
                       //Log.i("Place info", listAddress.get(0).toString());
                       String address = "";

                       /*
                       //this checks to see if the listAddress list's thoroughfare (street info from user's location) isn't null
                       //and adds that to the address string
                       if(listAddress.get(0).getThoroughfare() !=null){
                           address+=listAddress.get(0).getThoroughfare()+" ";
                       }

                       //this checks to see if the listAddress list's locality (city info from user's location) isn't null
                       //and adds that to the address string
                       if(listAddress.get(0).getLocality() !=null){
                           address+=listAddress.get(0).getLocality()+ " ";
                       }

                       //this checks to see if the listAddress list's postal code (zip code from user's location) isn't null
                       //and adds that to the address string
                       if(listAddress.get(0).getPostalCode() !=null){
                           address+=listAddress.get(0).getPostalCode()+" ";
                       }

                       //this checks to see if the listAddress list's Admin Area(state info from user's location) isn't null
                       //and adds that to the address string
                       if(listAddress.get(0).getAdminArea() !=null){
                           address+=listAddress.get(0).getAdminArea();
                       }
                       */

                       //*OR TO GET ALL THIS INFO AT ONCE USE getAddressLine(0)*
                       //this checks to see if the listAddress list's full address info from user's location isn't null
                       //and adds that to the address string
                       //address = city,state,postal code and street name
                       if(listAddress.get(0).getAddressLine(0) !=null){
                           address += listAddress.get(0).getAddressLine(0);
                       }

                       //this toasts the address of the user location
                       Toast.makeText(MapsActivity.this,address,Toast.LENGTH_SHORT).show();
                       Log.i("Address",address);



                   }
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

        //this if statement checks to see if the user has version 23 of Android and then asks for their location
        if(Build.VERSION.SDK_INT < 23){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        else{

            //this if statement basically checks to see if the user denies us to use their location and then asks them to give permission
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1 );
            }

            //this else statement basically says the user gave us permission to use their location and then we start tracking their location
            else{

                //this tells us when the location is changed by the user and how long we will track it (amount of minutes and distance)
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                //this tells us the last Known Location from the users GPS
                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                //mMap.clear(); = clears the map on the screen
                mMap.clear();
                //LatLng means latitude and longitude
                //LatLng locationName = new LatLng(latitude, longitude);
                LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(),lastKnownLocation.getLongitude());

                //mMap.addMarker(new MarkerOptions().position(tokyo).title("name of location")); adds a marker to the latitude and longitude
                //defined above (ie location)

                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)) makes the marker the shows up green or whatever color you want
                //can also be customized to have bitmap images (ex: Lift car icons on map)
                mMap.addMarker(new MarkerOptions().position(userLocation).title("User Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


                //mMap.moveCamera(CameraUpdateFactory.newLatLng(tokyo)) allows the camera to move and zoom into a
                //location on the map based on the latitude and longitude above
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(latitude, longitude)); = basic camera for the map over the location defined above

                //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latitude,longitude,cameraZoom)); = gives the ability to zoom in
                // 1<cameraZoom<20 1=normal camera(ie regular zoom), 20=most zoomed in
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,10));


            }

        }



    }
}
