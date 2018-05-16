package com.example.michaelchheang.mathfortoys;
import static com.example.michaelchheang.mathfortoys.R.layout.videochoice;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import android.view.View.OnClickListener;
import java.lang.Math;


public class gameplay extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private Button close;
    private Button add;
    private Button sub;
    private Button mult;
    private Button div;
    private Button helpButton;
    private TextView mScoreView;
    private TextView mQuestionView;
    private TextView timer;
    private TextView round;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button quitToMenu;
    private ArrayList<Button> buttons = new ArrayList<>();
    private String mAnswer;
    private static int mScore = 0;
    private static int level;
    final Context context = this;
    private videoPlayer player;
    private static int limit;
    private int roundCount;
    private CountDownTimer ct;
    private boolean timerSwitch;
    private MediaPlayer bEffects;
    private MediaPlayer correct;
    private MediaPlayer incorrect;
    private menuScreen menu = new menuScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        mScoreView = (TextView) findViewById(R.id.scoreText);
        mQuestionView = (TextView) findViewById(R.id.problemText);
        timer = (TextView) findViewById(R.id.timer);
        round = (TextView) findViewById(R.id.difficultyText);
        mButtonChoice1 = (Button) findViewById(R.id.choice1_button);
        mButtonChoice2 = (Button) findViewById(R.id.choice2_button);
        mButtonChoice3 = (Button) findViewById(R.id.choice3_button);
        mButtonChoice4 = (Button) findViewById(R.id.choice4_button);
        quitToMenu = (Button) findViewById(R.id.quitButton);
        helpButton = (Button) findViewById(R.id.help);
        buttons.add(mButtonChoice1);
        buttons.add(mButtonChoice2);
        buttons.add(mButtonChoice3);
        buttons.add(mButtonChoice4);
        player = new videoPlayer();
        roundCount = 0;
        bEffects = MediaPlayer.create(this, R.raw.button_click);
        correct = MediaPlayer.create(this, R.raw.correct);
        incorrect = MediaPlayer.create(this, R.raw.incorrect);

        updateQuestion();

        timerSwitch = settingsPage.isOn;

        if(timerSwitch == true) {
            refreshTimer();
        }
        else {
            timer.setText("Math For Kids");
        }

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(mButtonChoice1);
            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(mButtonChoice2);
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(mButtonChoice3);
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                checkAnswer(mButtonChoice4);
            }
        });
        quitToMenu.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                if(timerSwitch == true) {
                    ct.cancel();
                }
                bEffects.start();
                startActivity (new Intent(gameplay.this, menuScreen.class));
            }
        });

        helpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                bEffects.start();
                final Dialog myDialog = new Dialog(context);
                myDialog.setContentView(R.layout.videochoice);

                close = (Button) myDialog.findViewById(R.id.close);
                add = (Button) myDialog.findViewById(R.id.addition);
                sub = (Button) myDialog.findViewById(R.id.subtraction);
                mult = (Button) myDialog.findViewById(R.id.multiplication);
                div = (Button) myDialog.findViewById(R.id.division);

                add.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        bEffects.start();
                        player.setVideo(0);
                        startActivity(new Intent(gameplay.this, videoPlayer.class));
                    }
                });
                sub.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        bEffects.start();
                        player.setVideo(1);
                        startActivity(new Intent(gameplay.this, videoPlayer.class));
                    }
                });
                mult.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        bEffects.start();
                        player.setVideo(2);
                        startActivity(new Intent(gameplay.this, videoPlayer.class));
                    }
                });
                div.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        bEffects.start();
                        player.setVideo(3);
                        startActivity(new Intent(gameplay.this, videoPlayer.class));
                    }
                });

                close.setOnClickListener(new OnClickListener(){
                    @Override
                    public void onClick(View v){
                        myDialog.dismiss();
                    }
                });
                myDialog.show();
            }
        });

    }

    private void updateQuestion(){
        if (roundCount == limit) {
            round.setText("Round:" + limit + "/" + limit);
        }
        else {
            round.setText("Round:" + (roundCount + 1) + "/" + limit);
        }
        mQuestionView.setText(mQuestionLibrary.getQuestion(level));
        Collections.shuffle(buttons);
        mAnswer = String.valueOf(mQuestionLibrary.getAnswer());
        buttons.get(0).setText(mAnswer);
        for (int i = 1; i < buttons.size(); i++){
            buttons.get(i).setText(String.valueOf(mQuestionLibrary.getChoice(i)));
        }
    }
    public void setLevel(int n){
        level = n;
    }
    public void setLimit(int n){
        limit = n;

    }

    private void updateScore(int mScore) {
        mScoreView.setText("Score: " + mScore);
    }

    private void checkAnswer(Button x){
        if (x.getText() == mAnswer) {
            correct.start();
            mScore += (Math.pow(level + 1, 2));
            updateScore(mScore);
            Toast.makeText(gameplay.this, "correct", Toast.LENGTH_SHORT).show();
            if(++roundCount == limit) {
                menu.update(mScore * level);
                startActivity(new Intent(gameplay.this, winScreen.class));
            }
            updateQuestion();

            if(timerSwitch == true) {
                ct.cancel();
                refreshTimer();
            }
            else {
                timer.setText("Math For Kids");
            }

        } else {
            mScore -= (Math.pow(level + 1, 2)) - 1;
            if (mScore < 0){
                mScore = 0;
            }
            updateScore(mScore);
            incorrect.start();
            Toast.makeText(gameplay.this, "wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private void refreshTimer() {
        if (level == 0) {
            ct = new CountDownTimer(9000, 1000) {
                @Override
                public void onTick(long l) {
                    timer.setText("Time Remaining: " + l / 1000 + " seconds");
                }

                @Override
                public void onFinish() {
                    startActivity(new Intent(gameplay.this, lossScreen.class));
                }
            }.start();
        }
        else if (level == 1)
        {
            ct = new CountDownTimer(11000, 1000) {
                @Override
                public void onTick(long l) {
                    timer.setText("Time Remaining: " + l / 1000 + " seconds");
                }

                @Override
                public void onFinish() {
                    startActivity(new Intent(gameplay.this, lossScreen.class));
                }
            }.start();
        }
        else {
            ct = new CountDownTimer(13000, 1000) {
                @Override
                public void onTick(long l) {
                    timer.setText("Time Remaining: " + l / 1000 + " seconds");
                }

                @Override
                public void onFinish() {
                    startActivity(new Intent(gameplay.this, lossScreen.class));
                }
            }.start();
        }
    }
}

