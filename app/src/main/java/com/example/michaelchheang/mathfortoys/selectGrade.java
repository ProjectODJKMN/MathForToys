package com.example.michaelchheang.mathfortoys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectGrade extends AppCompatActivity {
    private gameplay game = new gameplay();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_grade);
        init();
    }

    public void init(){
        Button easyButton = (Button) findViewById(R.id.easyButton);
        easyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                game.setLevel(1);
                game.setLimit(10);
                startActivity(new Intent(selectGrade.this, gameplay.class));
            }
        });

        Button normalButton = (Button) findViewById(R.id.normalButton);
        normalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                game.setLevel(2);
                game.setLimit(15);
                startActivity(new Intent(selectGrade.this, gameplay.class));
            }
        });
        Button hardButton = (Button) findViewById(R.id.hardButton);
        hardButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                game.setLevel(3);
                game.setLimit(20);
                startActivity(new Intent(selectGrade.this, gameplay.class));
            }
        });

    }
}
