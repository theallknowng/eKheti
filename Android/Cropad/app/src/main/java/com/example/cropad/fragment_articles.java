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

public class fragment_articles extends Fragment {

    Button marketplace, add_market, expert_article;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articles, container, false);

//        final SharedPreferences sharedpreferences = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);




        expert_article = view.findViewById(R.id.expertarticle);
        expert_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ea = new Intent(getContext(), expertadvice.class);
                startActivity(ea);
            }
        });

        return view;
    }

}
