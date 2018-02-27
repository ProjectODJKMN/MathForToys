package com.example.michaelchheang.mathfortoys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectGrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_grade);
        init();
    }

    public void init(){
        Button kindergardenButton = (Button) findViewById(R.id.kindergardenButton);
        kindergardenButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(selectGrade.this, gameplay.class));
            }
        });
    }
}
