package com.example.xaviernara.newmindapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {

    EditText subjectText,messageText,titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        subjectText = findViewById(R.id.subjectText);
        messageText = findViewById(R.id.messageText);
        titleText = findViewById(R.id.titleText);
    }



    /*String greetingsEmail = "Greetings,\n" +
            "\n" +
            "We here at New Mind Kingdom Ministries would like to inform you of our new\n" +
            "location and welcome you to attend our Sunday morning worship experience.\n" +
            "We start our service on Sunday at 10:00 am promptly at 6213 Kennedy Ave. in\n" +
            "Hammond, IN. We also invite you to join us via social media on Tuesday mornings\n" +
            "at 7:00 am and at 8:00 pm on Wednesday evenings for a unique worship and\n" +
            "prophetic experience. We wish to connect with you so that we can work together\n" +
            "to advance the Kingdom! Please feel free to connect with us, we would love to\n" +
            "see you! We hope to see you soon here at the Mind!\n" +
            "\n" +
            "Advancing the Kingdom,\n" +
            "\n" +
            "New Mind Kingdom Ministries";

        Log.i("Send Email", "");
    Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailText.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Welcome to New Mind Kingdom Ministries!");
        emailIntent.putExtra(Intent.EXTRA_TEXT,greetingsEmail);

        try{
        startActivity(Intent.createChooser(emailIntent,"Send New User Email..."));
        finish();
        Log.i("Finish Sending Email", "");

    }catch(android.content.ActivityNotFoundException ex){

        Toast.makeText(SignUp.this,"Error: "+ex.getMessage(),Toast.LENGTH_SHORT).show();

    }*/

    public void emailButtonOnClick(View view){

        String title = titleText.getText().toString();
        String message = messageText.getText().toString();
        String subject = subjectText.getText().toString();
        String emailAddress = "info@newmindkingdom.org";


        if(title.isEmpty()){
            titleText.setError("Title is required");
            return;
        }

        if(message.isEmpty()) {
            messageText.setError("Message is required");
            return;
        }
        if(subject.isEmpty()){
            subjectText.setError("Subject is required");
            return;
        }




        if(!title.isEmpty() && !message.isEmpty() && !subject.isEmpty() ){

            Log.i("Send Email", "");
            Intent emailIntent = new Intent(Intent.ACTION_SEND);

            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_TITLE,title);
            emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {emailAddress});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
            emailIntent.putExtra(Intent.EXTRA_TEXT,message);


            emailIntent.setType("message/rfc882");

            try{
                startActivity(Intent.createChooser(emailIntent,"Choose an Email Client..."));
                finish();
                Log.i("Finish Sending Email", "");
                Toast.makeText(this,"Thanks for Contacting Us!!!",Toast.LENGTH_SHORT).show();


            }catch(android.content.ActivityNotFoundException ex){

                Toast.makeText(this,"Error: "+ex.getMessage(),Toast.LENGTH_SHORT).show();

            }


        }



    }

}