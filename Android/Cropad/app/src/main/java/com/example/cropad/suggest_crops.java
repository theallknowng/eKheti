package com.example.cropad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Region;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static java.util.Objects.isNull;
import static com.example.cropad.Constants.*;

public class suggest_crops extends AppCompatActivity {


    private static final String PREF_NAME = "LOGIN",PREF_EMAIL="EMAIL",PREF_IRRIGATION="IRRIGATION", PREF_HEALTHID="HEALTHID", PREF_REGION="REGION";

    String healthID=null;
    TextView t1,t2,t3;

    Spanned Text;

    public void Jowar(){
        Intent j = new Intent(this, Jowar.class);
        startActivity(j);
    }
    public void wheat(){
        Intent w = new Intent(this, wheat.class);
        startActivity(w);
    }
    public void bajra(){
        Intent b = new Intent(this, bajra.class);
        startActivity(b);
    }
    public void sugarcane(){
        Intent j = new Intent(this, sugarcane.class);
        startActivity(j);
    }
    public void maize(){
        Intent j = new Intent(this, maize.class);
        startActivity(j);
    }
    public void oilcrops(){
        Intent j = new Intent(this, oilcrops.class);
        startActivity(j);
    }
    public void pulses(){
        Intent j = new Intent(this, pulses.class);
        startActivity(j);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_crops);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);

        TextView textView = findViewById(R.id.textView1);

        String text = "Life Cycle of  Jowar";

        SpannableString ss = new SpannableString(text);

        //  ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

        ClickableSpan cs = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget)
            {
                Jowar();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        // ss.setSpan(fcs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(cs,15,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);

        textView.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView3 = findViewById(R.id.textView3);

        String text3 = "Life Cycle of  Wheat";

        SpannableString ss3 = new SpannableString(text3);

        //  ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

        ClickableSpan cs3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget)
            {
                wheat();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        // ss.setSpan(fcs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss3.setSpan(cs3,15,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView3.setText(ss3);

        textView3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView4 = findViewById(R.id.textView4);

        String text4 = "Life Cycle of  Grapes";

        SpannableString ss4 = new SpannableString(text4);

        //  ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

        ClickableSpan cs4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget)
            {
                bajra();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        // ss.setSpan(fcs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss4.setSpan(cs4,15,21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView4.setText(ss4);

        textView4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView5 = findViewById(R.id.textView5);

        String text5 = "Life Cycle of  Sugarcane";

        SpannableString ss5 = new SpannableString(text5);

        //  ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

        ClickableSpan cs5 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget)
            {
                sugarcane();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        // ss.setSpan(fcs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss5.setSpan(cs5,15,24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView5.setText(ss5);

        textView5.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView6 = findViewById(R.id.textView6);

        String text6 = "Life Cycle of  Maize";

        SpannableString ss6 = new SpannableString(text6);

        //  ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

        ClickableSpan cs6 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget)
            {
                maize();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        // ss.setSpan(fcs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss6.setSpan(cs6,15,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView6.setText(ss6);

        textView6.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView7 = findViewById(R.id.textView7);

        String text7 = "Life Cycle of  Oilseeds";

        SpannableString ss7 = new SpannableString(text7);

        //  ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

        ClickableSpan cs7 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget)
            {
                oilcrops();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        // ss.setSpan(fcs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss7.setSpan(cs7,15,23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView7.setText(ss7);

        textView7.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView8 = findViewById(R.id.textView8);

        String text8 = "Life Cycle of  Pulses";

        SpannableString ss8 = new SpannableString(text8);

        //  ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

        ClickableSpan cs8 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget)
            {
                pulses();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

        // ss.setSpan(fcs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss8.setSpan(cs8,15,21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView8.setText(ss8);

        textView8.setMovementMethod(LinkMovementMethod.getInstance());



        final SharedPreferences sharedpreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        healthID = (sharedpreferences.getString(PREF_HEALTHID,null));
//        System.out.println("hello"+healthID);

        if(healthID.equals("null"))//healthID == "null")
        {
            System.out.println("hello"+healthID);
            final String Region = (sharedpreferences.getString(PREF_REGION,null));
            final String Irrigation = (sharedpreferences.getString(PREF_IRRIGATION,null));

            RequestQueue requestQueue = Volley.newRequestQueue(suggest_crops.this);
            JSONObject jsonObject = new JSONObject();
            try{
                jsonObject.put("region", Region);
                jsonObject.put("irrigation",Irrigation);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            final String requestBody = jsonObject.toString();
            HttpsTrustManager.allowAllSSL();

            ConnectionManager.sendData(requestBody, requestQueue, URL + "/withoutHealthCard", new ConnectionManager.VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                    JSONObject jsonObject= null,users= null;
                    try {
                        jsonObject = new JSONObject(result);
                        users=jsonObject.getJSONObject("result");
                        System.out.println(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String success= null,crop1=null,crop2=null,crop3=null,crop4=null,crop5=null,crop6=null,crop7=null;
                    try {
                        success = jsonObject.getString("success");
                        crop1 = users.getString("Crop1");
                        crop2 = users.getString("Crop2");
                        crop3 = users.getString("Crop3");
                        crop4 = users.getString("Crop4");
                        crop5 = users.getString("Crop5");
                        crop6 = users.getString("Crop6");
                        crop7 = users.getString("Crop7");


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(success.equals("true"))
                    {
                        t1.setText(crop1);
                        t2.setText(crop2);
                        t3.setText(crop3);


                    }

                }

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast toast = Toast.makeText(suggest_crops.this,"Internal Server Error "+error,Toast.LENGTH_LONG);
                    toast.show();

                }
            });


        }
        else
        {
            System.out.println("hello"+healthID);

            RequestQueue requestQueue = Volley.newRequestQueue(suggest_crops.this);
            JSONObject jsonObject = new JSONObject();
            try{
                jsonObject.put("healthID", healthID);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            final String requestBody = jsonObject.toString();
            HttpsTrustManager.allowAllSSL();
            ConnectionManager.sendData(requestBody, requestQueue, URL + "/withHealthCard", new ConnectionManager.VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                    JSONObject jsonObject= null,users= null;
                    try {
                        jsonObject = new JSONObject(result);
                        users=jsonObject.getJSONObject("result");
                        System.out.println(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String success= null,crop1=null,crop2=null,crop3=null,crop4=null,crop5=null,crop6=null,crop7=null;
                    try {
                        success = jsonObject.getString("success");
                        crop1 = users.getString("Crop1");
                        crop2 = users.getString("Crop2");
                        crop3 = users.getString("Crop3");
                        crop4 = users.getString("Crop4");
                        crop5 = users.getString("Crop5");
                        crop6 = users.getString("Crop6");
                        crop7 = users.getString("Crop7");


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(success.equals("true"))
                    {
                        t1.setText(crop1);
                        t2.setText(crop2);
                        t3.setText(crop3);


                    }


                }

                @Override
                public void onErrorResponse(VolleyError error) {
<<<<<<< HEAD
                    Toast toast = Toast.makeText(suggest_crops.this,"Internal Server Error "+error, Toast.LENGTH_LONG);
=======
                    Toast toast = Toast.makeText(suggest_crops.this,"Internal Server Error "+error,Toast.LENGTH_LONG);
>>>>>>> 339badd2c09eff5b3d8596f745612d782e0b6aff
                    toast.show();
                }
            });
        }

    }



}



















