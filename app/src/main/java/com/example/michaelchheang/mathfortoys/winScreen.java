package com.example.michaelchheang.mathfortoys;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class winScreen extends AppCompatActivity {
    private Button contButton;
    private MediaPlayer bEffects;
    private TextView message;
    private menuScreen menu = new menuScreen();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);

        contButton = findViewById(R.id.winToMenu);
        message = findViewById(R.id.roundFinished);
        bEffects = MediaPlayer.create(this, R.raw.button_click);
        message.setText("You have won " + String.valueOf(menu.getCoinsWon()) + " coins!");

        contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bEffects.start();
                startActivity(new Intent(winScreen.this, menuScreen.class));
            }
        });
    }
}
