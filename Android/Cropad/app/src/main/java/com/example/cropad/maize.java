package com.example.cropad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class maize extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maize);


        webView = (WebView) findViewById(R.id.webview6);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://ekheti.herokuapp.com/Maize");
    }
}
