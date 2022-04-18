package com.example.midterm2preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimTween extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_tween);


        ImageView img = (ImageView) findViewById(R.id.imageView2);
        img.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation));
    }
}