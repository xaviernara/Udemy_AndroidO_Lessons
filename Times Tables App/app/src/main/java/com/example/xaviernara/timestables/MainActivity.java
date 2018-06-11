package com.example.xaviernara.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    //this program is a times tables app
    //basically which means when the seekbar is moved then the listview will chsnge to a timesTable
    //correspoding to the progress of the seekbar
    //Ex:if seekBar value = 3, listview time table = 3

    ListView timesTableListView;

    public void generateTimesTable(int timesTableNumber){
        //this method accepts the number that will be used to detemine which number's times table on the screen
        //the for loop will do all the mulitiplication that will be displayed on the listView
        ArrayList<String> timesTablesContent = new ArrayList<String>();
        for (int i=0; i<=100;i++){
            timesTablesContent.add(Integer.toString(timesTableNumber*(i)));
        }

        timesTableListView = (ListView) findViewById(R.id.timesTableListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,timesTablesContent);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);

        int max=20;
        int startingPosition=10;


        //SeekBarvariable.setMax()/.setMin sets the max and min number of the seekBar
        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(startingPosition);
        generateTimesTable(startingPosition);


        //remember after you create the seekBar variable then you have to do
        //SeekBarvariable.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //public void onProgressChanged() is a method that is called when the seekbar is moved (ie progress changed)
            //int progress = where the seekbar is/will moved (i.e where it falls between the min and max)
            //boolean fromUser = if the user move3d the seekbar or not
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int minimum =0;
                int timesTableNumber;

                if ( progress < minimum ){
                    timesTableNumber = minimum;
                    timesTableSeekBar.setProgress(minimum);
                }
                else{
                    timesTableNumber= progress;
                }
                Log.i("SeekBar values", Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);

            }
            //this method is called when the seekbar starts moving
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            //this method is called when the seekbar stops moving
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
