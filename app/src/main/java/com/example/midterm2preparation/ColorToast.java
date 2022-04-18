package com.example.midterm2preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ColorToast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_toast);



        Button bttnInfo = (Button) findViewById(R.id.bttnInfo);
        Button bttnSuccess = (Button) findViewById(R.id.bttnSuccess);
        Button bttnError = (Button) findViewById(R.id.bttnError);


        bttnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toasty.info(getBaseContext(), "This is an info toast.", Toast.LENGTH_SHORT, true).show();
            }
        });

        bttnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toasty.success(getBaseContext(), "Success.", Toast.LENGTH_SHORT, true).show();

            }
        });


        bttnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toasty.error(getBaseContext(), "This is an error toast.", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}