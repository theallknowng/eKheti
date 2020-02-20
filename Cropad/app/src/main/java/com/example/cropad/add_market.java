package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import static com.example.cropad.Constants.*;

public class add_market extends AppCompatActivity {

    private TextView lat,longi,cityname,marketname;
    private Button addmarket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_market);

        lat = findViewById(R.id.getlocationlati);
        longi = findViewById(R.id.getlocationlongi);
        cityname = findViewById(R.id.name_city);
        addmarket = findViewById(R.id.add_market);
        marketname = findViewById(R.id.market_name);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1000);
        }
        else{
            LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
            final Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            lat.setText(""+latitude);
            longi.setText(""+longitude);
            cityname.setText(hereLocation(latitude,longitude));
            cityname.setEnabled(false);
            addmarket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String Name = marketname.getText().toString();
                    final String cityName = cityname.getText().toString();
                    final String Latitude = lat.getText().toString();
                    final String Longitude = longi.getText().toString();
                    String url = "http://10.0.4.248:5656/user/marketRegister";
                    RequestQueue requestQueue = Volley.newRequestQueue(add_market.this);
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("name", Name);
                        jsonObject.put("lat", Latitude);
                        jsonObject.put("long", Longitude);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    final String requestBody = jsonObject.toString();
                    ConnectionManager.sendData(requestBody, requestQueue, URL+"/marketRegister", new ConnectionManager.VolleyCallback() {
                        @Override
                        public void onSuccessResponse(String result) {
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(result);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            String success = null;
                            try {
                                success = jsonObject.getString("success");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            if (success.equals("true")) {
                                Intent i = new Intent(add_market.this, first_page.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(add_market.this, "Could not register", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast toast = Toast.makeText(add_market.this, "Internal Server Error " + error, Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            });

        }
    }

    private String hereLocation(double lat, double lon){
        String cityName="";
        Geocoder geocoder=new Geocoder(this, Locale.getDefault());
        List<Address> addresses;
        try{
            addresses=geocoder.getFromLocation(lat,lon,10);
            System.out.println(Arrays.toString(addresses.toArray()));
            if(addresses.size()>0){
                for (Address adr: addresses){
                    if( adr.getLocality() !=null && adr.getLocality().length() >0){
                        cityName=adr.getLocality();
                        break;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();

        }
        return cityName;

    }
}
