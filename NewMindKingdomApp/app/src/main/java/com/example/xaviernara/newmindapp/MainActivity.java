package com.example.xaviernara.newmindapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Pastor Biography");
        arrayList.add("Previous Messages");
        arrayList.add("Sign Up");
        arrayList.add("Website");
        arrayList.add("Church Location");
        arrayList.add("Ways to give");
        arrayList.add("Crest Definition");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,                   android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,clickedItem,Toast.LENGTH_LONG).show();
            }
        });




    }
}
