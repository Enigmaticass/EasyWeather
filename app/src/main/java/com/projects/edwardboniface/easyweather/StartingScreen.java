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


    public void moveScreen(View view) {

        Intent intent = new Intent(this, StartingScreen.class);

    }
}