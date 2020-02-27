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
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
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

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import static com.example.cropad.Constants.*;

public class registration_page extends AppCompatActivity {

    public Button regisd;
    private EditText firstname,lastname,email,p,cp,hT,contact,healthid;
    private RadioGroup rg;

    public void login(){
        Intent regis =  new Intent(this, MainActivity.class);
        startActivity(regis);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        email=findViewById((R.id.email_id));
        p=findViewById(R.id.password);
        cp=findViewById(R.id.confirm_password);
        hT=findViewById(R.id.hometown);
        contact=findViewById(R.id.contact);
        healthid=findViewById(R.id.Hid);
        regisd = (Button) findViewById(R.id.register);
        rg=(RadioGroup)findViewById(R.id.irrigationyesno);


        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1000);
        }
        else {

            LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
            final Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            String city=hereLocation(location.getLatitude(),location.getLongitude());
            Log.i("ALok-city",city);
//            hT.setText(city);
         //   hT.setEnabled(false);
            regisd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (checkDataEntered()) {
                        final String FirstName = firstname.getText().toString();
                        final  String irrigation= ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                        final String LastName = lastname.getText().toString();
                        final String Email = email.getText().toString();
                        final String Hometown = hT.getText().toString();
                        final String Password = p.getText().toString();
                        final String Contact= contact.getText().toString();
                        final String HealthID = healthid.getText().toString();
                        RequestQueue requestQueue = Volley.newRequestQueue(registration_page.this);
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("firstname", FirstName);
                            jsonObject.put("lastname", LastName);
                            jsonObject.put("email_id", Email);
                            jsonObject.put("password", Password);
                            jsonObject.put("contact",Contact);
                            jsonObject.put("region", Hometown);
                            jsonObject.put("irrigation", irrigation);

                           // jsonObject.put("home_long", location.getLongitude());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        final String requestBody = jsonObject.toString();
                        HttpsTrustManager.allowAllSSL();
                        ConnectionManager.sendData(requestBody, requestQueue, URL+"/register", new ConnectionManager.VolleyCallback() {
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
                                    Intent i = new Intent(registration_page.this, MainActivity.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(registration_page.this, "Could not register", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast toast = Toast.makeText(registration_page.this, "Internal Server Error " + error, Toast.LENGTH_LONG);
                                toast.show();

                            }
                        });


                    }

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

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isPassword(EditText text,EditText text2) {

        return text.equals(text2);

    }


    boolean checkDataEntered() {
        int c=1;
        if (isEmpty(firstname)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
            c=0;
        }
        if (isEmpty(lastname)) {
            Toast t = Toast.makeText(this, "You must enter last name to register!", Toast.LENGTH_SHORT);
            t.show();
            c=0;
        }


        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
            c=0;
        }
        if (isEmpty(p)){
            p.setError("Enter password");
            c=0;
        }
//        if(!isPassword(p,cp)){
//            cp.setError("Password don't match");
//            c=0;
//        }
        if(isEmpty(hT)){
            hT.setError("Enter Hometown");
            c=0;
        }
        Log.i("Alok-Register","c");
        System.out.println(p);
        System.out.println(cp);
        if(c==1){
            return true;
        }
        else
            return false;
    }
}
