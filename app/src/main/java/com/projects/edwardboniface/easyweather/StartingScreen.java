package com.projects.edwardboniface.easyweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class StartingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_screen);
    }


    public void moveScreenRight(View view) {

        Intent MoveToSecond = new Intent(this, SecondWeatherScreen.class);
        startActivity(MoveToSecond);

    }

    public void moveScreenLeft(View view) {

        Intent MoveToFifth = new Intent(this, FifthWeatherScreen.class);
        startActivity(MoveToFifth);

    }
}