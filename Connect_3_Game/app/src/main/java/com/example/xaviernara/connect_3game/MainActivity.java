package com.example.xaviernara.connect_3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //activePlayer=0=red, activePlayer=1=black
    //2=empty array

    int[] gameState = {2,2,2,2,2,2,2,2,2};

    //this 2d array represents the winning positions on the board both horizontally,vertically and diagonally
    int [][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer=0;
    boolean gameActive=true;

    public void dropIn(View view){
        //these lines of code creates a Imageview variable and move the red and black images(pieces) above the screen
        //also gets the tag name from each image and displays it to the log screens
        ImageView counter = (ImageView) view;

        Log.i("Tag Number",counter.getTag().toString());
        ////////////////////////////////////////////////////////////////////////
        //this line of code converts the tag name (string) into a integer
        int tappedCounter= Integer.parseInt(counter.getTag().toString());
        //this line of code puts the tag numbers into the gameState array and sets that equal to activePlayer



        //this if else statement will change the image to the black or red marker on eeach click on the board
        //(ie once the user clicks a open space on the board the image will drop and rotate from the top and land on that specific spot on the board
        //it does this by constantly updating the activePlayer to 1 or 0 (0=red,1=black)
        if(gameState[tappedCounter]==2 && gameActive){

            gameState[tappedCounter]=activePlayer;

            counter.setTranslationY(-1500);

            if(activePlayer==0){
                counter.setImageResource(R.drawable.red);
                activePlayer=1;
            }
            else{
                counter.setImageResource(R.drawable.black);
                activePlayer=0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            /////////////////////////////////////////////////////////////////////////
            //this for each where a 1d winningPosition array iterates thru the 2d winningPositions array  to check to see the users clicks correlate
            //to the winning positions and if they match then a message of who won will display as a toast
            //(ie if the tags thats called match the tag numbers in the 2d array, then the user won)
            for(int[] winningPosition: winningPositions){
                //this if statement 1st condition checks to see if the 1st position of the gameState array match the 2nd position of the array
                //and the rest check for different array positions and see if they match the other positions as well
                //the last condition checks to see if the 1st position of the array does not match 2 (2= blank space))

                //basicallyt this tests to see if a blank space on the board
                if(gameState[winningPosition[0]]== gameState[winningPosition[1]] && gameState[winningPosition[1]]== gameState[winningPosition[2]] &&gameState[winningPosition[0]]!= 2){
                    //someone won

                    String winner =" ";

                    if(activePlayer==0){
                        winner = "black";
                    }
                    else{
                        winner = "red";
                    }
                    //Toast.makeText(this,winner+" has won",Toast.LENGTH_LONG).show();

                    Button playAgainButton =(Button) findViewById(R.id.playAgainButton);

                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                    winnerTextView.setText(winner + " has won");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);


                }
            }
        }

    }

    public void playAgain(View view){
        Button playAgainButton =(Button) findViewById(R.id.playAgainButton);

        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

        playAgainButton.setVisibility(View.VISIBLE);

        winnerTextView.setVisibility(View.VISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0; i< gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView)gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for (int i =0; i<gameState.length;i++){

            gameState[i] = 2;
        }


        int activePlayer=0;
        boolean gameActive=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
