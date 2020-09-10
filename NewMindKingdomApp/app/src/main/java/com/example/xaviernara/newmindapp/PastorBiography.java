package com.example.xaviernara.newmindapp;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PastorBiography extends AppCompatActivity {


   /* //onClick method for previous button that would switch the screen to the next activity
    public void firstActivity(View view){


        //Intent is for what you WANT to do when you move to the another activity
        //Intent intent = new Intent(application Context, class you want to move to);
        //Intent intent = new Intent(getApplicationContext(),ListNotUsedActivity.class);

        //this moves the screen to the activity that the intent above says to
        //this basically stacks the activities on top of each other
        //(ie when the back button on the users device the screen will cycle back and forth thru the activities screens)
        //startActivity(intent);


        //this lets the user exit the app when the back button is pushed on the android device
        //instead of cycling back and forth thru the activities screens like the intent/startActivity way
        //but if the button is pressed then the activity will still switch back and forth like normal
        finish();
    }*/


   String htmlText = " <p>Prophet Frederick E. Ward was born in Chicago, IL at Mount Sinai Hospital (There is a spiritual" +
           "significance) on July 7 th 1966 to the proud parents of Mary L. Ward and the late Raymond Ward." +
           "Raised on the far Southside of Chicago, moving from the Englewood neighborhood, he primarily" +
           "grew up in the Altgeld Gardens (Chicago Housing Projects) “Block 8 for Life”.</p>" +

           "\n <p>He began his education at Phyllis Wheatly Child Parent Center, Carver Primary, Isaac Newton" +
           "and Carver Middle School. He matriculated to Greenwood, Mississippi attending Greenwood" +
           "High School while living with his Grand Mother Willie Mae Adams for his first year. He" +
           "returned to Chicago and attended George W. Carver Area High School, graduating in June of" +
           "1985. He continued his education at Olive-Harvey Community College. Leaving college, he" +
           "acquired employment to assist his mother in purchasing a house to leave Altgeld. He returned to" +
           "college attending Logos Ministerial Institute graduating receiving his ordination May of 1991.</p> \n" +
           "<p>He began going to Church with his mother at Progressive Missionary Baptist Church the late Dr." +
           "John Digby pastor. He felt the pull of God on his life and in grade school, he began to attend" +
           "Altgeld Seven Day Adventist. He later began playing drums at United Presbyterian Church under" +
           "pastorate of Reverend Gordon Marshall where he preached his first sermon at the age of 14. He" +
           "met his father Bishop Claude E. Tears at a tent revival in 1979. He joined and was baptized at 1st" +
           "Corinthians Baptist Church. Holy Spirit continued to move in Prophet’s life and led him to" +
           "Liberty Temple Full Gospel Church. Where he was planted and bloomed under the opuses of" +
           "Apostle Clifford E. and the late Denise M. Turner.</p>" +
           "\n <p>In of 1999, His father; Bishop Claude E. Tears set Prophet Ward in the Office of the Prophet. He" +
           "later began Power Ministries Baptist Church and World Outreach Ministries then Renewing the" +
           "Mind Ministries. This planted the seed for New Mind Kingdom Ministries." +
           "His quiver is full with 6 beautiful children; Antoine, Christopher, Jessica, Frederick Jr, Roben," +
           "and Irmani. Proud Pa-Pa to three grand babies, Jaylen, Joshua and Teagan To GOD be all Glory!</p>";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastor_biography);

        /*
        //to get the info you passed using the putExtra() method in the main activity you have to
        //create another intent in the class you want to use the info in
        Intent intent = getIntent();

        //intent.getIntExtra(exact name of the variable in the other class you want to pass,default value in case the info isnt sent over);
        //the info you sent has to be got by using the getExtra that pertains to the info sent over
        //Ex: if i send a double i have to use intent.getDoubleExtra()

        String listChoice = intent.getStringExtra("churchList");

        Toast.makeText(this,"Hello "+listChoice, Toast.LENGTH_SHORT).show();
         */

        //Html html = (Html)findViewById(R.id.pastorBio);


        TextView pastorBio = findViewById(R.id.pastorBio);
        pastorBio.setText(Html.fromHtml(htmlText,Html.FROM_HTML_MODE_COMPACT));
    }


    public void pastorFacebookOnClick(View view){
        Intent cashAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/frederick.ward.7"));
        startActivity(cashAppIntent);
    }

    public void pastorTwitterOnClick(View view){
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/prophetwar1"));
        startActivity(twitterIntent);
    }

    public void pastorCashappOnClick(View view){
        Intent cashAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cash.app/$fewprophet"));
        startActivity(cashAppIntent);
    }


}
