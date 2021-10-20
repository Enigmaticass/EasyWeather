package com.projects.edwardboniface.easyweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdWeatherScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_weather_screen);
    }

    public void moveScreenRight(View view) {

        Intent MoveToFourth = new Intent(this, FourthWeatherScreen.class);
        startActivity(MoveToFourth);

    }

    public void moveScreenLeft(View view) {

        Intent MoveToSecond = new Intent(this, SecondWeatherScreen.class);
        startActivity(MoveToSecond);

    }
}
