package com.example.hotanddoll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {

    Button button;

    EditText itemName,stock1,price1,total1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //button = findViewById(R.id.button);







    }


    public void sumTotal(View view){

       int totalSum = Integer.parseInt(stock1.getText().toString()) * Integer.parseInt(price1.getText().toString());

       String string = stock1.getText().toString() + "+" + totalSum;

       total1.setText(string);

       if (totalSum == 0) sendSMS();





    }



    //public void sendSMS(View view){
    public void sendSMS(){

        /*if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }*/


        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String ("2192901881"));
        smsIntent.putExtra("sms_body"  , itemName.getText().toString() + "is out of stock needs to be replaced");


        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(AboutUs.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }

    }



}