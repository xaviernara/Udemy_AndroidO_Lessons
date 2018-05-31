package com.example.xaviernara.appnumbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import static android.util.Log.i;

public class MainActivity extends AppCompatActivity {

    public boolean isSquare(int number){
        boolean squareNumber;
        double sqrt = Math.sqrt(number);
        //This checks if the rounded-down value of the double is the same as the double
        //Your variable could have an int or double value and Math.floor(variable) always has an int value,
        //so if your variable is equal to Math.floor(variable) then it must have an int value.

        if (sqrt==Math.floor(sqrt)) {
            return squareNumber= true;
        }
        else{
            return squareNumber=false;
        }


        /*
        int x = (int) sqrt;
        if(Math.pow(sqrt,2) == Math.pow(x,2)){
            return squareNumber= true;
        }
        else{
            return squareNumber=false;
        }
        */

    }

    public boolean isTriangular(int number){
        boolean triangular=true;
        int triangularNumber = number*(number+1)/2;
        int count=1;
        while (triangularNumber<number){

        }


        if (number == number*(number+1)/2){
            return triangular;
        }
        else{
            return triangular=false;
        }

    }

    public boolean isSquare(int number){
        boolean triangular=true;
        if (number == (number+1)/2){
            return triangular;
        }
        else{
            return triangular=false;
        }
    }

    public void testNumber(View view){
        EditText number = (EditText) findViewById(R.id.number);

        int testNumber = Integer.parseInt(number.getText().toString());



        Log.i("Info", "Button is pressed");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
