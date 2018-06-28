package com.example.xaviernara.addingnewactivties;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {


    //this app switches the activity when one of the names on the listView is pressed
    //and on the next activity a toast saying "hello" +name is displayed
    //if the button is pressed it will cycle back to the 1st activity


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityListView= findViewById(R.id.activityListView);

        final Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        //startActivity(intent);



        final ArrayList<String> friendsNames = new ArrayList<String>(asList("Ashely","Derek", "Karen","Xavier","John","Bob","Kate"));

        //a ArrayAdapter communicates with a array/arraylist to get the contents of the array/arraylist and also how it will be displayed on the screen
        // the setAdapter places the contents in the array/arraylist  into the listview variable so it can be displayed (i.e.to list it on the screen)
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,friendsNames );
        activityListView.setAdapter(arrayAdapter);


        //remember to habe something happen when a list item is clicked then you need this line of code
        activityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //this lines of code will log the name of the family memeber thats listed on the screen when clicked
            //and create a toast when a list item is clicked
            //AdapterView<?> parent = a type of adapter in the <gridLayout,string, etc...>
            //View view= itmes being viewed on screen
            //int position = position of the items on the list (for example: positions of the items in the array )


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Family Name: ",friendsNames.get(position));
                //Toast.makeText(this,names.get(position),Toast.LENGTH_LONG)
                //Toast.makeText(getApplicationContext(), "Hello "+names.get(position),Toast.LENGTH_LONG).show();

                intent.putExtra("names", friendsNames.get(position));
                startActivity(intent);

            }
        });

    }
}
