package com.example.xaviernara.addingnewactivties;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import static java.util.Arrays.asList;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    /*
    this app switches the activity when one of the names on the listView is pressed
    and on the next activity a toast saying "hello" +name is displayed
    if the button is pressed it will cycle back to the 1st activity
    */

    //onClick method for previous button that would switch the screen to the next activity
    public void firstActivity(View view){


        //Intent is for what you WANT to do when you move to the another activity
        //Intent intent = new Intent(application Context, class you want to move to);
        //Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        //this moves the screen to the activity that the intent above says to
        //this basically stacks the activities on top of each other
        //(ie when the back button on the users device the screen will cycle back and forth thru the activities screens)
        //startActivity(intent);


        //this lets the user exit the app when the back button is pushed on the android device
        //instead of cycling back and forth thru the activities screens like the intent/startActivity way
        //but if the button is pressed then the activity will still switch back and forth like normal
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //to get the info you passed using the putExtra() method in the main activity you have to
        //create another intent in the class you want to use the info in
        Intent intent = getIntent();

        //intent.getIntExtra(exact name of the variable in the other class you want to pass,default value in case the info isnt sent over);
        //the info you sent has to be got by using the getExtra that pertains to the info sent over
        //Ex: if i send a double i have to use intent.getDoubleExtra()

        //int age = intent.getIntExtra("age",0);
        String names = intent.getStringExtra("friendsNames");

        //ArrayList<String> namesArrayList = new ArrayList<String>(asList(intent.getStringExtra("names","Joe"));

        Toast.makeText(this,"Hello "+names, Toast.LENGTH_SHORT).show();

        //Toast.makeText(this,Integer.toString(age), Toast.LENGTH_SHORT).show();

    }
}
