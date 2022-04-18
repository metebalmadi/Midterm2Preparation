package com.example.midterm2preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ShPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sh_payment);


        TextView monthlyPayment = (TextView) findViewById(R.id.textView2Splash);
        ImageView img = (ImageView) findViewById(R.id.imageView2);

        SharedPreferences SharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        int intYears = SharedPref.getInt("key1",0);
        int intLoan = SharedPref.getInt("key2",0);
        float decInterest = SharedPref.getFloat("key3",0);

        float decMonthlyPayment = (intLoan * (1 + (decInterest*intYears))/(12*intYears));
        DecimalFormat curr = new DecimalFormat("$###,###.##");
        monthlyPayment.setText("Monthly Payment " + curr.format(decMonthlyPayment));








    }
}