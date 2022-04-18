package com.example.midterm2preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Shared_pref extends AppCompatActivity {

    int intYears;
    int intLoan;
    float decInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);


        final EditText years = (EditText) findViewById(R.id.txtYears);
        final EditText loans = (EditText) findViewById(R.id.txtLoans);
        final EditText interest = (EditText) findViewById(R.id.txtInterest);
        final SharedPreferences SharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Button bttn = (Button) findViewById(R.id.button);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intYears = Integer.parseInt(years.getText().toString());
                intLoan = Integer.parseInt(loans.getText().toString());
                decInterest = Float.parseFloat(interest.getText().toString());
                SharedPreferences.Editor editor = SharedPref.edit();

                editor.putInt("key1", intYears);
                editor.putInt("key2", intLoan);
                editor.putFloat("key3", decInterest);
                editor.commit();
                startActivity(new Intent(Shared_pref.this, ShPayment.class));


            }
        });


    }
}