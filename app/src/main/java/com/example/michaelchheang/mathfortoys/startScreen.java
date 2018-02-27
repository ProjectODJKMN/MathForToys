package com.example.michaelchheang.mathfortoys;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class startScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        init();
    }

    public void init(){
        ConstraintLayout clayout = (ConstraintLayout) findViewById(R.id.mainLayout);
        clayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(startScreen.this, menuScreen.class));
            }
        });
    }
}
