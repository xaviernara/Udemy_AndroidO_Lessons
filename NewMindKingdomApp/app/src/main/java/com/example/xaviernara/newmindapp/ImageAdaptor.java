package com.example.xaviernara.newmindapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdaptor extends BaseAdapter {


    //Watch "RecyclerView - Android Studio Tutorial | Part 1" on YouTube
    //https://youtu.be/18VcnYN5_LM

    private Context context;
    private List<Integer> thumbnailsId;


    public ImageAdaptor (List<Integer> thumbnailsId, Context context){

        this.thumbnailsId = thumbnailsId;
        this.context = context;
    }

    @Override
    public int getCount() {
        return thumbnailsId.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {

        return thumbnailsId.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = (ImageView) convertView;

        if(imageView==null){
           imageView = new ImageView(context);
           imageView.setLayoutParams(new GridView.LayoutParams(350,450));
           imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        imageView.setImageResource(thumbnailsId.get(position));

        return imageView;
    }
}
