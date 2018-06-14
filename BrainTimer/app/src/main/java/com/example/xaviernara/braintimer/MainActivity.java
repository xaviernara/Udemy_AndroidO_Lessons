package com.example.xaviernara.braintimer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    TextView sumTextView;

    //this arraylist holds the multiple choice answers to the math problem
    ArrayList<Integer> answers = new ArrayList<Integer>();

    int locationOfCorrectAnswer;

    //score=correct answer choices
    //numberOfQuestions= # of questions asked (i.e questions that appear on the app)
    int score=0;
    int numberOfQuestions=0;

    TextView resultTextView;
    TextView scoreTextView;
    TextView timerTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgainButton;

    //ConstraintLayout that houses the bottons and textviews for the game
    ConstraintLayout gameLayout;


    //restarting the game once it ends and the user clicks the play again button or when the game begins
    public void playAgain(View view){
        score=0;
        numberOfQuestions=0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQuestion();
        resultTextView.setText(" ");
        playAgainButton.setVisibility(View.INVISIBLE);

        new CountDownTimer(30100,1000){
            @Override
            public void onTick (long l){
                timerTextView.setText(toString().valueOf(l / 1000)+"s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Game Finished");
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    //this method
    public void selectAnswer (View view){

        //Log.i("Tag:",view.getTag().toString());
        //this if statement compares the location of the correct answer to the tag of the button and if they equal
        //basically this if statement checks to see if the user choose the right answer on one of the corresponding button
        //then the textviews will be changed accordingly and the score of the incremented based on right answers
        if(Integer.toString( locationOfCorrectAnswer).equals(view.getTag().toString())){
            //Log.i("CORRECT!","You got it!");
            resultTextView.setText("Correct");
            score++;
        }
        else{
            //Log.i("INCORRECT!","wrong!");
            resultTextView.setText("Wrong");
        }

        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQuestion();
    }


    //WHEN THE go button is clicked it will turn invisible and the game will start
    //also the layout that houses the game will be made visible
    public void start (View view){

        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);

        //when the start button is clicked then the game will begin (ie questions will appear)
        playAgain(findViewById(R.id.goButton));
    }



    public void newQuestion(){
        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        sumTextView = (TextView)findViewById(R.id.sumTextView);

        //creates the text on the textview for the sum problem
        sumTextView.setText(Integer.toString(a)+ " + " +Integer.toString(b));


        //will be used to determine the location of the correct answer (ie which button the correct answer will be on)
        locationOfCorrectAnswer = random.nextInt(4);

        answers.clear();


        //this for loop will be used to put the correct answer and wrong answers to the math problem into the arraylist above
        for(int i = 0;i<4;i++ ){
            //if the L.O.C.A == i then (a+b) will be placed in the location of the correct answer in the arraylist
            if(i == locationOfCorrectAnswer){
                answers.add(a+b);
            }

            //else random wrongAnswers will be placed in the other positions of the arraylist
            else{
                int wrongAnswer= random.nextInt(41);

                //but in the off chance the if the wrongAnswer == the (a+b) then it will be changed so they wont equal
                //then the random wrongAnswers will be placed in the other positions of the arraylist
                while(wrongAnswer == a+b){
                    wrongAnswer= random.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }

        //the button that the answers will be displayed on from the answers arraylist
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = (Button) findViewById(R.id.goButton);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        timerTextView=(TextView) findViewById(R.id.timerTextView);
        playAgainButton=(Button) findViewById(R.id.playAgainButton);
        gameLayout=(ConstraintLayout) findViewById(R.id.gameLayout);


        //when the game starts then a new question will be generated
        newQuestion();

        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);

    }

}
