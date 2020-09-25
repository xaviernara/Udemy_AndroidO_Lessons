package com.example.xaviernara.newmindapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PreviousMessages extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_messages);

        //How to implement listview
        //https://www.tutorialspoint.com/android/android_list_view.htm
        String[] messages = new String[] {"Transparency","Beauty For Ashes","Baggages"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_previous_messages,messages);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }
}
