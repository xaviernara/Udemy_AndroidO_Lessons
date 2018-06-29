package com.example.xaviernara.webviewsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);

        //THIS gets the settings from the website page and the javascript and enbale it or not
        webView.getSettings().setJavaScriptEnabled(true);

        //this basically says I want the webpage to presented on the app screen
        webView.setWebViewClient(new WebViewClient());

        //this loads the url to te app
        //webView.loadUrl("http://www.google.com");

        //this line lets you write html or whatever web based code to make a website and directly display it on the app
        //you have to identify which language you use and the encoding
        //webView.loadData(data:"html code", mimeType:"text/html",encoding:"UTF-8")
        webView.loadData("<html><body><h1>hello world</h1><p>This is basic html code!</p></body></html>","text/html","UTF-8");

    }
}
