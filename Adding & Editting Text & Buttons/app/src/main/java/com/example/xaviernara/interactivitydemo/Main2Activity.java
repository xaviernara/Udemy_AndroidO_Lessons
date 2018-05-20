package com.example.xaviernara.interactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.xaviernara.exampleapp.R;

public class Main2Activity extends AppCompatActivity {

    public void clickFunction(View view){
        Log.i("Button Info","Button is pressed" );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
