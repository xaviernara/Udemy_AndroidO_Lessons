package com.example.xaviernara.newmindapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class AboutUs extends Activity {

    ViewFlipper viewFlipper;

    TextView aboutUsText;
    String htmlText = "<p>New Mind Kingdom Ministries is a Life Skill teaching ministry with Destiny and a Destination in mind. Our focus and intent is to teach you the Word of God so that you can make it applicable to your everyday life. " +
            "“The Word works when YOU work it.” Wisdom is the correct application of knowledge. " +
            "Life is based on choices. Make wise choices, good life. Make foolish choices, foolish life.</p>\n" +
            "\n" +
            "<p>Deuteronomy 30:19 I call heaven and earth to record this day against you, that I have set before you life and death, blessing and cursing: therefore choose life, " +
            "that both thou and thy seed may live. We choose our life that consequently affects the lives around us. " +
            "Pastor Ward’s endeavor is to give you so much Word so that you may have ample amount of knowledge to apply wisdom in your choices to have an “Abundant life“  " +"</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        //Image slider in app:  https://youtu.be/G7ZOU8yKmdI
        int[] images = {R.drawable.biblestudy,R.drawable.sundayworship,R.drawable.symposium1,R.drawable.wellmeetyou,R.drawable.wellmeetyou2};
        viewFlipper = findViewById(R.id.viewFlipper);

        //for image looping
        for (int image : images) {
            flipperImages(image);

        }



        aboutUsText = findViewById(R.id.aboutUsText);
        aboutUsText.setText(Html.fromHtml(htmlText,Html.FROM_HTML_MODE_COMPACT));



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



    public void facebookWebsiteLink(View view){
        Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/NewMindKingdomMinistries/"));
        startActivity(fbIntent);
    }

    public void twitterWebsiteLink(View view){
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/newmindkingdom"));
        startActivity(twitterIntent);
    }

    public void instagramWebsiteLink(View view){
        Intent instragramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/newmindkingdom/"));
        startActivity(instragramIntent);
    }

    public void youtubeWebsiteLink(View view){
        Intent ytIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCyu_YbjuDswWIPD8YD4YR8w"));
        startActivity(ytIntent);
    }



}
