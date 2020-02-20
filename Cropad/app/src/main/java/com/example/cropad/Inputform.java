package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.cropad.Constants.URL;

public class Inputform extends AppCompatActivity {
    private static final String PREF_NAME = "LOGIN";
    Button dataButton;
    EditText crop;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputform);
        final SharedPreferences sharedpreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        EditText datecurrent = findViewById(R.id.date);
        crop=(EditText)findViewById(R.id.Cropname);
        rg=(RadioGroup)findViewById(R.id.irrigationyesno);
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy.MM.dd ");
        String currentdate = sdf.format(new Date());
        datecurrent.setText(currentdate);
        dataButton=(Button) findViewById(R.id.add_data_button);

        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String cropName=crop.getText().toString();
                final String email=sharedpreferences.getString(PREF_NAME,null);
                System.out.println("ALOK Bhai"+email);
                final  String irrigation= ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(Inputform.this);
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("cropName",cropName);
                    jsonObject.put("email",email);
                    jsonObject.put("irrigation",irrigation);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                final String requestBody = jsonObject.toString();
                ConnectionManager.sendData(requestBody, requestQueue, URL+"/irrigationData", new ConnectionManager.VolleyCallback() {
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
                           finish();
                            Intent intent=new Intent(Inputform.this,first_page.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(Inputform.this,"Couldn't Update data...Internal server error",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(Inputform.this,"Could not log in "+error,Toast.LENGTH_LONG);
                        toast.show();
                    }
                });

            }
        });

    }
}
