package com.dev.rahul.liboio.utility;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by rahul on 11/2/18.
 */

public class CustomWebViewClient extends WebViewClient {

    public static final String TAG = CustomWebViewClient.class.getSimpleName();

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.e(TAG, "shouldOverrideUrlLoading dep url : " + url);
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
        customTabsIntent.launchUrl(view.getContext(), Uri.parse(url));
        return true;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Log.e(TAG, "shouldOverrideUrlLoading url : " + request.getUrl());
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
        customTabsIntent.launchUrl(view.getContext(), request.getUrl());
        return true;
        //return super.shouldOverrideUrlLoading(view,request);
    }
}