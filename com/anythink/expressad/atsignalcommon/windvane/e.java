package com.anythink.expressad.atsignalcommon.windvane;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/e.class */
public interface e {
    void loadingResourceStatus(WebView webView, int i);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onProgressChanged(WebView webView, int i);

    void onReceivedError(WebView webView, int i, String str, String str2);

    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void readyState(WebView webView, int i);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
