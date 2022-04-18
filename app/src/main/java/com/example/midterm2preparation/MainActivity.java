package com.example.midterm2preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bttnToGrid = (Button) findViewById(R.id.bttnToGrid);
        Button bttnToDate = (Button) findViewById(R.id.bttnToDate);
        Button bttnToAnim = (Button) findViewById(R.id.bttnToAnim);

        Button bttnToSharedP = (Button) findViewById(R.id.bttnToSharedP);
        Button bttnToDB = (Button) findViewById(R.id.bttnToDB);
        Button bttnToToast = (Button) findViewById(R.id.bttnToToast);
        Button bttnToWeather = (Button) findViewById(R.id.bttnToWeather);
        Button bttnToSplash = (Button) findViewById(R.id.bttnToSplash);


        bttnToGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Grid_view.class));
            }
        });

        bttnToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Date_picker.class));
            }
        });

        bttnToAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Animation.class));
            }
        });

        bttnToSharedP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Shared_pref.class));
            }
        });

        bttnToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DBActivity.class));
            }
        });

        bttnToToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ColorToast.class));
            }
        });
        bttnToWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WeatherAPI.class));
            }
        });

        bttnToSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SplashV2.class));
            }
        });

    }
}