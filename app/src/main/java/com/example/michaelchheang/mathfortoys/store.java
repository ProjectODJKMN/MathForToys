package com.example.michaelchheang.mathfortoys;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class store extends AppCompatActivity{

    Button coupon1;
    Button coupon2;
    Button coupon3;
    Button yes;
    Button no;
    TextView money;
    final Context context = this;
    menuScreen menu = new menuScreen();
    private Dialog myDialog;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        coupon1 = (Button) findViewById(R.id.coupon1);
        coupon2 = (Button) findViewById(R.id.coupon2);
        coupon3 = (Button) findViewById(R.id.coupon3);
        money = (TextView) findViewById(R.id.currency);

        money.setText("S Coins: " + String.valueOf(menu.getCurrency()));

        coupon1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                handleClick(10);
            }
        });
        coupon2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                handleClick(20);
            }
        });
        coupon3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                handleClick(30);
            }
        });
    }
    public void handleClick(int n){
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.confirmation);
        yes = (Button) myDialog.findViewById(R.id.yes);
        no = (Button) myDialog.findViewById(R.id.no);
        final int y = n;
        if(menu.getCurrency() >= n) {
            yes.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    menu.update(-y);
                    Toast.makeText(store.this, "Congratulations ", Toast.LENGTH_SHORT).show();
                    myDialog.dismiss();
                }
            });
            no.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    myDialog.dismiss();
                }
            });
            myDialog.show();                }
        else{
            Toast.makeText(store.this, "Not enough coins", Toast.LENGTH_SHORT).show();
        }
    }
}
