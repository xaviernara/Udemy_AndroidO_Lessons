package com.example.xaviernara.newmind2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SocialMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
    }

    //https://www.facebook.com/NewMindKingdomMinistries/
    //https://twitter.com/newmindkingdom
    //https://www.instagram.com/newmindkingdom/
    //join ministry link : https://docs.google.com/forms/d/17AShdI3lj8vwOfxkhBoLcv_YRCqf4KOTY03Wq2guQCE/viewform?edit_requested=true


    public void facebookWebsiteLink(View view){
        Intent cashAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/NewMindKingdomMinistries/"));
        startActivity(cashAppIntent);
    }

    public void twitterWebsiteLink(View view){
        Intent zelleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/newmindkingdom"));
        startActivity(zelleIntent);
    }

    public void instagramWebsiteLink(View view){
        Intent paypalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/newmindkingdom/"));
        startActivity(paypalIntent);
    }

    public void youtubeWebsiteLink(View view){
        Intent paypalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCyu_YbjuDswWIPD8YD4YR8w"));
        startActivity(paypalIntent);
    }

}
