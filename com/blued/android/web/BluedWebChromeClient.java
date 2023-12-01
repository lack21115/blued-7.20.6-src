package com.blued.android.web;

import android.net.Uri;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/web/BluedWebChromeClient.class */
public class BluedWebChromeClient extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Tracker.onProgressChanged(this, webView, i);
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return false;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    @Override // android.webkit.WebChromeClient
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
    }
}
