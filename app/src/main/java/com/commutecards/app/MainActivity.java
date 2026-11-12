package com.commutecards.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/** Wraps the Commute Cards page in a full-screen WebView. Everything is bundled, so it works offline. */
public class MainActivity extends Activity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.parseColor("#14161c"));
        web = new WebView(this);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);      // keeps your progress (localStorage)
        s.setDatabaseEnabled(true);
        s.setAllowFileAccess(true);
        s.setTextZoom(100);
        web.setWebViewClient(new WebViewClient());
        setContentView(web);
        if (savedInstanceState != null) web.restoreState(savedInstanceState);
        else web.loadUrl("file:///android_asset/index.html");
    }

    @Override
    protected void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        web.saveState(out);
    }

    @Override
    public void onBackPressed() {
        // Close an open sheet first; otherwise behave normally.
        web.evaluateJavascript(
            "(function(){var m=document.querySelector('.modal-back');if(m){m.remove();return 'closed';}" +
            "var b=document.querySelector('#back')||document.querySelector('#quit');if(b){b.click();return 'nav';}return 'none';})()",
            r -> { if (r != null && r.contains("none")) MainActivity.super.onBackPressed(); });
    }
}
