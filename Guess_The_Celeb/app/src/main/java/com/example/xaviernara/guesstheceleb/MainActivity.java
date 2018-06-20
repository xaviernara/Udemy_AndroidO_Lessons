package com.example.xaviernara.guesstheceleb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //this app will randomly download image urls from the html form the website "http://www.posh24.se/kandisar"
    //by using the matcher and pattern methods
    // basically this app will allow the user to play a game where 4 celeb names will be displayed on  buttons
    // and a image from the above website will be on the imageview and the user can guess which celeb it is by button push
    //and if the user is correct then a toast will be displayed saying "correct" and if not the correct answer will be displayed via toast




    //these were made outside th other methods because they will be utilized in more then method
    ImageView imageView;
    Button button;
    Button button1;
    Button button2;
    Button button3;

    //celebURLS will house the urls of the images
    ArrayList<String> celebURLS = new ArrayList<String>();

    //celebNames will house the names of the celebs that pertain to the image urls
    ArrayList<String> celebNames = new ArrayList<String>();

    //chosenCelebs= a randomized index of the celebNames from the celebNames arrayList
    int chosenCelebs =0;

    //answers = array that houses 4 randomized celebNames(strings) from the celebNames arrayList
    String[] answers = new String[4];

    //locationOfCorrectAnswer= the index of the correct answer in the answers arrayList
    int locationOfCorrectAnswer;


    //onClick method for checking to see if the choice from the user matches the correct celebname and
    //restarts the game after toast displays if the user was correct or not
    public void celebChosen (View view){

        //this if statement compares the location of the correct answer to the tag of the button and if they equal
        //basically this if statement checks to see if the user choose the right answer on one of the corresponding button
        //if the user is correct then a toast will be displayed saying "correct" and if not the correct answer will be displayed via toast
        //then after the toast is displayed then a newQuestion will be displayed
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Wrong it was " + celebNames.get(chosenCelebs),Toast.LENGTH_SHORT).show();
        }
        newQuestion();
    }




    public class DownloadTask extends AsyncTask<String,Void,String>{

        protected String doInBackground (String... urls){
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in =urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data!= -1){
                    char current = (char) data;

                    /*
                     these lines find and match the url to the image and
                     its printed down below in the while loop
                    */

                    /*
                    String imageURL = Character.toString(current);
                    Pattern p = Pattern.compile("img src=\"(.*?)\"");
                    Matcher m = p.matcher(imageURL);

                    while (m.find()){
                        ImageDownloader task = new ImageDownloader();
                        Bitmap myImage;

                        try {
                            myImage=task.execute(m.group(1)).get();
                            imageView.setImageBitmap(myImage);
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }




                        Log.i("URL",m.group(1));

                    }
                    //////////////////////////////////////////////////////
                    /*
                    these lines find and match the name that pertains to
                    the image and its printed down below in the while loop
                    */

                    /*
                    p = Pattern.compile("alt=\"(.*?)\"");
                    m = p.matcher(imageURL);

                    while (m.find()) {
                        button.setText(m.group(1));

                        Log.i("Celeb name",m.group(1));
                    }
                    //////////////////////////////////////////////////////
                    */
                    result+= current;
                    data=reader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "Failed";
            }

        }
    }

    public class ImageDownloader extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {

                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in = connection.getInputStream();
                Bitmap celebBitmap = BitmapFactory.decodeStream(in);

                return celebBitmap;


            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }


        }
    }

    //this method will be used to restart the game after a question was answered
    public void newQuestion(){
            //these lines: creates a random number that randomizes one of the positions in the
            //celebURLS arraylist the pertain to the urls for a image and sends it to the Imagedownloader method
            //and sets the imageView to that random image

        try{
            Random rand = new Random();
            chosenCelebs = rand.nextInt(celebURLS.size());

            ImageDownloader imageTask = new ImageDownloader();
            Bitmap celebImage = imageTask.execute(celebURLS.get(chosenCelebs)).get();
            imageView.setImageBitmap(celebImage);

            locationOfCorrectAnswer = rand.nextInt(4);


            //will be used to determine the location of the correct answer (ie which button the correct answer will be on)
            int incorrectLocationOfAnswer;

            //this for loop will be used to put the correct answer and wrong answers to the celeb names into the celebNames arraylist above
            for (int i=0; i<4;i++){
                //if the L.O.C.A == i then the one of the answers in the answers array,
                //then one of the names from celebNames arrayList will be placed in one the indexes of the answers array
                if (i == locationOfCorrectAnswer){
                    answers[i] = celebNames.get(chosenCelebs);
                }
                //else a random wrong answer index will be placed in incorrectLocationOfAnswer based on the size of the celebURLS arrayList
                else{
                    incorrectLocationOfAnswer= rand.nextInt(celebURLS.size());

                    //but in the off chance the incorrectLocationOfAnswer == the index of the chosenCelebs then it will be changed so they wont equal
                    //then the random incorrectLocationOfAnswer will be placed in the other positions of the answers arraylist
                    while(incorrectLocationOfAnswer == chosenCelebs){
                        incorrectLocationOfAnswer =rand.nextInt(celebURLS.size());
                    }
                    answers[i] = celebNames.get(incorrectLocationOfAnswer);
                }
            }

            //the button that the answers will be displayed on from the answers arraylist
            button.setText(answers[0]);
            button.setText(answers[1]);
            button.setText(answers[2]);
            button.setText(answers[3]);

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    //onCreate the website "http://www.posh24.se/kandisar" will be accessed ans then using the matcher and pattern methods it will
    //find the image urls and names that correspond to them and those will be used for the newQuestion() method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        imageView = findViewById(R.id.imageView);

        DownloadTask task = new DownloadTask();
        String result = null;

        button = findViewById(R.id.button);

        try{
            result = task.execute("http://www.posh24.se/kandisar").get();

            String [] splitResult = result.split( "<div class=\"listedArticles\">");

            /*
            these lines find and match the url to the image and
            its printed down below in the while loop
            */


            Pattern p = Pattern.compile("img src=\"(.*?)\"");
            Matcher m = p.matcher(splitResult[0]);

            while (m.find()) {
                //System.out.println(m.group(1));

                celebURLS.add(m.group(1));

                //Log.i("Celeb name",m.group(1));
            }

            /*
            these lines find and match the name that pertains to
            the image and its printed down below in the while loop
                    */
            p = Pattern.compile("alt=\"(.*?)\"");
            m = p.matcher(splitResult[0]);

            while (m.find()) {
                //System.out.println(m.group(1));

                celebNames.add(m.group(1));

               // Log.i("Celeb name",m.group(1));
            }

            newQuestion();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
