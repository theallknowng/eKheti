package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Region;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_crops);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);


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
                    Toast toast = Toast.makeText(suggest_crops.this,"Internal Server Error "+error,Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        }

    }



}
