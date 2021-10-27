package com.projects.edwardboniface.easyweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondWeatherScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_weather_screen);
    }

    public void moveScreenRight(View view) {

        Intent MoveToThird = new Intent(this, ThirdWeatherScreen.class);
        startActivity(MoveToThird);

    }

    public void moveScreenLeft(View view) {

        Intent MoveToStarting = new Intent(this, StartingScreen.class);
        startActivity(MoveToStarting);

    }
    public void moveToSettings(View view) {

        Intent moveToSettings = new Intent(this, SettingsScreen.class);
        startActivity(moveToSettings);

    }
}
