package com.example.xaviernara.newmind2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Home extends Activity {



    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void aboutOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutUs.class);
        startActivity(intent);
    }

    public void socialMediaOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SocialMedia.class);
        startActivity(intent);
    }


    public void websiteOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newmindkingdom.org"));
        startActivity(intent);
    }

    public void sevenROnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SevenRConcept.class);
        startActivity(intent);
    }

    public void visionOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), VisionStatement.class);
        startActivity(intent);
    }

    public void crestOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), CrestInfo.class);
        startActivity(intent);
    }

    public void givingOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), GivingWays.class);
        startActivity(intent);
    }

    public void signUpOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/17AShdI3lj8vwOfxkhBoLcv_YRCqf4KOTY03Wq2guQCE/viewform?edit_requested=true"));
        startActivity(intent);
    }

    public void pastorOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), PastorBio.class);
        startActivity(intent);
    }

    public void beliefsOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), BeliefsActivity.class);
        startActivity(intent);
    }

    public void locationOnClick(View view){
        Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(intent);
    }


    //https://www.tutorialspoint.com/android/android_phone_calls.htm
    public void phoneOnClick(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel: + 2198038331"));
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




}
