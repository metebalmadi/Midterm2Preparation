package com.example.midterm2preparation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeatherAPI extends AppCompatActivity {


    // we"ll make HTTP request to this URL to retrieve weather conditions
    String weatherWebserviceURL = "http://api.openweathermap.org/data/2.5/weather?q=ariana,tn&appid=XXXX&units=metric";
    ImageView weatherBackground;
    // Textview to show temperature and description
    TextView temperature, description, humidity, feelsLike, sunrise, sunset;


    // JSON object that contains weather information
    JSONObject jsonObj;

    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_api);


        //link graphical items to variables
        temperature = (TextView) findViewById(R.id.temperature);
        description = (TextView) findViewById(R.id.description);
        humidity = (TextView) findViewById(R.id.humidity);
        feelsLike = (TextView) findViewById(R.id.feelsLike2);
        weatherBackground = (ImageView) findViewById(R.id.weatherbackground);
        sunrise = (TextView) findViewById(R.id.sunrise);
        sunset = (TextView) findViewById(R.id.sunset);



        Spinner spinner = (Spinner) findViewById(R.id.spinner);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                url = "https://api.openweathermap.org/data/2.5/weather?q="+ spinner.getSelectedItem().toString() +"&appid=a6db16468be1247fe3c436fe88426379&units=metric";
                weather(url);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    public void weather(String url)
    {
        JsonObjectRequest jsonObj =
                new JsonObjectRequest(Request.Method.GET,
                        url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Meteb", "Response received");
                        Log.d("Meteb",  response.toString());
                        try {
                            JSONObject jsonMain = response.getJSONObject("main");
                            JSONObject jsonSystem = response.getJSONObject("sys");

                            double temp = jsonMain.getDouble("temp");
                            Log.d("Meteb-temp", String.valueOf(temp));
                            temperature.setText(String.valueOf(temp));

                            double feels = jsonMain.getDouble("feels_like");
                            Log.d("Meteb-temp", String.valueOf(feels));
                            feelsLike.setText("Feels Like: " + String.valueOf(feels));

                            double hum = jsonMain.getDouble("humidity");
                            Log.d("Meteb-hum", String.valueOf(hum));
                            humidity.setText("Humidity: " + String.valueOf(hum));

                            String town = response.getString("name");
                            Log.d("Meteb-town", town);
                            description.setText(town);

                            // Formatting time
                            long sunrisee = jsonSystem.getLong("sunrise");
                            long sunsett = jsonSystem.getLong("sunset");

                            Log.d("Meteb-sunrise",String.valueOf(sunrise));
                            Log.d("Meteb-sunset",String.valueOf(sunset));


                            DateFormat simple = new SimpleDateFormat("HH:mm");


                            String sunriseString = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(new Date(sunrisee * 1000));

                            String sunsetString = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(new Date(sunsett * 1000));

                            Log.d("Meteb-sunriseFormat", sunriseString);
                            Log.d("Meteb-sunsetFormat", sunsetString);


                            sunrise.setText("Sunrise: "+sunriseString);
                            sunset.setText("Sunset: "+sunsetString);













                            /* sub categories as JSON arrays */
                            JSONArray jsonArray = response.getJSONArray("weather");
                            for (int i=0; i<jsonArray.length();i++){
                                Log.d("Meteb-array",jsonArray.getString(i));
                                JSONObject oneObject = jsonArray.getJSONObject(i);
                                String weather =
                                        oneObject.getString("main");
                                Log.d("Meteb-w",weather);

                                if(weather.equals("Clouds"))
                                {
                                    Glide.with(WeatherAPI.this)
                                            .load("https://i.picsum.photos/id/866/536/354.jpg?hmac=tGofDTV7tl2rprappPzKFiZ9vDh5MKj39oa2D--gqhA")
                                            .into(weatherBackground);
                                }else if (weather.equals("Clear"))
                                {
                                    Glide.with(WeatherAPI.this)
                                            .load("https://images.pexels.com/photos/281260/pexels-photo-281260.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260")
                                            .into(weatherBackground);
                                }else if (weather.equals("Rainy"))
                                {
                                    Glide.with(WeatherAPI.this)
                                            .load("https://images.pexels.com/photos/125510/pexels-photo-125510.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                                            .into(weatherBackground);
                                }else
                                    Glide.with(WeatherAPI.this)
                                            .load("https://images.pexels.com/photos/1118873/pexels-photo-1118873.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                                            .into(weatherBackground);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("Receive Error", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Meteb", "Error retrieving URL");
                    }


                });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObj);

    }


}