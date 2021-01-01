package com.example.hotanddoll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Sides extends AppCompatActivity {

    int sideCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides);
    }

    public void addSide(View view){

        switch (view.getId()){

            case R.id.addBEP:
                sideCount++;
                Toast.makeText(Sides.this,"Black Eyed Peas added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addColeSlaw:
                sideCount++;
                Toast.makeText(Sides.this,"Cole Slaw added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addCorn:
                sideCount++;
                Toast.makeText(Sides.this,"Corn added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addDressing:
                sideCount++;
                Toast.makeText(Sides.this,"Dressing added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addGBeans:
                sideCount++;
                Toast.makeText(Sides.this,"Green Beans added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addGreens:
                sideCount++;
                Toast.makeText(Sides.this,"Greens added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addMac:
                sideCount++;
                Toast.makeText(Sides.this,"Macaroni and Cheese added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addMashed:
                sideCount++;
                Toast.makeText(Sides.this,"Mashed Potatoes added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addPotatoSalad:
                sideCount++;
                Toast.makeText(Sides.this,"Potato Salad added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addRedBeans:
                sideCount++;
                Toast.makeText(Sides.this,"Red Beans and Rice added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addSpaghetti:
                sideCount++;
                Toast.makeText(Sides.this,"Spaghetti added",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.addSweets:
                sideCount++;
                Toast.makeText(Sides.this,"Sweet Potatoes added",Toast.LENGTH_SHORT ).show();
                break;
        }


    }



    private boolean addExtraSide(){

        return true;
    }

}