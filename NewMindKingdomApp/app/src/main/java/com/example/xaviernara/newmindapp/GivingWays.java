package com.example.xaviernara.newmindapp;

import android.content.Intent;
import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GivingWays extends AppCompatActivity {

    EditText amountText;
    TextView giveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giving_ways);

        //amountText =findViewById(R.id.amountText);
        //giveText = findViewById(R.id.giveTextView);
    }


    public void cashAppWebsiteLink(View view){
        Intent cashAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cash.app/$NewMindKingdom"));
        startActivity(cashAppIntent);
    }

    public void giveButtonOnClick(View view){

        //add in app purchases here

        Toast.makeText(this,"Thanks For Giving!!!",Toast.LENGTH_SHORT);

    }

    public void zelleWebsiteLink(View view){
        Intent zelleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cash.app/$NewMindKingdom"));
        startActivity(zelleIntent);
    }

    public void paypalWebsiteLink(View view){
        //https://www.paypal.com/donate/?token=numoyRPrpVKFprADwgP4NJrQTT542020KToPYXY48rwoHtbDUT1OHb0U3fOVEBnzHpz8R0&country.x=US&locale.x=US
        //Intent paypalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://newmindkingdom.org/give.html"));
        Intent paypalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/donate/?token=numoyRPrpVKFprADwgP4NJrQTT542020KToPYXY48rwoHtbDUT1OHb0U3fOVEBnzHpz8R0&country.x=US&locale.x=US"));
        startActivity(paypalIntent);
    }

}
