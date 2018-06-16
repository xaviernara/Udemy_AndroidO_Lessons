package com.example.xaviernara.downloadingimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    /*
    this program will download a image from website via url
    DONT FORGET TO ADD:  <uses-permission android:name="android.permission.INTERNET"/> TO THE android manifest
    to get permission to use the internet
   */

    public void downloadImage(View view){
        ImageDownloader task = new ImageDownloader();
        Bitmap  myImage;


        //execute("website url").get() will send the url to the do in background method as a string
        //remember that when you use a try and catch when your using the execute("website url").get()
        //ie when sending in a website url because the user might not have internet connection, access to the website or etc..
        //and if internet access fails then the try,catch will catch the exception and print it

        try {

            //remember you must have the "https://www" part for the code to work
            //once the excute().get() returns the bitmap, myImage will house the image (bitmap)
            myImage = task.execute("https://imge.androidappsapk.co/poster/a/6/f/com.app.top.cupheadwallpaper_1.png").get();
            imageView.setImageBitmap(myImage);
        } catch (Exception e) {

            // e.printStackTrace() prints the exception to the logcat
            e.printStackTrace();
        }

        Log.i("Button pressed", "ok");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView2);
    }

    //AsyncTask<Parameter (passing in),progress, result(passing out)>
    //Bitmap is a way to return a image
    public class  ImageDownloader extends AsyncTask<String,Void,Bitmap>{

        //this method will do the gathering of the website content in the background
        @Override
        /*
            protected allows the other methods to have access to this method that's included in the package or anywhere in the class
            String... urls means you can send in arrays or as many strings as you like
            notice that the type of method this is matches the result of the AsyncTask<>
            ,meaning its gonna return a bitmap
        */
        protected Bitmap doInBackground(String... urls) {
            try {
                //url = new URL(urls[0]) converts the url string into a URL object
                //urls[0] means getting the very first char of the url string
                URL url = new URL(urls[0]);

                //HttpURLConnection = the html code of a website and it will contained in this object
                //urlConnection = (HttpURLConnection) url.openConnection(); makes (ie opens) a connection to the http url
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                //connection.connect();= connecting the connection to the url
                connection.connect();

                //these 2 lines reads the urls html code (ie gathering the data) like a file once there's a open connection
                InputStream in = connection.getInputStream();

                //Bitmap myBitmap = BitmapFactory.decodeStream(in);= decodes the InputStream and adds it to the bitmap
                Bitmap myBitmap = BitmapFactory.decodeStream(in);

                // return myBitmap;= returns the bitmap (ie image)
                return myBitmap;

            } catch (Exception e) {

                //IF a exception is found then the exception will be printed and null will be returned
                e.printStackTrace();
                return null;
            }

        }
    }
}
