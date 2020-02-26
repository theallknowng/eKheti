package com.example.cropad;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {

    private Context context;
    private ArrayList<marketdata> dataList;

    public MarketAdapter(Context context, ArrayList<marketdata> dataList){
        this.context=context;
        this.dataList= dataList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.market_item,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ImageView markImg=holder.markImg;
        TextView markName=holder.markName;
        TextView cropPrice=holder.cropPrice;
        final double lat = dataList.get(position).getLat();
        final double lon = dataList.get(position).getLon();
//        Log.d("Lat",lat);
//        Log.d("lon",lon);
//        cropPrice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "hello ", Toast.LENGTH_LONG).show();
//
//            }
//        });

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f", lat,lon);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // Intent intent=new Intent(context,MainActivity.class);
                context.startActivity(intent);
            }
        });

        markName.setText(dataList.get(position).getMarketName());
        cropPrice.setText(dataList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView markImg;
        TextView markName,cropPrice;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            markImg=itemView.findViewById(R.id.marketImage);
            markName=itemView.findViewById(R.id.marketName);
            cropPrice=itemView.findViewById(R.id.marketPrice);
            linearLayout = itemView.findViewById(R.id.market_item);
        }
    }
}
