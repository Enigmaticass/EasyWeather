package com.projects.edwardboniface.easyweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FifthWeatherScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_weather_screen);
    }

    public void moveScreenRight(View view) {

        Intent MoveToStarting = new Intent(this, StartingScreen.class);
        startActivity(MoveToStarting);

    }

    public void moveScreenLeft(View view) {

        Intent MoveToFourth = new Intent(this, FourthWeatherScreen.class);
        startActivity(MoveToFourth);

    }
}
