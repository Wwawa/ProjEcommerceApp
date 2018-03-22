package com.oum.projecommerceapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         webView = findViewById(R.id.webview);

        //Setting URL to the webView
        webView.loadUrl("http://192.168.1.157:8080/Ecommerce/");

        //Setting the client view for open the webcontent in same view,

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request ){
                view.loadUrl(request.getUrl().toString());
                return false;

            }

        });

    }

    public void onBackPressed(){
        if(webView.canGoBack()) {
            webView.goBack();
        } else{
            super.onBackPressed();
        }
    }
}
