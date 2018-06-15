package com.example.xaviernara.downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


//this program will log some of the html from a website (ie downloading web content)
//DONT FORGET TO ADD:  <uses-permission android:name="android.permission.INTERNET"/> TO THE android manifest
//to get permission to use the internet

public class MainActivity extends AppCompatActivity {

    //AsyncTask<Parameter (passing in),progress, result(passing out)>
    //
    public class  DownloadTask extends AsyncTask<String,Void,String>{

        //this method will do the gathering of the website content in the background
        //(ie take in the url's html code as a string and write it to the log)
        @Override
        //protected allows the other methods to have access to this method that's included in the package or anywhere in the class
        //String... urls means you can send in arrays or as many strings as you like
        //notice that the type of method this is matches the parameter of the AsyncTask<>
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            //HttpURLConnection = the html code of a website and it will contained in this object
            HttpURLConnection urlConnection = null;

            try {
                //url = new URL(urls[0]) converts the url string into a URL
                url = new URL(urls[0]);

                //urlConnection = (HttpURLConnection) url.openConnection(); makes (ie opens) a connection to the http url
                urlConnection = (HttpURLConnection) url.openConnection();
                //these 2 lines reads the urls html code (ie gathering the data) like a file once there's a open connection
                //it reads the data char by char
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();


                //while (data!= -1) means that while theres still more data to read keep reading (ie more char to read keep reading)
                //and if data==-1 then everything's been read or theres nothing to read
                while (data!= -1){
                    //char current  = (char) data; converts the data read into a char
                    char current  = (char) data;

                    //result += current; adds the chars read into the string above and returned to the screen
                    result += current;
                    //data = reader.read(); tells the Inputstream to keep reading the data char by char
                    data = reader.read();
                }
                return result;

            }
            catch (Exception e){
                //IF a exception is found then the execpetion will be printed and failed will be returned
                e.printStackTrace();
                return "Failed";
            }

            //Log.i("URL:",strings[0]);
            //return "Done";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();
        //remember to initialize variables
        String result=null;

        //execute("website url").get() will send the url to the do in background method as a string
        //remember that when you use a try and catch when your using the execute("website url").get()
        //ie when sending in a website url because the user might not have internet connection, access to the website or etc..
        //and if internet access fails then the try,catch will catch the exception and print it

        try{
            //remember you must have the "https://www" part for the code to work
           result = task.execute("https://www.zappycode.com").get();
        }
        catch (Exception e){
            // e.printStackTrace() prints the exception to the logcat
            e.printStackTrace();
        }

        Log.i("Result:", result);

    }
}
