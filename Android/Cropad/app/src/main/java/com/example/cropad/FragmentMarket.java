package com.example.cropad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentMarket extends Fragment {

    Button marketplace, add_market;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_market, container, false);

//        final SharedPreferences sharedpreferences = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

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

        return view;
    }

}
