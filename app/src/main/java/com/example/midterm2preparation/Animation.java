package com.example.midterm2preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {

    AnimationDrawable lightsAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        ImageView imgFrame = (ImageView) findViewById(R.id.imageView);
        imgFrame.setBackgroundResource(R.drawable.animation);

        lightsAnimation = (AnimationDrawable) imgFrame.getBackground();

        Button bttnStart = (Button) findViewById(R.id.bttnStartAnim);
        Button bttnTween = (Button) findViewById(R.id.bttnTween);
        Button bttnStop = (Button) findViewById(R.id.bttnStopAnim);

        bttnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lightsAnimation.start();
            }
        });

        bttnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lightsAnimation.stop();
            }
        });

        bttnTween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lightsAnimation.stop();

                startActivity(new Intent(Animation.this, AnimTween.class));
            }
        });



    }
}