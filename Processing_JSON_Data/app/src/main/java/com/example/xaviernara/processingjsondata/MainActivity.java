package com.example.xaviernara.processingjsondata;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    //JSON = Javascript Object Notation
    //this app lets the user type in a name of a city and by a click of a button find out the weather of the city
    //(ie download the weather from JSON code from a weather website based on the user's input )


    EditText cityEditText;
    Button weatherButton;
    TextView weatherTextView;


    //DONT FORGET TO ADD:  <uses-permission android:name="android.permission.INTERNET"/> TO THE android manifest
    //to get permission to use the internet


    //AsyncTask<Parameter (passing in),progress, result(passing out)>
    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        //protected allows the other methods to have access to this method that's included in the package or anywhere in the class
        //String... urls means you can send in arrays or as many strings as you like
        //notice that the type of method this is matches the parameter of the AsyncTask<>
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data!=1){
                    char current = (char) data;
                    result+=current;
                    data = reader.read();
                }
                return result;

            } catch (Exception e) {
                e.printStackTrace();

                Toast.makeText(getApplicationContext(),"Could not find weather :(", Toast.LENGTH_SHORT).show();
                return null;
            }
        }

        //this method lets you write some code after the method above is finished doing stuff
        //in the background (ie after a connection to the internet is made in the background)
            protected void onPostExecute(String result){
            //String result = the JSON code from the website
                // and its being printed out
            super.onPostExecute(result);
            Log.i("JSON", result);


            try{
                //JSONObject is used to access the JSON code that's in result
                JSONObject jsonObject = new JSONObject(result);

                //String weatherInfo = jsonObject.getString("weather"); = the JSON weather array of the JSON code
                //the string in the getString(" ") has to match the JSON code exactly so you can get the data from that array

                String weatherInfo = jsonObject.getString("weather");

                //this logs the JSON weather array info that pertains to the city the user put entered
                Log.i("Weather content", weatherInfo);

                String message =" ";

                JSONArray jsonArray = new JSONArray(weatherInfo);

                for (int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonPart = jsonArray.getJSONObject(i);

                    //these 2 lines get the info from the array part of JSON code that pertains to main & description
                    //and puts into a string
                    //main = the overall weather & description = a description of the weather
                    //EX:main =Rain in London
                    //
                    //EX:description = light drizzle in London

                    String main = jsonPart.getString("main");
                    String description = jsonPart.getString("description");

                    //if both main and description != empty then store the info from the JSON code into message
                        if (!main.equals(" ")&& !description.equals(" ")){
                            message += main + ":"+description+ "\r\n";
                        }
                    Log.i("main",jsonPart.getString("main"));
                    Log.i("description",jsonPart.getString("description"));
                    }

                //if both message != empty then set the text of the textView to message
                if (!message.equals(" ")){
                    weatherTextView.setText(message);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Could not find weather :(", Toast.LENGTH_SHORT).show();
                }


                }
            catch (Exception e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Could not find weather :(", Toast.LENGTH_SHORT).show();

            }


        }
    }

    public void getWeather(View view){
        DownloadTask task = new DownloadTask();
        //remember to initialize variables
        //String result=null;

        //execute("website url").get() will send the url to the do in background method as a string
        //remember that when you use a try and catch when your using the execute("website url").get()
        //ie when sending in a website url because the user might not have internet connection, access to the website or etc..
        //and if internet access fails then the try,catch will catch the exception and print it


        //String cityNames = the cities the user will write in the editText
        //use String.valueOf(cityEditText.getText()) to get the text from the editText
        //or cityEditText.getText().toString();
        String cityNames = cityEditText.getText().toString();

        try {

            //line of code handles the city names that have a space in them and formats the input properly so
            //the correct URL can be found
            String encodedCityName = URLEncoder.encode(cityNames,"UTF-8");


            //remember you must have the "https://www" part for the code to work

            //to get the weather from the city the user wants we have to replace the part in the API url
            //for a certain city, where the name of the city with the text from the editText entered by the user
            //EX:"http://openweathermap.org/data/2.5/weather?q="chicago"&appid=b6907d289e10d714a6e88b30761fae22"
            task.execute("http://openweathermap.org/data/2.5/weather?q=" + encodedCityName + "&appid=b6907d289e10d714a6e88b30761fae22").get();

            //THIS code makes the keyboard disappear after the clicks the button to get the weather from a certain
            //city
            //basically this makes the keyboard go away after the button is clicked and doesnt get in the ay of the textView
            //displayed on the screen
            InputMethodManager manager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(cityEditText.getWindowToken(),0);
        }
        catch (Exception exception){
            // e.printStackTrace() prints the exception to the logcat
            Toast.makeText(getApplicationContext(),"Could not find weather :(", Toast.LENGTH_SHORT).show();
            exception.printStackTrace();
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityEditText = findViewById(R.id.cityEditText);
        weatherButton = findViewById(R.id.weatherButton);
        weatherTextView =findViewById(R.id.weatherTextView);

        /*
        DownloadTask task = new DownloadTask();
        //remember to initialize variables
        //String result=null;

        //execute("website url").get() will send the url to the do in background method as a string
        //remember that when you use a try and catch when your using the execute("website url").get()
        //ie when sending in a website url because the user might not have internet connection, access to the website or etc..
        //and if internet access fails then the try,catch will catch the exception and print it

        try {
            //remember you must have the "https://www" part for the code to work
            result = task.execute("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").get();
        }
        catch (Exception exception){
            // e.printStackTrace() prints the exception to the logcat
                exception.printStackTrace();
        }
        */

        //Log.i("Result:", result);
    }
}
