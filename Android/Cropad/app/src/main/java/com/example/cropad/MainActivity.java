package com.example.cropad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import static com.example.cropad.Constants.*;

public class MainActivity extends AppCompatActivity {

    public Button registe;
    public Button login;
    public Button test;
    String passvalue;
    String url="http://10.0.4.248:5656/user/login";
    private EditText user,p;
    private static final String PREF_NAME = "LOGIN",PREF_EMAIL="EMAIL",PREF_IRRIGATION="IRRIGATION", PREF_HEALTHID="HEALTHID", PREF_REGION="REGION";

    public void firstpag(){
        Intent fp = new Intent(MainActivity.this, first_page.class);
        startActivity(fp);
    }

    public void registerform(){
        Intent r = new Intent(this, registration_page.class);
        startActivity(r);
    }

    public void testing(){
        Intent tes = new Intent(this, first_page.class);
        startActivity(tes);
        MainActivity.this.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView2);

        String text = "If you are a new user , please REGISTER HERE ";

        SpannableString ss = new SpannableString(text);

      //  ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

        ClickableSpan cs = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget)
            {
                registerform();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };

       // ss.setSpan(fcs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(cs,31,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);

        textView.setMovementMethod(LinkMovementMethod.getInstance());



        final SharedPreferences sharedpreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);


        user = (EditText) findViewById(R.id.email_id);
        p = (EditText) findViewById(R.id.password);

//       registe = (Button) findViewById(R.id.register_but);
//        registe.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                registerform();
//
//            }
//        });

//        test = (Button) findViewById(R.id.test_but);
//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                testing();
//            }
//        });

        login = (Button) findViewById(R.id.login_but);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String username = user.getText().toString();
                final String Password = p.getText().toString();
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("email",username);
                    jsonObject.put("pass",Password);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                final String requestBody = jsonObject.toString();
                HttpsTrustManager.allowAllSSL();
                ConnectionManager.sendData(requestBody, requestQueue, URL+"/login", new ConnectionManager.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {

                        JSONObject jsonObject= null,users= null;
                        try {
                            jsonObject = new JSONObject(result);
                            users=jsonObject.getJSONObject("user");
                            System.out.println(jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        String success= null,irrigation=null,email=null,healthid=null,region=null;
                        try {
                            success = jsonObject.getString("success");
                            if(success.equals("true")) {
                                irrigation = users.getString("irrigation");
                                email = users.getString("email");
                                healthid = users.getString("healthID");
                                region = users.getString("region");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if(success.equals("true")){
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString(PREF_EMAIL,email);
                            editor.putString(PREF_IRRIGATION,irrigation);
                            editor.putString(PREF_HEALTHID,healthid);
                            editor.putString(PREF_REGION,region);
//                            editor.apply();
                            editor.commit();
//                            String test = sharedpreferences.getString(PREF_EMAIL, null);
//                            Log.d("SharedPref test",test );
                            System.out.println("Alok");
                            System.out.println("Hi"+healthid);
                            firstpag();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(MainActivity.this,"Could not log in "+error,Toast.LENGTH_LONG);
                        toast.show();
                    }
                });


            }
        });

    }

//    @Override
//    protected void onPause()
//    {
//        super.onPause();
//        MainActivity.this.finish();
//    }




}
