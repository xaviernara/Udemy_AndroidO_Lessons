package com.example.xaviernara.higherorlowerguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    public void randomNumberGenerator(){
        Random random = new Random();
        int randomNumber = random.nextInt(20)+1;
    }

    int randomNumber;

    public void guessFunction(View view ){

        EditText guessEditText = findViewById(R.id.guessEditText);

        int guessedNumber = Integer.parseInt(guessEditText.getText().toString());
        Log.i("Guess was made",guessEditText.getText().toString() );

        //this 2 lines of code create a random number between 1 and 20
        //remember to first create a random object and then create a variable that follows the template:
        //int randomNumber = random.nextInt(higher bond)+lower bound;
        //Random random = new Random();
        //int randomNumber = random.nextInt(20)+1;

        //these lines of code will test if the random number is higher or lower the guessed number

        String message;

        if (guessedNumber > randomNumber ) {
            //Toast.makeText(this, "LOWER", Toast.LENGTH_LONG);
            message = "lower";
            Log.i("Info","Button is pressed");
        }

        else if (guessedNumber < randomNumber) {
                //Toast.makeText(this,"HIGHER",Toast.LENGTH_LONG);
            message="Higher";
            Log.i("Info","Button is pressed");
        }

        else{
                //Toast.makeText(this,"Correct",Toast.LENGTH_LONG);
            message="Correct! Try Again?";
            Log.i("Info","Button is pressed");
            randomNumberGenerator();
            }

            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Log.i("Random Number",Integer.toString(randomNumber));
        Log.i("Guess was made",guessEditText.getText().toString() );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this 2 lines of code create a random number between 1 and 20
        //remember to first create a random object and then create a variable that follows the template:
        //int randomNumber = random.nextInt(higher bond)+lower bound;
        //Random random = new Random();
        //int randomNumber = random.nextInt(20)+1;
        randomNumberGenerator();
    }
}
