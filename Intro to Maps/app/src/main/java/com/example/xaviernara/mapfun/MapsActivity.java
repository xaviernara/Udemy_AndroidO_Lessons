package com.example.xaviernara.mapfun;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //id for the Google map
    private GoogleMap mMap;

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
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Add a marker in Tokyo,Japan and move the camera
        //LatLng means latitude and longitude
        //LatLng locationName = new LatLng(latitude, longitude);
        LatLng tokyo = new LatLng(35.6895, 139.6917);

        //mMap.addMarker(new MarkerOptions().position(tokyo).title("name of location")); adds a marker to the latitude and longitude
        //defined above (ie location)

        //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)) makes the marker the shows up green or whatever color you want
        //can also be customized to have bitmap images (ex: Lift car icons on map)
        mMap.addMarker(new MarkerOptions().position(tokyo).title("Tokyo, Japan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(tokyo)) allows the camera to move and zoom into a
        //location on the map based on the latitude and longitude above
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latitude, longitude)); = basic camera for the map over the location defined above

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latitude,longitude,cameraZoom)); = gives the ability to zoom in
        // 1<cameraZoom<20 1=normal camera(ie regular zoom), 20=most zoomed in
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tokyo,10));
    }
}
