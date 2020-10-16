package com.example.xaviernara.newmindapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
//import android.support.v4.app.ActivityCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import static com.google.android.material.navigation.NavigationView.*;

public class Home extends Activity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ViewFlipper viewFlipper;
    //Login login = new Login();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*------------------View flipper-------------*/
        viewFlipper = findViewById(R.id.viewFlipper);

        //int[] images = {R.drawable.home_gallery1,R.drawable.home_gallery2,R.drawable.home_gallery3,R.drawable.home_gallery4,R.drawable.home_gallery5,R.drawable.home_gallery6};

        int[] images = {R.drawable.home_gallery1,R.drawable.home_gallery2,R.drawable.home_gallery3,R.drawable.home_gallery4,R.drawable.home_gallery5,R.drawable.home_gallery6,
            R.drawable.home_gallery7,R.drawable.home_gallery8,R.drawable.home_gallery9,R.drawable.home_gallery10,R.drawable.home_gallery11,R.drawable.home_gallery12};
        for(int i = 0; i<images.length;i++){
            flipperImages(images[i]);

        }






        //hOW TO IMPLEMENT Navigation bar: https://youtu.be/m1RV0HPuBWo
        /*-------------Hooks---------------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        /*------------------Hamburger toggle button----*/
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        /*-------------Toolbar---------------------------*/
        //getSupportActionBar().hide();
        toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        /*-------------Navigation Drawer menu---------------------------*/
        //click event listener for nav bar menu items:    https://www.youtube.com/watch?time_continue=78&v=67NRmoHp1NY&feature=emb_logo
        navigationView.bringToFront();


        navigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()){

                    case R.id.nav_home:
                        Toast.makeText(Home.this,"Your Home",Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_contact_us:
                            Intent intent = new Intent(getApplicationContext(),ContactUs.class);
                            startActivity(intent);
                            return true;

                    case R.id.nav_logout:
                        //login.getmAuth().signOut();
                        //if the users clicks the log out button view this will direct them to the login activity
                        FirebaseAuth.getInstance().signOut();
                        intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        return true;

                    case R.id.nav_settings:
                        Toast.makeText(Home.this,"Coming soon",Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_gallery:
                        intent = new Intent(getApplicationContext(),Gallery.class);
                        startActivity(intent);
                        //Toast.makeText(Home.this, "Gallery Coming soon",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_announcements:
                        //intent = new Intent(getApplicationContext(),Gallery.class);
                        //startActivity(intent);
                        Toast.makeText(Home.this,"Announcements Coming soon ",Toast.LENGTH_SHORT).show();

                    case R.id.nav_membership:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://newmindkingdom.org/join-our-ministry.html"));
                        startActivity(intent);
                        return true;


                }
                return true;
            }
        });
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/
        //navigationView.setNavigationItemSelectedListener((OnNavigationItemSelectedListener) this);
        navigationView.setCheckedItem(R.id.nav_home);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    /*  @Override
    public boolean OnNavigationItemSelectedListener(@NonNull MenuItem menuItem){

        return false;

        //THIS WILL CLOSE THE DRAWER WHEN PREFORMING A ACTION(EX switching to another activity )
        drawerLayout.closeDrawer(GravityCompact.START);

    }*/



    //this method will allow the navigation bar to closed when the back button on the phone is pressed instead of the whole application
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else{
            super.onBackPressed();
        }


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
        //finish();
    }


    public void flipperImages (int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(15000); // 15 seconds
        viewFlipper.setAutoStart(true);

        //animation
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }


/*
    public void socialMediaOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SocialMedia.class);
        startActivity(intent);
        //finish();
    }
*/

    public void previousSermonsOnClick(View view) {
        //Intent intent = new Intent(getApplicationContext(), PreviousMessages.class);
        /*Intent intent = new Intent(getApplicationContext(), Store.class);
        startActivity(intent);*/

        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCyu_YbjuDswWIPD8YD4YR8w"));
        startActivity(intent);

        //finish();
    }






    public void websiteOnClick(View view) {
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newmindkingdom.org"));
        startActivity(intent);
        //finish();
    }

    public void sevenROnClick(View view) {
        intent = new Intent(getApplicationContext(), SevenRConcept.class);
        startActivity(intent);
        //finish();
    }

    public void visionOnClick(View view) {
        intent = new Intent(getApplicationContext(), VisionStatement.class);
        startActivity(intent);
       // finish();
    }

    public void crestOnClick(View view) {
        intent = new Intent(getApplicationContext(), CrestInfo.class);
        startActivity(intent);
        //finish();
    }

    public void givingOnClick(View view) {
        intent = new Intent(getApplicationContext(), GivingWays.class);
        startActivity(intent);
        //finish();
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
        intent = new Intent(getApplicationContext(), PastorBiography.class);
        startActivity(intent);
        //finish();
    }

    public void beliefsOnClick(View view) {
        intent = new Intent(getApplicationContext(), BeliefsActivity.class);
        startActivity(intent);
        //finish();
    }

    public void locationOnClick(View view){
        intent = new Intent(getApplicationContext(), LocationActivity.class);
        startActivity(intent);
        //finish();
    }


    //https://abhiandroid.com/ui/alertdialog
    //will display a alert dialog when clicked showing image
    public void storeOnClick(View view){
        /*Intent intent = new Intent(getApplicationContext(), Store.class);
        startActivity(intent);*/
        //finish();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.mipmap.coming_soon);

        alertDialogBuilder.setPositiveButton("Can Hardly Wait!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //when button is clicked the dialog box will close
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


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

    //if the users clicks the log out button view this will direct them to the login activity
    public void logOut(View view){

        FirebaseAuth.getInstance().signOut();
        intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        //finish();

    }











}
