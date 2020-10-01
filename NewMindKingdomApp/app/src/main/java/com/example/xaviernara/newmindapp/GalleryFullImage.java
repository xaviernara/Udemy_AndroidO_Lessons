package com.example.xaviernara.newmindapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;

public class GalleryFullImage extends AppCompatActivity {

    ImageView fullImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_full_image);

        fullImage = findViewById(R.id.galleryImage);
        int imageId = getIntent().getExtras().getInt("imageId");

        fullImage.setImageResource(imageId);
    }
}