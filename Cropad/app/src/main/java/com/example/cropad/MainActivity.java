package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private static final String PREF_NAME = "LOGIN";


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
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences sharedpreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);


        user = (EditText) findViewById(R.id.email_id);
        p = (EditText) findViewById(R.id.password);

        registe = (Button) findViewById(R.id.register_but);
        registe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                registerform();

            }
        });

        test = (Button) findViewById(R.id.test_but);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testing();
            }
        });

        login = (Button) findViewById(R.id.login_but);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String username = user.getText().toString();
                final String Password = p.getText().toString();
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("email_id",username);
                    jsonObject.put("password",Password);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                final String requestBody = jsonObject.toString();
                ConnectionManager.sendData(requestBody, requestQueue, URL+"/login", new ConnectionManager.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {

                        JSONObject jsonObject= null;
                        try {
                            jsonObject = new JSONObject(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        String success= null;
                        try {
                            success = jsonObject.getString("success");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if(success.equals("true")){
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString(PREF_NAME,username);
                            editor.apply();
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


}
