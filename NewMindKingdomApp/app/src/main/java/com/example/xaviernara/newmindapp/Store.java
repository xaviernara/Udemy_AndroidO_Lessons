package com.example.xaviernara.newmindapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Store extends AppCompatActivity {

    RecyclerView recyclerView;

    String itemsForSale[], descriptions[];
    int[] images =  {R.drawable.pathway,R.drawable.pathway,R.drawable.pathway,R.drawable.pathway,R.drawable.pathway};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        recyclerView =findViewById(R.id.recyclerView);

        itemsForSale = getResources().getStringArray(R.array.itemsForSale);
        descriptions = getResources().getStringArray(R.array.descriptions);

        MyAdapter myAdapter = new MyAdapter(this,itemsForSale,descriptions,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}