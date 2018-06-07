package com.example.xaviernara.listviewdemo;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView myListView = (ListView)findViewById(R.id.myListView);

        //final String [] familyNames = {"Ashely","Derek", "Karen","Xavier"};
        /*
        final ArrayList<String> familyNames = new ArrayList<String>();
        familyNames.add("Ashley");
        familyNames.add("Derek");
        familyNames.add("Karen");
        familyNames.add("Xavier");
        */

        //or
        //this will get around having to .add something to a arraylist
        final ArrayList<String> familyNames = new ArrayList<String>(asList("Ashely","Derek", "Karen","Xavier"));


        //a ArrayAdapter communicates with a array/arraylist to get the contents of the array/arraylist and also how it will be displayed on the screen
        // the setAdapter places the contents in the array/arraylist  into the listview variable so it can be displayed (i.e.to list it on the screen)

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,familyNames );
        myListView.setAdapter(arrayAdapter);


        //remember to habe something happen when a list item is clicked then you need this line of code
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            
            //this lines of code will log the name of the family memeber thats listed on the screen when clicked
            //and create a toast when a list item is clicked
            //AdapterView<?> parent = a type of adapter in the <gridLayout,string, etc...>
            //View view= itmes being viewed on screen
            //int position = position of the items on the list (for example: positions of the items in the array )


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Family Name: ",familyNames.get(position));
                //Toast.makeText(this,familyNames.get(position),Toast.LENGTH_LONG)
                Toast.makeText(getApplicationContext(), "Hello "+familyNames.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }
}
