package com.projects.edwardboniface.easyweather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

    }

    public void moveFromSettings(View view) {

        Intent moveFromSettings = new Intent(this, StartingScreen.class);
        startActivity(moveFromSettings);

    }

}