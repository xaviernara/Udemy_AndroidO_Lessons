package com.example.xaviernara.newmindapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GivingWays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giving_ways);
    }


    public void cashAppWebsiteLink(View view){
        Intent cashAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cash.app/$NewMindKingdom"));
        startActivity(cashAppIntent);
    }

    public void zelleWebsiteLink(View view){
        Intent zelleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cash.app/$NewMindKingdom"));
        startActivity(zelleIntent);
    }

    public void paypalWebsiteLink(View view){
        Intent paypalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://newmindkingdom.org/give.html"));
        startActivity(paypalIntent);
    }

}
