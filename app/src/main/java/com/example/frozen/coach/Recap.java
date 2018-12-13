package com.example.frozen.coach;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Recap extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recap);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView one =  findViewById(R.id.mauvaiseHab1);
        one.setOnClickListener(this); // calling onClick() method
        Button two =  findViewById(R.id.button3);
        two.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.mauvaiseHab1:
                Intent intent = new Intent(Recap.this, MauvaiseHabitude.class);
                startActivity(intent);
                break;

            case R.id.button3:
                Intent intent2 = new Intent(Recap.this, Choix.class);
                startActivity(intent2);
                break;

            default:
                break;
        }
    }

}
