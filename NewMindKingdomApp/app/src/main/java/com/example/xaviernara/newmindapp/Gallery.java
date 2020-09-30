package com.example.xaviernara.newmindapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gallery extends AppCompatActivity {

    List<Integer> galleryImages = new ArrayList<>(Arrays.asList(
            R.mipmap.coming_soon,R.mipmap.coming_soon,R.mipmap.coming_soon, R.mipmap.coming_soon,
            R.mipmap.coming_soon,R.mipmap.coming_soon));





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }
}