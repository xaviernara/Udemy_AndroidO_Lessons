package com.example.xaviernara.exampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //when you make a button and you want something to happen when the button is clicked you must create a method
    // and send it a "View" variable to complete the action from the view class
    public void clickFucntion(View view){
        Log.i("Info","Button Pressed!"); //with this line of code a message in log will display when a  button is clicked that calls this function
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}