package com.example.xaviernara.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //these were made outside th other methods because they will be utilized in more then method

    MediaPlayer mediaPlayer;

    TextView timerEditText;

    SeekBar eggTimerSeekBar;

    //boolean to tell when the timer is active or not
    Boolean counterIsActive=false;

    CountDownTimer countDownTimer;

    Button eggTimerButton;

    /*
    public void playMusic (View view){
        mediaPlayer.start();
    }
    public void pauseMusic (View view){
        mediaPlayer.pause();
    }
    */



    //the method resets the countdown timer when the timer ends
    //resets the textView back to 0:30
    //RESETS the seekbar progress to 30 and enables he seekbar to be moved again for the time
    //cancels the countDown timer (i.e resets it to zero)
    //also makes the boolean false (counter isn't active )
    //lets the user re-click the button to start the timer again
    public void resetTimer(){
        timerEditText.setText("0:30");
        eggTimerSeekBar.setProgress(30);
        eggTimerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        eggTimerButton.setText("START");
        counterIsActive = false;
    }

    //public void eggTimer(int minutes, int secounds){

    //this method creates the countdown for the app by using the progress of the seekbar in the countDownTimer
    //while the countdown is counting down the text will display the time left
    //when the timer ends music will play (ie onFinish())
    public void eggTimer(View view) {

        timerEditText= (TextView) findViewById(R.id.timerEditText);

        eggTimerButton = (Button) findViewById(R.id.eggTimerButton);


        //if the boolean is false then reset the times(ie resetTimer() )
        if (counterIsActive){
            resetTimer();
        }
        else{
            counterIsActive = true;
            eggTimerSeekBar.setEnabled(false);
            //eggTimerButton.setText("START");
            eggTimerButton.setText("STOP");



            countDownTimer = new CountDownTimer(eggTimerSeekBar.getProgress()*1000+100,1000){

                public void onTick(long millisecondsUntilDone){
                    //timerEditText.setText(Long.toString(millisecondsUntilDone/1000));
                    timerEditText.setText((int) millisecondsUntilDone/1000);
                    //eggTimerButton.setEnabled(false);
                    Log.i("Seconds Left",String.valueOf(millisecondsUntilDone/1000));

                }
                public void onFinish(){
                    Log.i("We're done","No more countdown");
                    //eggTimerButton.setText("START");
                    mediaPlayer.start();
                    //eggTimerButton.setEnabled(true);
                    resetTimer();
                }
            }.start();

        }


    }

    public void secondsLeft(int secondsLeft){
        int minutes = secondsLeft/60;
        int seconds =secondsLeft-(minutes*secondsLeft);

        String secondsString = Integer.toString(seconds);

        //if (secondsString.equals("0")){
        if (seconds >= 9){
            secondsString= "0"+ secondsString;
        }
        timerEditText.setText(Integer.toString(minutes)+":"+ secondsString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.ultra_instinct);
        //////////////////////////////////////////////////////////

        eggTimerSeekBar = (SeekBar) findViewById(R.id.eggTimerSeekBar);

        int maxTime=600;
        int currentTime=30;

        //eggTimerSeekBar.setMax(maxTime) = setting the max length the seekbar can go (i.e the max time the user can set (6 minutes))
        // eggTimerSeekBar.setProgress(currentTime); = the start of the progress bar (ie 30 seconds)
        eggTimerSeekBar.setMax(maxTime);
        //eggTimerSeekBar.setMin(minTime);
        eggTimerSeekBar.setProgress(currentTime);

        eggTimerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                secondsLeft(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}
