package com.example.michaelchheang.mathfortoys;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuScreen extends AppCompatActivity {
    private MediaPlayer bEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        bEffect = MediaPlayer.create(this,R.raw.button_click);

        init();
    }

    public void init(){
        Button playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bEffect.start();
                startActivity(new Intent(menuScreen.this, selectGrade.class));
            }
        });
        Button setting = (Button) findViewById(R.id.settingsButton);
        setting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bEffect.start();
                startActivity(new Intent(menuScreen.this, settingsPage.class));
            }
        });

    }
}
