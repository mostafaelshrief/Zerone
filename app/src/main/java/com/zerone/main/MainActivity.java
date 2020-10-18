package com.zerone.main;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);

        webview.getSettings().setJavaScriptEnabled(true);

        webview.getSettings().setBuiltInZoomControls(true);

        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);

        webview.loadUrl("http://zerone-team.com/");

        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
            }
        });

        webview.setWebViewClient(new InsideWebViewClient());

    }

    private class InsideWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()){
            webview.goBack();
        }else {
            finish();
        }
    }}
