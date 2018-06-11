package com.example.xaviernara.showhideuielements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    public void invisibleText (View view){
        textView = (TextView) findViewById(R.id.textView);

        textView.setVisibility(View.INVISIBLE);

        Log.i("Button Pressed", "Text Invisible");
   }

   public void visibleText (View view){

       textView = (TextView) findViewById(R.id.textView);

       textView.setVisibility(View.VISIBLE);

       Log.i("Button Pressed", "Text Visible");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
