package com.reborn.fieldmate;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
public class MainActivity extends Activity {
 private WebView view;
 @Override public void onCreate(Bundle b){super.onCreate(b);view=new WebView(this);view.getSettings().setJavaScriptEnabled(true);view.getSettings().setDomStorageEnabled(true);view.setWebViewClient(new WebViewClient());view.setWebChromeClient(new WebChromeClient());setContentView(view);view.loadUrl("file:///android_asset/index.html");}
 @Override public void onBackPressed(){if(view.canGoBack())view.goBack();else super.onBackPressed();}
}
