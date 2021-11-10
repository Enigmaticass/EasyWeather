package com.projects.edwardboniface.easyweather;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class WeatherApp extends AppCompatActivity {
    EditText enter_country, enter_city;
    TextView tvResult;
    private final String url = "http://api.openweathermap.org/data/2.5/weather";
    private final String appid = "f3bf7dec38609510026b6f322de3f311";
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_app);
        enter_city = findViewById(R.id.enter_city);
        enter_country = findViewById(R.id.enter_country);
        tvResult = findViewById(R.id.tvResult);
        enter_city.setTextColor(Color.rgb(255,255,255));
        enter_country.setTextColor(Color.rgb(255,255,255));

    }

    public void getWeatherDetails(View view) {
        String tempUrl = "";
        String city = enter_city.getText().toString().trim();
        String country = enter_country.getText().toString().trim();
        if(city.equals("")){
            tvResult.setText("City Field Must Have A Value");
        }else{
            if(!country.equals("")){
                tempUrl = url + "?q=" + city + "," + country + "&appid=" + appid;
            }else{
                tempUrl = url + "?q=" + city + "&appid=" + appid;
            }
            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response){
                    //Log.d("response", response);
                    String output = "";
                    try {
                        //converting JSON response from website into object
                        JSONObject jsonResponse = new JSONObject(response);
                        //Call the Weather Method from JSON file
                        JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                        //Get the data from the weather JSON
                        JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                        //Get the string "description" from JSON
                        String description = jsonObjectWeather.getString("description");
                        //Go into the Main part of JSON file
                        JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                        //Find temperature in JSON and take away 273.15 to get degrees celcius
                        double temp = jsonObjectMain.getDouble("temp") - 273.15;
                        //Find what the temperature feels like in JSON and take away 273.15 to get degrees celcius
                        double feelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;
                        //Find the air pressure from the JSON file
                        float pressure = jsonObjectMain.getInt("pressure");
                        //find the humidity from the JSON file
                        int humidity = jsonObjectMain.getInt("humidity");
                        //Go into the wind section fo the JSON file
                        JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                        //Get the Windspeed from json file
                        String wind = jsonObjectWind.getString("speed");
                        //Go into the clouds section of JSON file
                        JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                        //Get the cloudiness percentage from the JSON file
                        String clouds = jsonObjectClouds.getString("all");
                        //Go into the sys seection of the JSON file
                        JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                        //Get the country name from the JSON file
                        String countryName = jsonObjectSys.getString("country");
                        //Get the city name from the JSON file
                        String cityName = jsonResponse.getString("name");
                        //Set the text colour to
                        tvResult.setTextColor(Color.rgb(255,255,255));
                        //Set the output
                        output += "Current weather of " + cityName + " (" + countryName + ")"
                            + "\n Temp: " + df.format(temp) + " °C"
                            + "\n Feels Like: " + df.format(feelsLike) + " °C"
                            + "\n Humidity: " + humidity + "%"
                            + "\n Description: " + description
                            + "\n Wind Speed: " + wind + "m/s"
                            + "\n Cloudiness: " + clouds + "%"
                            + "\n Pressure: " + pressure + "hPa";
                        //Assign the output to the text view result
                        tvResult.setText(output);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }

    }
}
