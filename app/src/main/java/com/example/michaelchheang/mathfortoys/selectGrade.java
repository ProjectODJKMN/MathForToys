package com.example.michaelchheang.mathfortoys;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class selectGrade extends AppCompatActivity {
    private gameplay game = new gameplay();
    private menuScreen menu = new menuScreen();
    private MediaPlayer bEffects;
    private TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_grade);
        bEffects = MediaPlayer.create(this, R.raw.button_click);
        money = (TextView) findViewById(R.id.currency);

        money.setText("S Coins: " + String.valueOf(menu.getCurrency()));
        init();
    }

    public void init(){
        Button easyButton = (Button) findViewById(R.id.easyButton);
        easyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                game.setLevel(1);
                game.setLimit(10);
                bEffects.start();

                startActivity(new Intent(selectGrade.this, gameplay.class));
            }
        });

        Button normalButton = (Button) findViewById(R.id.normalButton);
        normalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                game.setLevel(2);
                game.setLimit(15);
                bEffects.start();

                startActivity(new Intent(selectGrade.this, gameplay.class));
            }
        });
        Button hardButton = (Button) findViewById(R.id.hardButton);
        hardButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                game.setLevel(3);
                game.setLimit(20);
                bEffects.start();

                startActivity(new Intent(selectGrade.this, gameplay.class));
            }
        });

        Button menuButton = (Button) findViewById(R.id.levelToMenu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                bEffects.start();
                startActivity(new Intent(selectGrade.this, menuScreen.class));
            }
        });

    }
}
