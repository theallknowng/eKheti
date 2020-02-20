package com.example.cropad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import static com.example.cropad.Constants.*;

public class first_page extends AppCompatActivity {

    public Button log_out;
    ViewFlipper v_flip;

    public Button add_market;
    public Button weather;
    public Button inputform;
    public Button marketplace;
    public Button expertarticles;
    private static final String PREF_NAME = "LOGIN";


    public void flipperimage(String image) {
        ImageView imgview = new ImageView(getApplicationContext());
//        imgview.setBackgroundResource(image);
//        Picasso.with(getApplicationContext()).load("http://10.0.4.196:5656/images/barley.jpg").into(imgview);
//        Picasso.with(getApplicationContext()).load(URL_Image+image).into(imgview);
        v_flip.addView(imgview);
        v_flip.setInAnimation(this, android.R.anim.slide_in_left);
        v_flip.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        final SharedPreferences sharedpreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String currentmonth = sdf.format(new Date());
        Integer currentmonthin = Integer.valueOf(currentmonth);

        int rabi[] = {R.drawable.jowar, R.drawable.wheat, R.drawable.peas};
        int kharif[] = {R.drawable.sugar, R.drawable.jowar};

//        v_flip = (ViewFlipper) findViewById(R.id.flipper);

        RequestQueue requestQueue = Volley.newRequestQueue(first_page.this);
        JSONObject jsonObject = new JSONObject();

        final String requestBody = jsonObject.toString();

//        ConnectionManager.sendData(requestBody, requestQueue, URL + "/image", new ConnectionManager.VolleyCallback() {
//            @Override
//            public void onSuccessResponse(String result) {
//                JSONObject jsonObject = null;
//                try {
//                    jsonObject = new JSONObject(result);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                String success = null;
//                JSONArray array = null;
//                try {
//                    success = jsonObject.getString("success");
//                    array = jsonObject.getJSONArray("imageURL");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                if (success.equals("true")) {
//                    int i = 0;
//                    String a;
//                    for (i = 0; i < array.length(); i++) {
//                        try {
//                            a = array.getString(i);
//                            System.out.println("URL" + a);
//                            flipperimage(a);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }
//            }
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                error.printStackTrace();
//
//            }
//        });


//
//        if (currentmonthin >= 04 && currentmonthin <= 10)
//        {
//            for (int i = 0; i < rabi.length; i++) {
//                flipperimage(rabi[i]);
//            }
//
//        }
//
//        else{
//            for (int i = 0; i < kharif.length; i++) {
//                flipperimage(kharif[i]);
//            }
//
//        }

//        marketplace = (Button) findViewById(R.id.market_place);
//        marketplace.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent market = new Intent(first_page.this, Market_list.class);
//                startActivity(market);
//            }
//        });
//
//        inputform = (Button) findViewById(R.id.input_form_but);
//        inputform.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent input = new Intent(first_page.this, Inputform.class);
//                startActivity(input);
//            }
//        });
//
//        log_out = (Button) findViewById(R.id.logout_but);
//        log_out.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.remove(PREF_NAME);
//                editor.apply();
//                Intent l = new Intent(first_page.this, MainActivity.class);
//                startActivity(l);
//                finish();
//            }
//        });
//
//        add_market = (Button) findViewById(R.id.add_market_but);
//        add_market.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent addmkt = new Intent(first_page.this, add_market.class);
//                startActivity(addmkt);
//            }
//        });
//
//        weather = (Button) findViewById(R.id.weather);
//        weather.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent weather_i = new Intent(first_page.this, weather_forecast.class);
//                startActivity(weather_i);
//            }
//        });
//
//        expertarticles = (Button) findViewById(R.id.expert_articles);
//        expertarticles.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent expert = new Intent(first_page.this, expertadvice.class);
//                startActivity(expert);
//            }
//        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new fragment_home();
                            break;
                        case R.id.nav_market:
                            selectedFragment = new FragmentMarket();
                            break;
                        case R.id.nav_articles:
                            selectedFragment = new fragment_articles();
                            break;
                        case R.id.nav_settings:
                            selectedFragment = new fragment_settings();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();


                    return true;

                }


            };
}