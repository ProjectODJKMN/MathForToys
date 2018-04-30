package com.example.michaelchheang.mathfortoys;
import static com.example.michaelchheang.mathfortoys.R.layout.videochoice;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button quitToMenu;
    private ArrayList<Button> buttons = new ArrayList<>();
    private String mAnswer;
    private int mScore = 0;
    private static int level;
    final Context context = this;
    private videoPlayer player;
    private int count;
    private int limit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        mScoreView = (TextView) findViewById(R.id.scoreText);
        mQuestionView = (TextView) findViewById(R.id.problemText);
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
        count = 0;

        updateQuestion();

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
            public void onClick(View view) {
                checkAnswer(mButtonChoice4);
            }
        });
        quitToMenu.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity (new Intent(gameplay.this, menuScreen.class));
            }
        });

        helpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        player.setVideo(0);
                        startActivity(new Intent(gameplay.this, videoPlayer.class));
                    }
                });
                sub.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        player.setVideo(1);
                        startActivity(new Intent(gameplay.this, videoPlayer.class));
                    }
                });
                mult.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        player.setVideo(2);
                        startActivity(new Intent(gameplay.this, videoPlayer.class));
                    }
                });
                div.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
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
            mScore += (Math.pow(level + 1, 2));
            updateScore(mScore);
            Toast.makeText(gameplay.this, "correct", Toast.LENGTH_SHORT).show();
            if(++count == 10){
                startActivity(new Intent(gameplay.this, menuScreen.class));
            }
            updateQuestion();
        } else {
            Toast.makeText(gameplay.this, "wrong", Toast.LENGTH_SHORT).show();
        }
    }
}

