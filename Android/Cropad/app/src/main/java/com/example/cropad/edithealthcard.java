package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

public class edithealthcard extends AppCompatActivity {


    private EditText phmin,phmax,nmin,nmax,pmin,pmax,kmin,kmax,camin,camax,mgmin,mgmax,smin,smax,femin,femax,znmin,znmax,mnmin,mnmax,cumin,cumax,bmin,bmax,tempmin,tempmax,pptmin,pptmax;

    private Button save;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edithealthcard);



        phmin = (EditText)findViewById(R.id.pH);
        phmax = (EditText)findViewById(R.id.pHmax);
        nmin = (EditText)findViewById(R.id.N);
        nmax = (EditText)findViewById(R.id.Nmax);
        pmin = (EditText)findViewById(R.id.P);
        pmax = (EditText)findViewById(R.id.Pmax);
        kmin = (EditText)findViewById(R.id.K);
        kmax = (EditText)findViewById(R.id.Kmax);
        camin = (EditText)findViewById(R.id.Ca);
        camax = (EditText)findViewById(R.id.Camax);
        mgmin = (EditText)findViewById(R.id.Mg);
        mgmax = (EditText)findViewById(R.id.Mgmax);
        smin = (EditText)findViewById(R.id.S);
        smax = (EditText)findViewById(R.id.Smax);
        femin = (EditText)findViewById(R.id.Fe);
        femax = (EditText)findViewById(R.id.Femax);
        znmin = (EditText)findViewById(R.id.Zn);
        znmax = (EditText)findViewById(R.id.Znmax);
        mnmin = (EditText)findViewById(R.id.Mn);
        mnmax = (EditText)findViewById(R.id.Mnmax);
        cumin = (EditText)findViewById(R.id.Cu);
        cumax = (EditText)findViewById(R.id.Cumax);
        bmin = (EditText)findViewById(R.id.B);
        bmax = (EditText)findViewById(R.id.Bmax);
        tempmin = (EditText)findViewById(R.id.temp);
        tempmax = (EditText)findViewById(R.id.tempmax);
        pptmin = (EditText)findViewById(R.id.ppt);
        pptmax = (EditText)findViewById(R.id.pptmax);

        save = (Button)findViewById(R.id.savebtn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Phmin = phmin.getText().toString();
                final String Phmax = phmax.getText().toString();
                final String Nmin = nmin.getText().toString();
                final String Nmax = nmax.getText().toString();
                final String Pmin = pmin.getText().toString();
                final String Pmax = pmax.getText().toString();
                final String Kmin = kmin.getText().toString();
                final String Kmax = kmax.getText().toString();
                final String Camin = camin.getText().toString();
                final String Camax = camax.getText().toString();
                final String Mgmin = mgmin.getText().toString();
                final String Mgmax = mgmax.getText().toString();
                final String Smin = smin.getText().toString();
                final String Smax = smax.getText().toString();
                final String Femin = femin.getText().toString();
                final String Femax = femax.getText().toString();
                final String Znmin = znmin.getText().toString();
                final String Znmax = znmax.getText().toString();
                final String Mnmin = mnmin.getText().toString();
                final String Mnmax = mnmax.getText().toString();
                final String Cumin = cumin.getText().toString();
                final String Cumax = cumax.getText().toString();
                final String Bmin = bmin.getText().toString();
                final String Bmax = bmax.getText().toString();
                final String Tempmin = tempmin.getText().toString();
                final String Tempmax = tempmax.getText().toString();
                final String Pptmin = pptmin.getText().toString();
                final String Pptmax = pptmax.getText().toString();


                RequestQueue requestQueue = Volley.newRequestQueue(edithealthcard.this);
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("phMin",Phmin);
                    jsonObject.put("phMax",Phmax);
                    jsonObject.put("nitrogenMin",Nmin);
                    jsonObject.put("nitrogenMax",Nmax);
                    jsonObject.put("phosphorusMin",Phmin);
                    jsonObject.put("phosphorusMax",Phmax);
                    jsonObject.put("potassiumMin",Kmin);
                    jsonObject.put("potassiumMax",Kmax);
                    jsonObject.put("calciumMin",Camin);
                    jsonObject.put("calciumMax",Camax);
                    jsonObject.put("magnesiumMin",Mgmin);
                    jsonObject.put("magnesiumMax",Mgmax);
                    jsonObject.put("sulphurMin",Smin);
                    jsonObject.put("sulphurMax",Smax);
                    jsonObject.put("ironMin",Femin);
                    jsonObject.put("ironMax",Femax);
                    jsonObject.put("zincMin",Znmin);
                    jsonObject.put("zincMax",Znmax);
                    jsonObject.put("manganeseMin",Mnmin);
                    jsonObject.put("manganeseMax",Mnmax);
                    jsonObject.put("copperMin",Cumin);
                    jsonObject.put("copperMax",Cumax);
                    jsonObject.put("boronMin",Bmin);
                    jsonObject.put("boronMax",Bmax);
                    jsonObject.put("temperatureMin",Tempmin);
                    jsonObject.put("temperatureMax",Tempmax);
                    jsonObject.put("precipitationMin",Pptmin);
                    jsonObject.put("precipitationMax",Pptmax);


                }
                catch(Exception e){
                    e.printStackTrace();
                }
                final String requestBody = jsonObject.toString();
                HttpsTrustManager.allowAllSSL();

                ConnectionManager.sendData(requestBody, requestQueue, "https://192.168.43.32:3000/user/healthCard", new ConnectionManager.VolleyCallback() {
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

                        if(success.equals("true"))
                        {
                            Toast toast = Toast.makeText(edithealthcard.this,"Data sent ",Toast.LENGTH_LONG);
                            toast.show();
                        }

                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast toast = Toast.makeText(edithealthcard.this,"Data lost"+error,Toast.LENGTH_LONG);
                        toast.show();

                    }
                });


            }
        });







    }
}
