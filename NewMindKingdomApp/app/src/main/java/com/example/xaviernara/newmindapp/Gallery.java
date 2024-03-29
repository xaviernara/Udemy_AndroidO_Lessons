package com.example.xaviernara.newmindapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gallery extends AppCompatActivity {

    List<Integer> galleryImages = new ArrayList<>(Arrays.asList(
            R.mipmap.coming_soon,R.mipmap.coming_soon,R.mipmap.coming_soon, R.mipmap.coming_soon,
            R.mipmap.coming_soon,R.mipmap.coming_soon));

    GridView gridView;
    Dialog dialog;
    TextView imageName;
    Button btnFull, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdaptor(galleryImages, this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = galleryImages.get(position);

                showDialogBox(itemPosition);
            }
        });

    }

    public void showDialogBox(final int itemPosition) {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);

        //getting custom dialog views
        TextView imageName = dialog.findViewById(R.id.imageName);
        ImageView galleryImage = dialog.findViewById(R.id.galleryImage);
        Button btnFull = dialog.findViewById(R.id.btn_full);
        Button btnClose = dialog.findViewById(R.id.btn_close);


        btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, GalleryFullImage.class);
                intent.putExtra("imageId",itemPosition);
                startActivity(intent);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //closes dialog box
                dialog.dismiss();
            }
        });

        String title = getResources().getResourceName(itemPosition);

        //extracting image names
        int index = title.indexOf("/");
        String name = title.substring(index + 1, title.length());
        imageName.setText(name);

        galleryImage.setImageResource(itemPosition);

        dialog.show();
    }

/*
    public void buttonFullOnClick(View view) {
        Intent intent = new Intent(Gallery.this, GalleryFullImageView.class);
        intent.putExtra("imageId",item);

    }
*/


/*
    public void buttonCloseOnClick(View view) {
        //closes dialog box
        dialog.dismiss();
    }
*/
    }
