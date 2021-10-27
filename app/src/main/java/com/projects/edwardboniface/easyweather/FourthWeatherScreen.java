package com.projects.edwardboniface.easyweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FourthWeatherScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_weather_screen);
    }

    public void moveScreenRight(View view) {

        Intent MoveToFifth = new Intent(this, FifthWeatherScreen.class);
        startActivity(MoveToFifth);

    }

    public void moveScreenLeft(View view) {

        Intent MoveToThird = new Intent(this, ThirdWeatherScreen.class);
        startActivity(MoveToThird);

    }
    public void moveToSettings(View view) {

        Intent moveToSettings = new Intent(this, SettingsScreen.class);
        startActivity(moveToSettings);

    }
}