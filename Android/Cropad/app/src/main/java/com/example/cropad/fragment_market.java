package com.example.cropad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class fragment_market extends Fragment {

    public Button log_out;
    ViewFlipper v_flip;

    public Button add_market;
    public Button weather;
    public Button inputform;
    public Button marketplace;
    public Button expertarticles;
    private static final String PREF_NAME = "LOGIN";


    public void flipperimage(String image) {
        ImageView imgview = new ImageView(getContext());
//        imgview.setBackgroundResource(image);
//        Picasso.with(getApplicationContext()).load("http://10.0.4.196:5656/images/barley.jpg").into(imgview);
//        Picasso.with(getApplicationContext()).load(URL_Image+image).into(imgview);
        v_flip.addView(imgview);
        v_flip.setInAnimation(getContext(), android.R.anim.slide_in_left);
        v_flip.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market,container,false);

        final SharedPreferences sharedpreferences = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        marketplace = view.findViewById(R.id.nearbymarketplace);
        marketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("this is clicked");
                Intent market = new Intent(getActivity(), Market_list.class);
                startActivity(market);



            }
        });


        add_market = view.findViewById(R.id.addmarket);
        add_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addmkt = new Intent(getContext(), add_market.class);
                startActivity(addmkt);
            }
        });

//        SimpleDateFormat sdf = new SimpleDateFormat("MM");
//        String currentmonth = sdf.format(new Date());
//        Integer currentmonthin = Integer.valueOf(currentmonth);
//
//        int rabi[] = {R.drawable.jowar, R.drawable.wheat, R.drawable.peas};
//        int kharif[] = {R.drawable.sugar, R.drawable.jowar};
//
//        v_flip = (ViewFlipper) view.findViewById(R.id.flipper);
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        JSONObject jsonObject = new JSONObject();
//
//        final String requestBody = jsonObject.toString();
//
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

        return view;
    }

}