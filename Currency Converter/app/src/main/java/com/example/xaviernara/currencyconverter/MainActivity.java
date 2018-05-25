package com.example.xaviernara.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

//this method converts pounds to dollars
    public void clickFunction(View view){
        /*
        My way of converting pounds to dollars
        ////////////////////////////////////////////////////////////

        Log.i("Info","Convert button pressed");

        //this line of code will create a editText variable so you get the input data from the text field

        EditText currencyEditText = (EditText) findViewById(R.id.currencyEditText);

        //this line of code will Log the input to the text field (ie display the currency entered)
        Log.i("Amount of pounds",currencyEditText.getText().toString());

        //this line of code creates a double variable that equals the conversion of the editText variable(string) input from the user (pounds amount) to a double
        //basically this converts the pounds input amount to a dollar amount
        //double amountInDollarsDouble = Double.parseDouble(currencyEditText.getText().toString())*1.34;
        */

        /*
        This line of code will display a message to the bottom of the app screen
        Toast refers to the message pop ups, like toast from toaster
        */
        //Toast.makeText(this, currencyEditText.getText().toString()+"pounds is $"+amountInDollarsDouble+"!", Toast.LENGTH_LONG).show();

        /*
        This lines of code will convert the converted dollar amount(double) to string so it can be logged in the Logcat
        and also with the String.format("%.2f",..) it rounds the decimal amount to 2 decimal places
        Toast refers to the message pop ups, like toast from toaster
        */
        //String amountInDollarsString = String.format("%.2f",Double.toString(amountInDollarsDouble));
        //String amountInDollarsString = Double.toString(amountInDollarsDouble);
       // Log.i("Amount in dollars",amountInDollarsString);

////////////////////////////////////////////////////////////////////////////////
        //Udemy's Video's Way

        Log.i("Info","Convert button pressed");

        //this line of code will create a editText variable so you get the input data from the text field

        EditText currencyEditText = (EditText) findViewById(R.id.currencyEditText);

        String amountInPoundsString =currencyEditText.getText().toString();

        //this line of code will Log the input to the text field (ie display the pounds entered)
        Log.i("Amount of pounds",amountInPoundsString);

        //this lines of code creates a double variable that equals the conversion of the editText variable(string) input from the user (pounds amount) to a double
        //basically this converts the pounds input amount to a dollar amount

        double amountInDollarsDouble = Double.parseDouble(amountInPoundsString)*1.34;

         /*
        This lines of code will convert the converted dollar amount(double) to string so it can be logged in the Logcat
        and also with the String.format("%.2f",..) it rounds the decimal amount to 2 decimal places
        Toast refers to the message pop ups, like toast from toaster
        */
        String amountInDollarsString = String.format("%.2f",amountInDollarsDouble);

        /*
        This line of code will display a message to the bottom of the app screen
        Toast refers to the message pop ups, like toast from toaster
        */
        Toast.makeText(this, amountInPoundsString+"pounds is $"+amountInDollarsDouble+"!", Toast.LENGTH_LONG).show();

        Log.i("Amount in dollars",amountInDollarsString);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
