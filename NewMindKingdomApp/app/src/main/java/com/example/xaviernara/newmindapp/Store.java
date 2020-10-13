package com.example.xaviernara.newmindapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class Store extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Watch "RecyclerView - Android Studio Tutorial | Part 1" on YouTube
    //https://youtu.be/18VcnYN5_LM


    RecyclerView recyclerView;

    String itemsForSale[], descriptions[];
    int[] images =  {R.mipmap.youtube_icon,R.mipmap.youtube_icon,R.mipmap.youtube_icon,R.mipmap.youtube_icon,
            R.mipmap.youtube_icon,R.mipmap.youtube_icon,R.mipmap.youtube_icon,R.mipmap.youtube_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        recyclerView =findViewById(R.id.recyclerView);

        itemsForSale = getResources().getStringArray(R.array.itemsForSale);
        descriptions = getResources().getStringArray(R.array.descriptions);

        MyAdadpter myAdadpter = new MyAdadpter(this,itemsForSale,descriptions,images);
        recyclerView.setAdapter(myAdadpter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}