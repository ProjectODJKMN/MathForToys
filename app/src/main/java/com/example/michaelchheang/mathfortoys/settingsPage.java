package com.example.michaelchheang.mathfortoys;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.content.SharedPreferences;

public class settingsPage extends AppCompatActivity {
    private Switch timer;
    public static boolean isOn;
    private Button about;
    private MediaPlayer bEffects;

    private void SavePreferences(){
        isOn = timer.isChecked();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("state", timer.isChecked());
        editor.commit();   // I missed to save the data to preference here,.
    }

    private void LoadPreferences(){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        timer.setChecked(sharedPreferences.getBoolean("state", false));
    }

    @Override
    public void onBackPressed() {
        SavePreferences();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        timer = (Switch) findViewById(R.id.timerSwitch);
        bEffects = MediaPlayer.create(this, R.raw.button_click);

        LoadPreferences();

        isOn = timer.isChecked();

        about = findViewById(R.id.developer_button);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bEffects.start();
                startActivity(new Intent(settingsPage.this, aboutScreen.class));
            }
        });
    }
}
