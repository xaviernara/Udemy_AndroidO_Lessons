package com.example.xaviernara.interactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.xaviernara.exampleapp.R;

public class Main2Activity extends AppCompatActivity {

    public void clickFunction(View view){
        //this line of code will create a editText variable so you get the input data from the text field
        EditText userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        //this line of code will Log the input to the text field (ie display the username entered)
        Log.i("User Name",userNameEditText.getText().toString());

        //this line of code will create a editText variable so you get the input data from the text field
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        //this line of code will Log the input to the text field (ie display the password entered)
        Log.i("Password",passwordEditText.getText().toString());


        //this line of code will log when the log in button is pressed
        Log.i("Button Info","Log In is pressed");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
