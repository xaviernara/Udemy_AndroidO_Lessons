package com.example.xaviernara.newmindapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class GalleryFullImageView extends AppCompatActivity {

    ImageView fullImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_full_image_view);

        fullImage = findViewById(R.id.fullImage);
        int imageId = getIntent().getExtras().getInt("imageId");

        fullImage.setImageResource(imageId);
    }
}