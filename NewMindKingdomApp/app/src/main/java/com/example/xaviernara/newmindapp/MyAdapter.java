package com.example.xaviernara.newmindapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String[] data1, data2;
    int[] images;
    Context cxt;

    //Android | RecyclerView - GeeksforGeeks
    //https://www.geeksforgeeks.org/android-recyclerview/

    public MyAdapter(Context context, String[] itemsForSale, String[] descriptions, int[] imgs ) {
        cxt = context;
        data1= itemsForSale;
        data2=descriptions;
        images = imgs;

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(cxt);
        View view = layoutInflater.inflate(R.layout.recycler_rows,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1,myText2;
        ImageView myImage;
       ConstraintLayout constraintLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            constraintLayout = itemView.findViewById(R.id.crestInfoText);
            myText1 = itemView.findViewById(R.id.titleText);
            myText2 = itemView.findViewById(R.id.descriptionsText);
            myImage = itemView.findViewById(R.id.imageView);
        }
    }
}
