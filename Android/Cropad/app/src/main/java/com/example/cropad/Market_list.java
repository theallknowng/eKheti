package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.cropad.Constants.*;

public class Market_list extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<marketdata> marketdataList;
    EditText cropName;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_list);
        recyclerView = findViewById(R.id.market_list_recyclerview);
        btn=findViewById(R.id.marketButton);
        cropName=findViewById(R.id.crop);
        btn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                marketdataList=new ArrayList<>();

                final String crop= cropName.getText().toString();
                RequestQueue requestQueue = Volley.newRequestQueue(Market_list.this);
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("name",crop);
                    jsonObject.put("lat","19.0330");
                    jsonObject.put("long","73.0297");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                final String requestBody = jsonObject.toString();
                int n;
                ConnectionManager.sendData(requestBody, requestQueue, URL+"/markets", new ConnectionManager.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {

                        JSONObject jsonObject= null;
                        try {
                            jsonObject = new JSONObject(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        String success= null;
                        JSONArray array= null;


                        try {
                            success = jsonObject.getString("success");
                            array= jsonObject.getJSONArray("markets");
                            Log.i("ALok",success);
                            Log.d("markets","hi");
                            System.out.println("Hello "+array.length());
//                            n = array.length();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if(success.equals("true")) {
                            int i = 0;
                            String a;

                            for (i = 0; i < array.length(); i++) {
                                try{
                                    marketdataList.add(new marketdata(array.getJSONObject(i).getString("name"),"Rs."+ array.getJSONObject(i).getString("crop_price")+"/Kg",array.getJSONObject(i).getDouble("market_lat"),array.getJSONObject(i).getDouble("market_long"),array.getJSONObject(i).getString("distance")));

                                }
                                catch (JSONException e){
                                    e.printStackTrace();
                                }

                            }
                            LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                            RecyclerView.LayoutManager layoutManager1=layoutManager;
                            MarketAdapter adapter= new MarketAdapter(getApplicationContext(), marketdataList);

                            recyclerView.setLayoutManager(layoutManager1);
                            recyclerView.setAdapter(adapter);
                        }
                        else
                        {
                            Toast.makeText(Market_list.this," Error ",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(Market_list.this,"Could not log in "+error,Toast.LENGTH_LONG);
                        toast.show();
                    }
                });





//                marketdataList=new ArrayList<>();
//                marketdataList.add(new marketdata("Vashi","'Rs.'5000"));
//                marketdataList.add(new marketdata("Vashi","Rs. 5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));
//                marketdataList.add(new marketdata("Vashi","5000"));

//                LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
//                RecyclerView.LayoutManager layoutManager1=layoutManager;
//                MarketAdapter adapter= new MarketAdapter(getApplicationContext(), marketdataList);
//
//                recyclerView.setLayoutManager(layoutManager1);
//                recyclerView.setAdapter(adapter);

            }
        });


    }
}
