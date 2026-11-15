package com.reborn.fieldmate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/** Standalone local-only UI preview. No remote content is allowed in the app WebView. */
public final class MainActivity extends Activity {
    private WebView view;

    private final class SafeExternalBridge {
        @JavascriptInterface
        public void openDial(String value) {
            final String cleaned = value == null ? "" : value.replaceAll("[^+0-9]", "");
            if (cleaned.isEmpty() || cleaned.length() > 24) return;
            runOnUiThread(() -> openIntent(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + cleaned))));
        }

        @JavascriptInterface
        public void openMaps(String address) {
            if (address == null || address.trim().isEmpty() || address.length() > 500) return;
            final Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
            runOnUiThread(() -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) == null) {
                    intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode(address)));
                }
                openIntent(intent);
            });
        }
    }

    private void openIntent(Intent intent) {
        try { startActivity(intent); } catch (Exception ignored) { /* no handler installed */ }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(242,250,247));
        getWindow().setNavigationBarColor(Color.rgb(250,254,251));
        getWindow().getDecorView().setSystemUiVisibility(android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        view = new WebView(this);
        view.setBackgroundColor(Color.rgb(245,250,248));
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setDomStorageEnabled(true);
        view.getSettings().setAllowFileAccess(true);
        view.getSettings().setAllowFileAccessFromFileURLs(false);
        view.getSettings().setAllowUniversalAccessFromFileURLs(false);
        view.addJavascriptInterface(new SafeExternalBridge(), "AndroidBridge");
        view.setWebChromeClient(new WebChromeClient());
        view.setWebViewClient(new WebViewClient() {
            @Override public boolean shouldOverrideUrlLoading(WebView w, WebResourceRequest request) {
                Uri uri = request.getUrl();
                String url = uri.toString();
                if (url.startsWith("file:///android_asset/")) return false;
                openIntent(new Intent(Intent.ACTION_VIEW, uri));
                return true;
            }
        });
        setContentView(view);
        view.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (view == null) { super.onBackPressed(); return; }
        view.evaluateJavascript("Boolean(window.Reborn && window.Reborn.canGoBack())", result -> {
            if ("true".equals(result)) view.evaluateJavascript("window.Reborn.back()", null);
            else finish();
        });
    }
}
