package com.example.xaviernara.newmind2;

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
        //https://www.paypal.com/donate/?token=numoyRPrpVKFprADwgP4NJrQTT542020KToPYXY48rwoHtbDUT1OHb0U3fOVEBnzHpz8R0&country.x=US&locale.x=US
        //Intent paypalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://newmindkingdom.org/give.html"));
        Intent paypalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("//https://www.paypal.com/donate/?token=numoyRPrpVKFprADwgP4NJrQTT542020KToPYXY48rwoHtbDUT1OHb0U3fOVEBnzHpz8R0&country.x=US&locale.x=US"));
        startActivity(paypalIntent);
    }
}
