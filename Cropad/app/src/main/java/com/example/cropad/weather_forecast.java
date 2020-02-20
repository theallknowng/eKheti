package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.example.cropad.Constants.*;


public class weather_forecast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);



        TextView datecurrent = findViewById(R.id.datetime);
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy.MM.dd ");
        String currentdate = sdf.format(new Date());
        datecurrent.setText(currentdate);

        //printing min max temp
        final TextView min,max,precipitation;

        min = (TextView) findViewById(R.id.temperature_min);
        max = (TextView) findViewById(R.id.temperature_max);
        precipitation = (TextView) findViewById(R.id.humidity);

        RequestQueue requestQueue = Volley.newRequestQueue(weather_forecast.this);
        JSONObject jsonObject = new JSONObject();

        final String requestBody = jsonObject.toString();
        ConnectionManager.sendData(requestBody, requestQueue, URL+"/weather", new ConnectionManager.VolleyCallback() {
            @Override
            public void onSuccessResponse(String result) {

                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(result);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

                String minTemp;
                String maxTemp;
                String precipitation_text;
                try {
                    minTemp = jsonObject.getString("minTemp");
                    maxTemp = jsonObject.getString("maxTemp");
                    precipitation_text = jsonObject.getString("text");
                    min.setText(minTemp +" °C");
                    max.setText(maxTemp +" °C");
                    precipitation.setText(precipitation_text);
//                    min.setEnabled(false);
//                    max.setEnabled(false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(weather_forecast.this,"Could not log in "+error,Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
