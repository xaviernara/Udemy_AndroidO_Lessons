package com.example.xaviernara.newmindapp;

import android.content.Intent;
import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class ListNotUsedActivity extends AppCompatActivity {


    ListView activityListView;

    /*
    //onClick method for previous button that would switch the screen to the next activity
    public void nextActivity(View view){

        //Intent is for what you WANT to do when you move to the another activity
        //Intent intent = new Intent(application Context, class you want to move to);
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

        //this moves the screen to the activity that the intent above says to
        //this basically stacks the activities on top of each other
        //(ie when the back button on the users device the screen will cycle back and forth thru the activities screens)
        //**THIS IS MANDATORY WHEN YOUR MOVING TO THE NEXT ACTIVITY IF ITS USED IN THE FIRST ACTIVITY
        startActivity(intent);

        //this passes things to the class that activity that the intent tells it to
        //intent.putExtra("name of the variable",value of the variable);
        //Ex:  intent.putExtra("age",78); your sending a int to the another activity
        intent.putExtra("age",29);
    }
    */














    /*







     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_not_used);

        activityListView = findViewById(R.id.church_list);

        final Intent intent = new Intent(getApplicationContext(),PastorBiography.class);
        //Intent intent;
        //startActivity(intent);



        final ListView list = findViewById(R.id.church_list);
        final ArrayList<String> churchList = new ArrayList<>();
        churchList.add("Meet Prophet Frederick E. Ward Sr.");
        churchList.add("Previous Messages");
        churchList.add("Social Media");
        churchList.add("Sign Up");
        churchList.add("AboutUs");
        churchList.add("Church Location");
        churchList.add("Ways to Give");
        churchList.add("Our Crest");
        churchList.add("Church Location");
        churchList.add("Vision Statement ");
        churchList.add("Mission Statement");
        churchList.add("Our 7Rs Concept (Our Mandate)");
        churchList.add("Pathway to Purpose");
        churchList.add("What We Believe");
        churchList.add("Our Culture (I.C.C.E)");


        //a ArrayAdapter communicates with a array/arraylist to get the contents of the array/arraylist and also how it will be displayed on the screen
        // the setAdapter places the contents in the array/arraylist  into the listview variable so it can be displayed (i.e.to list it on the screen)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, churchList);


        activityListView.setAdapter(arrayAdapter);


        //remember to have something happen when a list item is clicked then you need this line of code
        activityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //this lines of code will log the name of the family memeber thats listed on the screen when clicked
            //and create a toast when a list item is clicked
            //AdapterView<?> parent = a type of adapter in the <gridLayout,string, etc...>
            //View view= itmes being viewed on screen
            //int position = position of the items on the list (for example: positions of the items in the array )


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch(position){

                    case 0 :
                        Intent intent = new Intent(getApplicationContext(),PastorBiography.class);
                        startActivity(intent);
                        break;

                    case 1 :
                        intent = new Intent(getApplicationContext(), PreviousMessages.class);
                        startActivity(intent);
                        break;

                    case 2 :
                        intent = new Intent(getApplicationContext(), SocialMedia.class);
                        startActivity(intent);
                        break;

                    case 3 :
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/17AShdI3lj8vwOfxkhBoLcv_YRCqf4KOTY03Wq2guQCE/viewform?edit_requested=true"));
                        startActivity(intent);
                        break;

                    case 4 :
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newmindkingdom.org"));
                        startActivity(intent);
                        break;

                    case 6 :
                        intent = new Intent(getApplicationContext(), GivingWays.class);
                        startActivity(intent);
                        break;
                    case 7 :
                        intent = new Intent(getApplicationContext(), CrestInfo.class);
                        startActivity(intent);
                        break;

                    case 9 :
                        intent = new Intent(getApplicationContext(), VisionStatement.class);
                        startActivity(intent);
                        break;

                    case 11 :
                        intent = new Intent(getApplicationContext(), SevenRConcept.class);
                        startActivity(intent);
                        break;


                }


                /*
                if(position == 0 ){
                    //intent = new Intent(getApplicationContext(),PastorBiography.class);
                    startActivity(intent);
                }
                */

                Log.i("Family Name: ",churchList.get(position));
                //Toast.makeText(this,names.get(position),Toast.LENGTH_LONG)
                //Toast.makeText(getApplicationContext(), "Hello "+names.get(position),Toast.LENGTH_LONG).show();

                //intent.putExtra("churchList", churchList.get(position));
                //startActivity(intent);








            }
        });






        /*
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list.getItemAtPosition(position);
                Toast.makeText(ListNotUsedActivity.this,clickedItem,Toast.LENGTH_LONG).show();
            }
        });*/





    }
}
